package theory.assignment02.task05;

public class rightTriangle {

    static int makeRows(int iterator, int num, int k){
        // base case
        if (num == 0)
            return iterator;
        System.out.print(k + "  ");

        return makeRows(iterator+1, num-1, k+1);
    }
    // function to print the pattern
    static void pattern(int n, int iterator, int num)
    {
        // base case
        if (n == 0)
            return;
        int v =0;
        iterator = makeRows(iterator, num, v+1);
        System.out.println();
        // recursively calling pattern
        pattern(n -1 , iterator+1, num+1);
    }
    public static void main (String[] args)
    {
        int n = 5;
        pattern(n, 10, 1);
    }
}