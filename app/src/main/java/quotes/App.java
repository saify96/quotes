package quotes;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import com.google.gson.Gson;

public class App {
    public static void main(String[] args) {
        Path path = Paths.get("../resources/recentquotes.json");
        StringBuilder jsonString = new StringBuilder();
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line = reader.readLine();
            jsonString.append(line);
            while (line != null) {
                line = reader.readLine();
                jsonString.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(jsonString);
        Gson gson = new Gson();
        Quotes[] listOfObjects = gson.fromJson(jsonString.toString(), Quotes[].class);
        System.out.println(listOfObjects[1]);
    }
}


//        Path path = Paths.get("../resources/recentquotes.json");
//        StringBuilder jsonString = new StringBuilder();
//        try (BufferedReader reader = Files.newBufferedReader(path)) {
//            String line = reader.readLine();
//            jsonString.append(line);
//            while (line != null) {
//                line = reader.readLine();
//                jsonString.append(line);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        System.out.println(jsonString);
//
//        Gson gson = new Gson();


//        gson.fromJson(String.valueOf(jsonString), Quotes[].class);


//        JSONObject jsonObj = new JSONObject(jsonString.toString());


//        ArrayList<Quotes> listOFObjects = new ArrayList<>();
//        listOFObjects.add();


//        Gson gson = new Gson();
//    Scanner scanner = new Scanner(new File("../resources/recentquotes.json"));
//    StringBuilder string = new StringBuilder();
//        while (scanner.hasNextLine()) {
//                string.append(scanner.nextLine());
//                }
//                Quotes[] listOfObjects = gson.fromJson(string.toString(), Quotes[].class);
//        System.out.println(listOfObjects[0]);