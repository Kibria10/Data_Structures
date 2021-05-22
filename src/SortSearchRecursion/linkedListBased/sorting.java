package SortSearchRecursion.linkedListBased;


public class sorting {

    Node head;

    public Node sorting(int[] a) {

        head = new Node(a[0], null);
        Node n = head; // Create Head for LinkList
        for (int i = 1; i < a.length; i++) {
            Node Temp = new Node(a[i], null);
            n.next = Temp; // Take Previous Node Reference
            n = n.next;
        }
        return head;
    }

//    public sorting(Node h) {
//        // Set Head
//        head = h;
//    }


    public int countNode() {
        int count = 0;
        for (Node n = head; n != null; n = n.next) {
            count++;
        }
        if (count == 0) {
            System.out.println("EMPTY LIST");
        }
        return count;
    }

    public void printList() {
        Node n = head;
        if (n.next == null) {
            System.out.println("\nEMPTY LIST");
        }
        for (; n.next != null; n = n.next) {
            System.out.print(n.element + ", ");
        }
        System.out.println(n.element + ". ");
    }

    public Node nodeAt(int idx) {
        if (idx < 0 || idx >= countNode()) {
            return null;
        }
        int count = 0;
        Node n = head;
        for (; n != null; n = n.next) {
            if (count == idx) {
                break;
            }
            count++;
        }
        return n;
    }


    // A function to implement bubble sort
     void bubbleSort(int arr[], int n) {
        // Base case
        if (n == 1)
            return;

        // One pass of bubble sort. After
        // this pass, the largest element
        // is moved (or bubbled) to end.
        for (int i = 0; i < n; i++)
            if (arr[i] > arr[i + 1]) {
                // swap arr[i], arr[i+1]
                int temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
            }

        // Largest element is fixed,
        // recur for remaining array
        bubbleSort(arr, n - 1);
    }

    public void bubbleSortLinkedList(Node head,int k) {

        if (k==1) {
        return;
        }
        for (Node n=head; n!=nodeAt(k-1); n= n.next){
            if (head.element> head.next.element){
                int temp = head.element;
                head.element = head.next.element;
                head.next.element = temp;
            }
        }
        bubbleSortLinkedList(head, k-1);
    }
}


    // Driver Method
    class tester{
    public static void main(String[] args)
    {
        int arr[] = {64, 34, 25, 12, 22, 11, 90};
        sorting s = new sorting();

//        s.bubbleSort(arr, arr.length);
        Node h= s.sorting(arr);
        s.printList();

        int k = s.countNode();
//        System.out.print(k);
//        System.out.println(arr.length);
        s.bubbleSortLinkedList(h,k);

        s.printList();

//        System.out.println("Sorted array : ");
//        System.out.println(Arrays.toString(arr));
    }
}