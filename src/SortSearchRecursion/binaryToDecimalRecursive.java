package SortSearchRecursion;

import java.util.Scanner;

  public class binaryToDecimalRecursive {
        int i = 0;
        int num = 0;

        int recursiveBinToDec(int[] arr) {
            if (i == arr.length) {
                return num;
            } else if (arr[i] == 0) {
                num = num * 2 + 0;
                i++;
                recursiveBinToDec(arr);
            } else if (arr[i] == 1) {
                num = num * 2 + 1;
                i++;
                recursiveBinToDec(arr);
            }
            return num;
        }

        //integer to array converter method. stackoverflow
        public int[] createArrayFromNumber(int number) {
            String str = (new Integer(number)).toString();
            char[] chArr = str.toCharArray();
            int[] arr = new int[chArr.length];
            for (int i = 0; i < chArr.length; i++) {
                arr[i] = Character.getNumericValue(chArr[i]);
            }
            return arr;
        }


    }

    class tester {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            binaryToDecimalRecursive e = new binaryToDecimalRecursive();
            System.out.println("Insert Any Binary Value to Convert Into Decimal:");
            int a = scanner.nextInt();
            int arr[] = e.createArrayFromNumber(a);
            int x = e.recursiveBinToDec(arr);
            System.out.println("Answer: " + x);
        }

    }

