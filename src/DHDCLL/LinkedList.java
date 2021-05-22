package DHDCLL;
import DHDCLL.Node;

public class LinkedList {
    public Node head;
    public LinkedList(int a[]){
    head = new Node(0, null, null);
        head.next = head.prev=head;
//      Node k = head; // Create Head for LinkList
//      for (int i = a.length-1; i >= 0; i--) {
        for (int i = 0; i <a.length; i++) {
        Node n = new Node(a[i], null, null);
        n.next=head.next;
        n.prev = head;
        head.next=n;
        head.prev =n; //OR n.next.prev=n;

        }
}
 public void showList(){
        for(Node n=head.next; n!=head; n=n.next){
            System.out.print(n.element + ", ");
        }

 }

}
