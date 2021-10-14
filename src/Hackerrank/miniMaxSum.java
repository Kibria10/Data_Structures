package Hackerrank;

import java.util.Scanner;
import java.util.Arrays;

public class miniMaxSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] arr = new int[5];
        //taking input in array
        for (int i = 0; i < arr.length; i++) {
            int k = sc.nextInt();
            arr[i] = k;
        }
        //printing array
//        for (int i = 0; i < size; i++) {
//            System.out.println(arr[i]);
//        }

        arrMinMaxChecker(arr);

    }

    public static void arrMinMaxChecker(int [] arr){
        int temp = 0;
        int [] store = new int[5];
        for (int i = 0; i < arr.length; i++) {

            for (int j = 0; j< arr.length; j++){
                 temp += arr[j];
            }
//            System.out.println(temp);
            store[i]= temp-arr[i];
            temp = 0;
        }

        Arrays.sort(store);

        System.out.print(store[0]+ " "+store[4]);


    }


}

