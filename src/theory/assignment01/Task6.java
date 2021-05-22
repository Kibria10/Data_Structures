package theory.assignment01;
import java.lang.Math;
public class Task6 {

    public static void main(String[]args){
        System.out.println("\n♛ Task 6 ♛");
        int[] arr1 = {4, 5, 3};
        int[] arr2 = {9, 5, 2};
        int[] arr3 = {};

        Task6 ins1 = new Task6(arr1);
        System.out.println("\nList1: ");
        ins1.printList();
        System.out.println("\nconcatenation List1:");
        System.out.println(ins1.Summation());
        Task6 ins2 = new Task6(arr2);
        System.out.println("\nList2: ");
        ins2.printList();
        System.out.println("\nconcatenation List2:");
        System.out.println(ins2.Summation());

        double k = ins2.Summation()+ ins1.Summation();

        int l = (int) Math.round(k);
        System.out.println("\nSummation of both values: " + l);


        Task6 ins3 = new Task6(arr3);
        String number = String.valueOf(l);
        for(int i = 0; i < number.length(); i++) {
            int j = Character.digit(number.charAt(i), 10);
            ins3.insert(j);
        }
        System.out.println("\nPrinting the summation into nodes: ");
        ins3.printList();

    }

    Node head;

    //Creating a dummy headed singly linear linked list out of an array.
    public Task6(int[] a) {
        head = new Node(0, null);
        Node n = head; // Create Head for LinkList
        for (int i =0; i < a.length; i++) {
            Node Temp = new Node(a[i], null);
            n.next = Temp; // Take Previous Node Reference
            n = n.next;
        }
    }
    public int countNode() {
        int count = 0;
        for (Node n = head.next; n != null; n = n.next) {
            count++;
        }
//        if (count == 0){
//            System.out.println("EMPTY LIST");
//        }
        return count;
    }

    public double Summation(){
        Node n = head.next;
        if(n == null) {
            return 0;
        }
        double idx = countNode()-1;
        double sum = 0;
        while(n != null) {
            sum = sum + n.element * Math.pow(10 , idx);
            n = n.next;
            idx--;
        }
        return sum;
    }

    public void insert(int elem) {
        int idx = countNode();

            Node newNode = new Node(elem, null);
            if (idx == 0) {
                newNode.next = head.next;
                head.next = newNode;
            } else {
                Node prev = nodeAt(idx - 1);
                newNode.next = prev.next;
                prev.next = newNode;
            }
        }

    public Node nodeAt(int idx) {
        if (idx < 0 || idx >= countNode()) { // Invalid Range
            return null;
        }
        int count = 0;
        Node n = head.next;
        for (; n != null; n = n.next) {
            if (count == idx) {
                break;
            }
            count++;
        }
        return n;
    }
    public void printList() {
        Node n = head.next;
        if(n.next == null) {
            System.out.println("\nEMPTY LIST");
        }


        for (; n.next != null; n = n.next) {
            System.out.print(n.element + "-> ");
        }
        System.out.println(n.element + ". ");
    }


}
