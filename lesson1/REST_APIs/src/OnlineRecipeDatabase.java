import json_simple.JsonArray;
import json_simple.JsonObject;
import json_simple.Jsoner;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class OnlineRecipeDatabase {

    String baseUrl = "http://www.recipepuppy.com/api/?";

    public JsonObject getRecipesByIngredients(String ingredients) throws Exception {
        String contents = "";
        //Getting the things ready to connect to the web
        try {
            URL url = new URL(baseUrl + "i=" + ingredients);
            Scanner urlScanner = new Scanner(url.openStream());
            while (urlScanner.hasNextLine()) {
                contents += urlScanner.nextLine();

            }
            urlScanner.close();
        }catch (MalformedURLException e) {
            System.out.println(e.getMessage());
        }
        JsonObject JsURL = (JsonObject) Jsoner.deserialize(contents, new JsonObject());


        return JsURL;/*
You have to use the url to retrieve the contents of the website.
This will be a String, but in JSON format. *//*
Remember to return a JSON object.*/
    }

    public JsonObject getRecipesByDish(String dish) throws Exception
    {

        String contents = "";
        URL url = new URL(baseUrl + "q=" + dish);

        try{
            Scanner urlScanner = new Scanner(url.openStream());
            while(urlScanner.hasNextLine()){
             contents += urlScanner.nextLine();
            }
            urlScanner.close();
        }catch (MalformedURLException e) {
            System.out.println(e.getMessage());
        }

        JsonObject JsURL = (JsonObject) Jsoner.deserialize(contents, new JsonObject());
        return JsURL;

        //Getting the things ready to connect to the web
        /*
Read the information coming from the web

return the appropriate result.
*/
    }

    public String formatRecipeAsString(JsonObject doc){
        String results = "";

        JsonArray recipes = (JsonArray)doc.get("results");
        for(int i=0; i<doc.size(); i++) {
            JsonObject temp = (JsonObject) recipes.get(i);
            String title = (String) temp.get("title");
            String link = (String) temp.get("href");
            String ingredients = (String) temp.get("ingredients");
            results += "Title: " + title + "\n" + "Link: " + link + "\n"
                    + "Ingredients: " + ingredients +"\n";
        }
        /*
This should return a String with each recipe in three lines:
Title:the title of the recipe
Link:the link to the recipe
Ingredients:The ingredients of teh recipe.*/
        return results;
    }

    public void saveRecipes(String text, String outfile){
        /*
Given a String with some text in it, write that text to a file. 
The name of the file is given in outfile */

    try {
        FileWriter out = new FileWriter(outfile);
        out.write(text);
        out.close();
    }catch(FileNotFoundException e){
        e.printStackTrace();
    }catch(IOException ex){
        ex.printStackTrace();
    }





    }

}
