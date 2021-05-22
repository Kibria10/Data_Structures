package theory.assignment01;

public class Task8 {

    public static void main(String[] args){
        Task8 viii= new Task8();
        Object [] arr={10,20,30,40,50};
        viii.Task8(arr);
        System.out.println("\nOriginal Array: ");
        viii.printForward();
        System.out.println();
        viii.InsertKey(50, 534534);
        System.out.println("\nAfter Insertion: ");
        viii.printForward();
    }

    Node head;
    class Node{

        Object elem;
        Node next;
        Node prev;

        Node(Object i, Node n, Node p){

            elem=i; next=n;prev=p;
        }
    }
    void Task8(Object [] a){

        head=new Node(null,null,null);
        Node tail=head;

        for(int i=0; i<a.length;i++){
            Node mn=new Node(a[i],null,null);
            tail.next=mn;
            mn.prev=tail; //Doubly Part
            tail=tail.next;
        }
        tail.next=head; //circulr part
        head.prev=tail;
    }


    void printForward() {
        for (Node n = head.next; n != head; n = n.next) {

            System.out.print(n.elem );
        if(n.next.elem!=null){
            System.out.print("-> ");
        }
        }
    }

    Node findNode(int idx){
        Node tail=head;
        if (idx<0){ return null;}
        else{
            int z=0;
            for(tail=head.next;tail!=head;tail=tail.next,z++){
                if (z==idx)
                    return tail;
            }
            return null;
        }
    }

    void InsertKey(Object key, Object newElem){
        int count =0;
        for (Node n = head.next; n != head; n = n.next) {

            if(n.elem ==key){
                count++;
                break;
            }
            else
                count++;
        }
        int l = count-1;
        insert(newElem, l);
    }


    void insert(Object elem, int idx){
        int k = Integer.parseInt(String.valueOf(idx));
       // int k = idx-1;
        Node tail;
        Node temp=new Node(elem,null,null);

        if (k==0){
            temp.next=head.next;
            (head.next).prev=temp;
            head.next=temp;
            temp.prev=head;
        }
        else{
            Node pre=findNode(k-1);
            temp.next=pre.next;
            (pre.next).prev=temp;
            pre.next=temp;
            temp.prev=pre;
        }
    }
}
