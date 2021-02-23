import java.nio.Buffer;
import java.util.Arrays;
import java.util.Scanner;
import java.io.*;
import java.io.BufferedReader;

import java.lang.Object;

import java.io.Reader;
import java.io.InputStreamReader;
import java.io.FileReader;

public class Database {
    private String[] colNames;
    private int numRows;
    private String[][] data;

    public String[] getColNames() {
        return colNames;
    }

    public void setColNames(String[] colNames) {
        this.colNames = colNames;
    }

    public int getNumRows() {
        return numRows;
    }

    public void setNumRows(int numRows) {
        this.numRows = numRows;
    }

    public String[][] getData() {
        return data;
    }

    public void setData(String[][] data) {
        this.data = data;
    }

    public Database(String contents) {
/* TODO 
This constructor should take the contents of a CSV file and initialize the memember-iables of the Database class.
*/
        // first, seperate lines \n,
        // set colNames be the first row of the file in an array form. split comma
        String[] lines= contents.split("\n");
        String first = lines[0];
        this.colNames = first.split(",");
        this.numRows = lines.length-1;
        // numRows will equal to array.length -1
        //data [numRows][colNames] for loop, split comma, add info into the grid, for loop for every line
        this.data=new String[numRows][colNames.length];
        for(int i =0; i<numRows; i++){
            String temp = lines[i+1];
            String[] tempArray = temp.split(",");
            for(int j=0; j< colNames.length; j++){
                this.data[i][j] = tempArray[j];
            }
        }
    }

    public String getValue(String columnName,int row){
/* TODO */
//This method should return the data contained on row "row" and the column matching  @columname
                // match columnName with colNames, find the value on the array, if string is equal to it,
        // return the colName element then
        String value="";
        int spot=0;
        for(int i=0; i<colNames.length; i++){
            if(this.colNames[i].equals(columnName)){
                 spot=i;
            }
        }
        value = this.data[row][spot];
        return value;
    }

}


