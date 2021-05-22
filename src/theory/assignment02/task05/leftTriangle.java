package theory.assignment02.task05;

public class leftTriangle {
    static void makeSpace(int interval) {
        // base case
        if (interval == 0) {
            return;
        }
        System.out.print(" " + " ");
        makeSpace(interval - 1);
    }
    static int makeRows(int iterator, int n, int k) {
        // base case
        if (n == 0)
            return iterator;
        System.out.print(" " +k );

        return makeRows(iterator + 1, n - 1, k + 1);
    }

    // function to print the pattern
    static void pattern(int n, int iterator, int num) {
        // base case
        if (n == 0)
            return;
        makeSpace(n - 1);
        int k = 0;
        iterator = makeRows(iterator, num, k + 1);
        System.out.println();
        // recursively calling pattern.
        pattern(n - 1, iterator + 1, num + 1);
    }

    public static void main(String[] args) {
        int n = 5;
        pattern(n, n ,1 );

    }

}