package SortSearchRecursion.ArrayBased;
import java.util.Scanner;

public class sorting {

    int arr[];
    Scanner sc = new Scanner(System.in);

    public int[] input(int a){
        arr = new int[a];
        System.out.println("Insert Values:");
        for (int i=0;i<arr.length;i++){
            arr[i]=sc.nextInt();
        }
        return arr;
    }
    public void show(){
        for(int i = 0; i< arr.length; i++){
            System.out.print(arr[i] + ", "); }
    }

//TASK_1
    public void selectionSortRecursive(int[] inputArr, int lowEnd, int highEnd) {
        if (lowEnd < highEnd) {
            int minIdx = lowEnd;
            double minVal = inputArr[lowEnd];
            for (int i = lowEnd + 1; i <= highEnd; i++) {
                if (inputArr[i] < minVal) {
                    minVal = inputArr[i];
                    minIdx = i;
                }
            }
            inputArr[minIdx] = inputArr[lowEnd];
            inputArr[lowEnd] = (int) minVal;

            selectionSortRecursive(inputArr, lowEnd + 1, highEnd);


        }
    }

//TASK_2
    public void recursiveInsertionSort(int arr[], int n)
    {
        // Base case
        if (n <= 1)
            return;
        recursiveInsertionSort( arr, n-1 );
        int last = arr[n-1];
        int temp = n-2;
        while (temp >= 0 && arr[temp] > last)
        {
            arr[temp+1] = arr[temp];
            temp--;
        }
        arr[temp+1] = last;
    }

//TASK6
    int binarySearchRecursive(int arr[], int leftS, int rightS, int x)
    {
        if (rightS >= leftS && leftS<arr.length-1) {
            int div = leftS + (rightS - leftS) / 2;
            if (arr[div] == x)
                return div;
            if (arr[div] > x)
                return binarySearchRecursive(arr, leftS, div - 1, x);
            return binarySearchRecursive(arr, div + 1, rightS, x);
        }
        return -1;
    }

//TASK 7
    public int recursiveFibonacci(int n) {
            if(n==0 ){
                return 0;
            }else if(n==1){
                return 1;
            } else {
                return recursiveFibonacci(n - 1) + recursiveFibonacci(n - 2);
            }
        }
}

class tester {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sorting ref = new sorting();
        System.out.println("Press 1: Recursive Selection Sorting\nPress 2: Recursive Insertion Sorting\nPress 3: Recursive Binary Searching\nPress 4: recursive algorithm to find the n-th Fibonacci number using");
        int k = sc.nextInt();
        if (k == 1) {
            System.out.println("ENTER THE ARRAY SIZE: ");
            int input = sc.nextInt();
            int inputArr[] = ref.input(input);
            ref.show();
            ref.selectionSortRecursive(inputArr, 0, input - 1);
            System.out.println();
            System.out.println("\nAfter recursive selection sorting: ");
            ref.show();
        }

        else if (k == 2) {
            System.out.println("ENTER THE ARRAY SIZE: ");
            int input = sc.nextInt();
            int inputArr[] = ref.input(input);
            ref.recursiveInsertionSort(inputArr, input);
            System.out.println();
            System.out.println("\nAfter recursive insertion sorting: ");
            ref.show();
        }

        else if (k == 3) {
            System.out.println("ENTER THE ARRAY SIZE: ");
            int input = sc.nextInt();
            int inputArr[] = ref.input(input);
            ref.show();
            System.out.println("\nEnter the element you want to search:");
            int find = sc.nextInt();
            ref.recursiveInsertionSort(inputArr, input);
            System.out.println("After Sorting Your Input Array Looks Like: ");
            ref.show();
            int ans = ref.binarySearchRecursive(inputArr,0,input-1,find);
            System.out.println("\nAfter recursive binary searching: ");
            if (ans == -1)
                System.out.println("Your searched value is not present.");
            else
                System.out.println("Searched value was found at " + ans);
        }

        else if (k ==4){
            System.out.println("Please Enter The Number of Fibonacci You Want To Use: ");
            int a = sc.nextInt();
            long s=System.currentTimeMillis();
            System.out.println("Answer: "+ref.recursiveFibonacci(a));
            long e=System.currentTimeMillis();
            System.out.println("Execution Time: "+(e-s)+" milliseconds");
        }
    }
}

