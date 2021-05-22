package theory.assignment02;
import java.util.Random;
//1,6,3,4: right pass and not eliminate
//2,4 eliminate and pass

public class fridayFun {

    public static void main(String[]args){
//            System.out.println(diceGenerator());
            String players[]={"ARH","JNM","RAK","SEJ"};
        System.out.println("Original Players:");
            for(int i =0; i< players.length; i++){
                System.out.println(players[i]);
            }
            theGame(players);
    }

    public static void theGame(String players[]) {
        if(players.length==1){
            System.out.println("\n\n♛Winner♛:  " + players[0]);
            return;
        }

        int k = diceGenerator();
            if (k==1 || k==3 || k==5 || k==6) {
            passItToRight(players,1);
            theGame(players);
            }
            else if (k==2 || k==4 ){
                remove(players, 0);
            }
        }



    static void passItToRight (String arr[], int k) {
        for(int i = 0; i < k; i++){
            int j;
            //int temp;
            String temp;
            temp = arr[arr.length-1];
            for(j = arr.length-1; j >0; j--){
                arr[j] = arr[j-1];  }
            arr[0] = temp;  }
        System.out.println("\nPassing the packet to the right person: ");
        for(int i = 0; i< arr.length; i++){
            System.out.print(arr[i] + " ▶ "); }
    }




    public static String[] remove(String[] arr, int index) {
        System.out.println("Eliminating: " + arr[index]);

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

        for(int i = 0; i< anotherArray.length; i++){
            System.out.print(anotherArray[i] + " ✘ "); }

        theGame(anotherArray);
        return anotherArray;
    }

public static int diceGenerator(){
        Random r = new Random();
        int low = 1;
        int high = 7;
        int result = r.nextInt(high-low) + low;
        System.out.println();
        System.out.println("\nDice: " +result);
        return result;
    }
}