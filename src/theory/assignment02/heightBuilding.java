package theory.assignment02;
import java.util.Scanner;

public class heightBuilding {
    public static int build(int height, int store){

        if(height == 0){
            System.out.println("Unable to build house if height is 0");
            return 0;
        }
        if(height ==1){
            return store + 8;
        }
        else {
            if(height == 0){
                return store;
            }
            store = store +5;
            return (build(height-1,store));
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Height: ");
        int h = sc.nextInt();
        System.out.println(build(h, 0));
    }
}