package keyIndex;
import java.util.Scanner;
public class keyIndex {
    Scanner sc = new Scanner(System.in);
    int[] key;
    //CONSTRUCTOR
    public keyIndex(int[] a, int offset) {
        for (int i = 0; i < a.length; i++) {
            a[i] = a[i] + offset;
        }
//        for(int i =0; i<a.length;i++) {
//            System.out.println(a[i]);
//        }
        int max = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] > max)
                max = a[i];
        }
//      System.out.println(max);
        key = new int[max + 1];
        for (int i : a) {
            key[i] = key[i] + 1;
        }
//        System.out.println("finale array");
//        for(int l =0; l<f.length;l++) {
//            System.out.println(l+ "\t" +f[l]);
//        }
    }
    //SEARCH METHOD
    public boolean searchKeyIndex(int offset) {
        System.out.println("Enter the element you want to search:");
        int a = sc.nextInt() + offset;
        return key[a] == 1;
    }
    //SORT METHOD
    public void sortKeyIndex(int offSet) {
        for (int i = 0; i < key.length; i++) {
            if (key[i] >= 1) {
                System.out.print(i - offSet + ", ");
                if (key[i]>1){
                    for (int l = 0; l< key[i]-1; l++)
                        System.out.print(i - offSet + ", ");
                }
            }
        }
    }
}
//TESTER FILE
class tester {
    public static void main(String[] args) {
        int[] arr = {13, -14, -15, -5, 17, 13, 3, 6, 9, 13, -100, 100, 101, -200, 100};
        int temp;
        for (int i = 0; i < arr.length; i++)
        {
            for (int j = i + 1; j < arr.length; j++)
            {
                if (arr[i] > arr[j])
                {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
//          System.out.println(lowestVal);
        int lowestVal = arr[0];
        int offset = lowestVal * (-1);
        keyIndex k = new keyIndex(arr, offset);
        Scanner sc = new Scanner(System.in);
        System.out.println("\nPress:1 For Key Index Searching.\n\nPress:2 For Key Index Sorting.");
        int select = sc.nextInt();
        if(select==1) {
            System.out.println(k.searchKeyIndex(offset));
        }
        else if(select==2) {
            System.out.println("Sorted Array: ");
            k.sortKeyIndex(offset);
        }
    }
}

