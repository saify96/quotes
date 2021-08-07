package quotes;

import java.io.*;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;

public class App {
    public static void main(String[] args) {
        String api = "http://api.forismatic.com/api/1.0/?method=getQuote&format=json&lang=en";
        try {
            URL url = new URL(api);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");
            int response = connection.getResponseCode();
            InputStream inputStream = connection.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String line = bufferedReader.readLine();
            if (response == 200) {
                while (line != null) {
                    System.out.println(line);
                    line = bufferedReader.readLine();
                }
                bufferedReader.close();
            } else {
                System.out.println(randomQuote());
            }
            connection.disconnect();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String randomQuote() {
        ArrayList<Quotes> quotes = null;
        Gson gson = new Gson();
        try {
            FileReader reader = new FileReader("recentquotes.json");
            Type quotesList = new TypeToken<ArrayList<Quotes>>() {
            }.getType();
            quotes = gson.fromJson(reader, quotesList);
            int idx = (int) (quotes.size() * Math.random());
            return quotes.get(idx).toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}

