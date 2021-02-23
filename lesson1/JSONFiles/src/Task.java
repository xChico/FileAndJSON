import com.github.cliftonlabs.json_simple.JsonArray;
import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.Jsoner;
import jdk.nashorn.internal.parser.JSONParser;



import java.io.*;

public class Task {
    public static void main(String[] args) {
        Task t = new Task();
        JsonObject doc = t.readJson("./resources/restaurant-data.json");
        Database db = new Database(doc);
        System.out.println(db.getRestaurant("Hometown BBQ"));
        System.out.println(db.getAvgReviews("Casa Enrique"));
    }

    public JsonObject readJson(String filename) {
        JsonObject document = (JsonObject) Jsoner.deserialize(readFile(filename), new JsonObject());
        return document;
    }




    /* TODO: create a JSON object with the contents of  "filename". You can use the method below to help you read the file. */


    public String readFile(String filename) {
        String content = "";
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String lines = reader.readLine();
            while (lines != null) {
                content += lines;
                lines = reader.readLine();           /* Put in code to read the file line by line. */
            }


        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }
        return content;
    }
}