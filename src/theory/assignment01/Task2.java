package theory.assignment01;

import java.util.Random;

public class Task2 {

    public static void main (String[]args)
    {
        String[] names ={"ADOR","FAIZA","GALIB","ILMI","JUNAK","MOOSFIQ","KIBRIA"};
        System.out.println("\nOriginal Members: ");
        for(int i = 0; i< names.length; i++){
            System.out.print(names[i] + " ⦿ "); }
        MusicChair(names);
    }

    public static void MusicChair(String array[]){

        if(array.length==1){
            System.out.println("\n\n♛ WINNER WINNER CHICKEN DINNER ♛");
            return;
        }
        int n = array.length/2;

        if (randomgen()==1){
            // rightShiftCircularArray(array,1);
            remove(array, n);
        }
        else {
            rightShiftCircularArray(array,1);
            MusicChair(array);
        }
    }

    static void rightShiftCircularArray (String arr[], int k) {
        for(int i = 0; i < k; i++){
            int j;
            //int temp;
            String temp;
            temp = arr[arr.length-1];
            for(j = arr.length-1; j >0; j--){
                arr[j] = arr[j-1];  }
            arr[0] = temp;  }
        System.out.println("\nRIGHT SHIFTING CHAIRS: ");
        for(int i = 0; i< arr.length; i++){
            System.out.print(arr[i] + " ▶ "); }
    }


    public static int randomgen(){
        Random r = new Random();
        int low = 0;
        int high = 4;
        int result = r.nextInt(high-low) + low;
        System.out.println();
        System.out.println("\nRandom Generator: " +result);
        return result;

    }


    public static String[] remove(String[] arr, int index) {
        if (arr == null || index < 0 || index >= arr.length) {
            return arr;
        }
        String[] anotherArray = new String[arr.length - 1];

        for (int i = 0, k = 0; i < arr.length; i++) {
            if (i == index) {
                continue;
            }
            anotherArray[k++] = arr[i];
        }
        System.out.println();
        for(int i = 0; i< anotherArray.length; i++){
            System.out.print(anotherArray[i] + " ✘ "); }

        MusicChair(anotherArray);
        return anotherArray;
    }

}
