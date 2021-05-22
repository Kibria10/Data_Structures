package DHDCLL;


public class Tester {
    public static void main(String[] args) {

        System.out.println("\nCreating List from an array");
        int[] arr1 = {10, 20, 30, 40, 50, 60, 70};
        LinkedList ref1 = new LinkedList(arr1);
        System.out.println("\nNew List: ");
        ref1.showList(); // This should print: 10,20,30,40.
    }
}
