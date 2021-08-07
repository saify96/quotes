package quotes;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;

public class App {
    public static void main(String[] args) {
        System.out.println(randomQuote());
    }
    public static String randomQuote()  {
        ArrayList<Quotes> quotes =null;
        Gson gson =new Gson();
        try {
            FileReader reader = new FileReader("recentquotes.json");
            Type quotesList = new TypeToken<ArrayList<Quotes>>(){}.getType();
            quotes =gson.fromJson(reader,quotesList);
            int idx = (int) (quotes.size() * Math.random());
            return quotes.get(idx).toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
