package SortSearchRecursion.LinkedList.Doubly;
//TASK 5
public class insertionSortDoublyLinkedList {
    public static void main (String[]args){
        int[] inputArr = {62,52,42,32,-32,22,12};
        Node head = new Node (inputArr[0] , null , null);
        Node tail = head;

        for(int j = 1 ; j<inputArr.length ; j++){
            Node temp = new Node (inputArr[j] , null , null);
            tail.next = temp;
            temp.prev = tail;
            tail = tail.next;
        }

        for(Node l = head ; l!=null ; l = l.next){
            Object temp = l.element;
            Node k = l;
            while(k.prev!=null && (int) k.prev.element> (int)temp){
                k.element = k.prev.element;
                k = k.prev;
            }
            k.element = temp;
        }
        for(Node m = head ; m!=null ; m = m.next){
            System.out.println(m.element);
        }
    }
}