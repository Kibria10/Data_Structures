package Hackerrank;

import java.util.Scanner;

public class plusMinus {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //taking size of array
        int size = sc.nextInt();
        int[] arr = new int[size];
        //taking input in array
        for (int i = 0; i < size; i++) {
            int k = sc.nextInt();
            arr[i] = k;
        }
        //printing array
//        for (int i = 0; i < size; i++) {
//            System.out.println(arr[i]);
//        }

        signChecker(arr);

    }

    public static void signChecker(int[] arr) {
        int[] fr = new int[3];


        for (int i = 0; i < arr.length; i++){

            if (arr[i]>0){
                fr[0] += 1;
            }

            else if (arr[i]<0) {
                fr[1] += 1;
            }

            else if (arr[i]==0){
                fr[2] += 1;
            }
        }
        for (int i = 0; i < fr.length; i++){
            System.out.println(fr[i]);
        }
        System.out.println();

        for (int i = 0; i < fr.length; i++) {
                System.out.println( (float)fr[i] / arr.length);
            }
        }
    }
