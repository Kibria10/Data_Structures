package cse490;
import java.util.Scanner;
public class A51_streamCipher {

    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);

        //FOR MANUALLY TAKING INPUTS

//        System.out.println("Insert values of X");
//        int[] x = new int[4];
//        for (int i = 0; i < 4; i++) {
//        x[i]=sc.nextInt();
//        }
//
//        System.out.println("Insert values of Y");
//        int[] y = new int[4];
//        for (int i = 0; i < 4; i++) {
//            y[i]=sc.nextInt();
//        }
//
//        System.out.println("Insert values of Z");
//        int[] z = new int[4];
//        for (int i = 0; i < 4; i++) {
//            z[i]=sc.nextInt();
//        }

        int x[]={1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1}; //19 bits
        int y[]={1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,0,1}; //22 bits
        int z[]={1,1,1,0,0,0,0,1,1,1,1,0,0,0,0,1,1,1,1,0,0,0,1}; //23 bits

        streamCipherA51(x,y,z);

        System.out.println();
        System.out.println();
        System.out.println("Printing Keys: ");
        for (int i =0; i<saved.length; i++){
            System.out.println(saved[i]);
        }
    }

    public static int saved[]= new int[16];


    public static int[] streamCipherA51(int x[],int y[],int z[] ) {
        int major=5;
        if (x[8]==0 && y[10]==0 && z[10]==0) {
             major =0;
        }
        else if (x[8]==0 && y[10]==0 && z[10]==1) {
             major =0;
        }
        else if (x[8]==0 && y[10]==1 && z[10]==0) {
             major =0;
        }
        else if (x[8]==0 && y[10]==1 && z[10]==1) {
             major =1;
        }
        else if (x[8]==1 && y[10]==0 && z[10]==0) {
             major =0;
        }
        else if (x[8]==1 && y[10]==0 && z[10]==1) {
             major =1;
        }
        else if (x[8]==1 && y[10]==1 && z[10]==0) {
             major =1;
        }
        else if (x[8]==1 && y[10]==1 && z[10]==1) {
             major =1;
        }
        System.out.println("Major: " + major);

/////////////// key is how many times we want our key bits to be produced ///////////////
        for(int key = 0; key<16; key++){

///////////////////FOR X/////////////////
            int d = x[13]^x[16]^x[17]^x[18];
            System.out.println();
            System.out.println("x-or of X: " + d);

            if(d!=major) {
                for (int s = 0; s < 1; s++) {
                    int j, temp;
                    temp = x[x.length - 1];
                    for (j = x.length - 1; j > 0; j--) {
                        x[j] = x[j - 1];
                    }
                    x[0] = temp;
                }
                x[0] = d;
//printing
                System.out.println("New values of X: ");
                for (int m = 0; m < x.length; m++) {
                    System.out.print(x[m] +" ");
                }
            }
            else{ System.out.println("Matched with major. Thus no need to right shift and setting the X-or value to 0'th index.");}
///////////////////FOR Y/////////////////
            int e = y[20]^y[21];
            System.out.println();
            System.out.println("x-or of Y: " + e);
            if(e!=major) {
                for (int s = 0; s < 1; s++) {
                    int j, temp;
                    temp = y[y.length - 1];
                    for (j = y.length - 1; j > 0; j--) {
                        y[j] = y[j - 1];
                    }
                    y[0] = temp;
                }
                y[0] = e;
//printing
                System.out.println("New values of Y: ");
                for (int m = 0; m < y.length; m++) {
                    System.out.print(y[m] +" ");
                }
            }
            else{ System.out.println("Matched with major. Thus no need to right shift and setting the X-or value to 0'th index.");}
///////////////////FOR Z/////////////////
            int f = z[7]^z[20]^z[21]^z[22];
            System.out.println();
            System.out.println("x-or of Z: " + f);

            if(f!=major) {
                for (int s = 0; s < 1; s++) {
                    int j, temp;
                    temp = z[z.length - 1];
                    for (j = z.length - 1; j > 0; j--) {
                        z[j] = z[j - 1];
                    }
                    z[0] = temp;
                }
                z[0] = f;
//printing
                System.out.println("New values of Z: ");
                for (int m = 0; m < z.length; m++) {
                    System.out.print(z[m] +" ");
                }
            }
            else{ System.out.println("Matched with major. Thus no need to right shift and setting the X-or value to 0'th index.");}

            //saving the x-or value of last index of X, Y, Z array.
            saved[key]= x[x.length-1]^y[y.length-1]^z[z.length-1];
        }
        return saved;
    }
}
//100% OC. By Maharab Kibria
