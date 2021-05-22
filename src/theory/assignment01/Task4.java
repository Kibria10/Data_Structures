package theory.assignment01;

public class Task4 {

    public static void main(String[] args) {
        Task4 iv = new Task4();

        iv.addNode(1);
        iv.addNode(3);
        iv.addNode(3);
        iv.addNode(4);
        iv.addNode(5);
        iv.addNode(5);
//        iv.addNode(5);
//        iv.addNode(4);

        System.out.println("Originals list: ");
        iv.printList();
        System.out.println("Removed first duplicate node: ");
        iv.removeFirstDuplicate();
        System.out.println("List after removal of first duplicate node: ");
        iv.printList();
    }

    public Node head = null;
    public Node tail = null;

    public void addNode(int data) {
        Node newNode = new Node(data, null);

        if(head == null) {
            head = newNode;
            tail = newNode;
        }
        else {
            tail.next = newNode;
            tail = newNode;
        }
    }


    public void removeFirstDuplicate() {
        Node current = head, index = null, temp = null;
        if(head == null) {
            return;
        }
        else {
            while(current != null){
                temp = current;
                index = current.next;
                while(index != null) {
                    if(current.element == index.element) {
                        temp.next = index.next;
                        System.out.println(index.element);
                        return;
                    }
                    else {
                        temp = index;
                    }
                    index = index.next;
                }
               current = current.next;
            }
        }
    }

    public void printList() {
    Node n = head;
    if (n.next == null) {
        System.out.println("\nEMPTY LIST");
    }
    for (; n.next != null; n = n.next) {
        System.out.print(n.element + "-> ");
    }
    System.out.println(n.element + ". ");
    }

}