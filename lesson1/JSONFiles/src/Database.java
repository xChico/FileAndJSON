import com.github.cliftonlabs.json_simple.JsonArray;
import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.Jsoner;
import java.math.RoundingMode;

import java.math.BigDecimal;

public class Database {
    private JsonObject information;
    /*
Declare a member variable that can 
be EASILY set from the constructor. */

    public Database(JsonObject data){
    this.information  = data;
        /*
set the memebr variable declared above.*/
    }
    public JsonObject getRestaurant(String name){
        JsonArray firstKey = (JsonArray) this.information.get("restaurants");
        JsonObject answer = new JsonObject();
        String match ="";
        JsonObject restaurant = new JsonObject();

        for(int i=0; i<firstKey.size(); i++) {
            restaurant = (JsonObject) firstKey.get(i);
            match = (String)restaurant.get("name");
            if(match.equals(name)) {
                answer = restaurant;
            }
        }
        return answer;
        /*
Complete this method as specified. */
    }

    public double getAvgReviews(String name){
        JsonObject restaurant =getRestaurant(name);
        JsonArray reviews = (JsonArray) restaurant.get("reviews");
        int count=0;
        //Double ratingNum = 0.0;
        BigDecimal ratingNum = new BigDecimal(0.0);
        BigDecimal rating = new BigDecimal(0.0);

        for(int i=0; i<reviews.size(); i++){
            JsonObject spot = (JsonObject) reviews.get(i);

            //Double rating = (Double) spot.get("rating");
            rating = (BigDecimal)spot.get("rating");
            count++;
            ratingNum = rating.add(ratingNum);
        }
        BigDecimal answer = new BigDecimal(0.0);
        BigDecimal countBig = new BigDecimal(count);
        //answer = ratingNum.divide(countBig);
        answer = ratingNum.divide(countBig, 2, RoundingMode.HALF_UP);
        double realAnswer = answer.doubleValue();
        return realAnswer;

        /*
Complete this method as specified.
 The previous method may be of help. 
*/
   }
}
