package Hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

 public class day2 {
     public static void solve(double meal_cost, int tip_percent, int tax_percent) {
         double a = tip_percent;
         double b = tax_percent;
         double c = meal_cost*(a/100);
         double d =meal_cost*(b/100);
         double e = c + d + meal_cost;
         System.out.println(Math.round(e));
     }


     public static void main(String[] args) throws IOException {
         BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

         double meal_cost = Double.parseDouble(bufferedReader.readLine().trim());

         int tip_percent = Integer.parseInt(bufferedReader.readLine().trim());

         int tax_percent = Integer.parseInt(bufferedReader.readLine().trim());

         day2.solve(meal_cost, tip_percent, tax_percent);

         bufferedReader.close();


     }
 }




