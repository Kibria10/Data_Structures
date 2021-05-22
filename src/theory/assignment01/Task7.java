package theory.assignment01;

public class Task7 {

    public static void main(String[] args) {
        int[] t7 = {1,2,3,4,5};
        Task7 vii = new Task7(t7);
        System.out.println("\nOriginal List: ");
        vii.printList();
        //System.out.println(vii.countNode());
        vii.insert(66,0);
        //System.out.println(vii.countNode());
        System.out.println("\nAfter Insertion: ");
        vii.printList();

    }

    Node head;
    //Creating Circular Linked List From an Array
    public Task7(int[] a) {
        head = new Node(a[0], null);
        Node n = head; // Create Head for LinkList
        for (int i = 1; i < a.length; i++) {
            Node Temp = new Node(a[i], null);
            n.next = Temp; // Take Previous Node Reference
            n = n.next;
        }
        n.next=head; //making it circular
    }
    //Printing Circular Linked List From an Array
    public void printList() {
        Node n = head;
        if (n.next == null) {
            System.out.println("\nEMPTY LIST");
        }
        for (; n.next != head; n = n.next) {
            System.out.print(n.element + "-> ");
        }
        System.out.println(n.element + ". ");
    }
    public int countNode() {
        int count = 0;
        for (Node n = head; n.next != head; n = n.next) {
            count++;
        }
        if (count == 0){
            System.out.println("EMPTY LIST");
        }

        return count;
    }
    public Node nodeAt(int idx) {
        if (idx < 0 || idx > countNode()) { // Invalid Range
            return null;
        }
        int count = 0;
        Node n = head;
        for (;; n = n.next) {

            if (count == idx) {
                break;
            }
            count++;
          //  System.out.println(n.element);
            if(n.next==head){
                break;
            }
        }
        return n;
    }

    public void insert(int elem, int idx) {
        if (idx < 0 || idx > countNode()) {
            System.out.println("Invalid Index");
        }

        else {
            Node newNode = new Node(elem, null);
            if (idx == 0) {
//                System.out.println(countNode());
//                System.out.println(tail.element);
                Node tail = nodeAt(countNode());
                tail.next = newNode;
                newNode.next = head;
                head = newNode;
            }

            else {
                Node priv = nodeAt(idx - 1);
                newNode.next = priv.next;
                priv.next = newNode;
            }
        }
    }

}
