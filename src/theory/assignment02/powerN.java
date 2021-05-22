package theory.assignment02;

import java.util.Scanner;
public class powerN {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Base: ");
        int k = sc.nextInt();

        System.out.println("Enter Power: " );
        int n = sc.nextInt();
        int num = power(k, n);
        System.out.println(num);
    }

    public static int power(int k, int n) {
        if (n == 0) {
            return 1;
        }
        int no = power(k, n - 1);
        int num = k * no;
        return num;
    }
}