package SortSearchRecursion.LinkedList;
//TASK 3
public class bubblySortLinkedList {
    public static void main (String [] args){

        int[] inputArr = {62,52,42,32,-32,22,12};
        Node head = new Node(inputArr[0] ,null);
        Node last = head;

        for(int i = 1 ; i<inputArr.length ; i++){
            Node temp = new Node (inputArr[i], null);
            last.next = temp;
            last = last.next;
        }

        for(Node m = head ; m!=null ; m = m.next){
            for(Node n = head ; n.next!=null ; n = n.next){
                if((int)n.element>(int)n.next.element){
                    Object t = n.element;
                    n.element = n.next.element;
                    n.next.element = t;
                }
            }
        }
        for(Node o = head ; o!=null ; o = o.next){
            System.out.println(o.element);
        }
    }
}
