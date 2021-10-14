package Hackerrank;

import java.io.*;
import java.util.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;

class Result {

    /*
     * Complete the 'timeConversion' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     * Sample Input and Output:
     * input: 07:05:45PM
     * output:  19:05:45
     */


    public static String timeConversion(String s)  throws ParseException {
        // Write your code here
        final String OLD_FORMAT = "hh:mm:ssaa";
        final String NEW_FORMAT = "HH:mm:ss";

        String old124hourFormat = s;
        String new24hourFormat;

        SimpleDateFormat sdf = new SimpleDateFormat(OLD_FORMAT);
        Date d = sdf.parse(old124hourFormat);
        sdf.applyPattern(NEW_FORMAT);
        new24hourFormat = sdf.format(d);
        return new24hourFormat;


    }

}

public class timeConversion {
    public static void main(String[] args) throws IOException, ParseException {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        System.out.println(Result.timeConversion(s));

    }
}
