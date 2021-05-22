package SortSearchRecursion.LinkedList;
//TASK 4
public class selectionSortLinkedList {
    public static void main (String[]args){
        int [] inputArr = {62,52,42,32,-32,22,12};
        Node head = new Node (inputArr[0],null);
        Node tail = head;
        for(int i = 1 ; i<inputArr.length ; i++){
            Node temp = new Node (inputArr[i] , null);
            tail.next = temp;
            tail = tail.next;
        }
        for(Node m = head ; m.next!=null ; m=m.next){
            Node minIdx = m;
            for(Node n = m.next ; n!=null ; n=n.next){
                if((int)n.element<(int)minIdx.element){
                    minIdx = n;
                }
            }
            Object temp = minIdx.element;
            minIdx.element = m.element;
            m.element = temp;
        }

        for(Node o = head ; o!=null ;o=o.next){
            System.out.println(o.element);
        }
    }
}