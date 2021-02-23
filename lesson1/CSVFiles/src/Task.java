import java.io.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.nio.charset.StandardCharsets;
import java.lang.StringBuilder;

public class Task {
    public static void main(String[] ar) {
        Task t = new Task();
        Database d = t.readCSV("./resources/iris.data");
    }
    public Database readCSV(String filename) {
        String contents = "";
        try (InputStream in = new BufferedInputStream(new FileInputStream(filename))) {         /*  Change what needs to go here to start reading "filename" */
            byte[] buffer = new byte[1];
            int lengthRead;
            while((lengthRead = in.read(buffer))>0){
                String decoded = new String(buffer, 0, lengthRead);
                contents += decoded;
            }
//Create a while loop to read the contents of the file and put them in the variable "contents" declared at the beginning of the method. */
        } catch (IOException e) {                  // Put the correct Exception here.
            e.printStackTrace();
            System.exit(-1);
        }
        Database x = new Database(contents);
        return x;  //Return a Database object initialized with the contents read. */
    }
}