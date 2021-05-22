package DHDCLL;

class DoublyTest{
    public static void main(String[] args){
        Lab03 t =new Lab03();
        Object [] arr={10,20,30,40,50};
        t.DoublyList(arr);
        System.out.println("\nOriginal List:");
        t.showList();

        System.out.println();

        t.insert(300,3);
        System.out.println("\nInsertion at given index:");
        t.showList();

        System.out.println();

        t.insertAtTail(74598375);
        System.out.println("\nInsert at tail:");
        t.showList();

        System.out.println();

        t.remove(5);
        System.out.println("\nRemoving from given index:");
        t.showList();

        System.out.println();

        System.out.println("\nRemoving given key:");
        t.removeKey(74598375);
        t.showList();
    }
}

class Lab03{
    Node head;
//Task.a
    void DoublyList(Object [] a){
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
    class Node{

        Object elem;
        Node next;
        Node prev;

        Node(Object i,Node n,Node p){

            elem=i; next=n;prev=p;
        }
    }

    public int countNode() {
        int count = 0;
        for (Node n = head.next; n != head; n = n.next) {
            count++;
        }
        if (count == 0){
            System.out.println("EMPTY LIST");
        }
        return count;
    }

    Node findNode(int idx){
        Node tail=head;
        if (idx<0){ return null;}
        else{
            int count=0;
            for(tail=head.next;tail!=head;tail=tail.next,count++){
                if (count==idx)
                    return tail;
            }
            return null;
        }
    }

//Task.b
    void showList() {
        System.out.println();
        for (Node n = head.next; n != head; n = n.next) {
            System.out.print(n.elem + ", ");
        }
    }
//Task.c
    void insertAtTail(Object elem) {
        Node temp = new Node(elem, null, null);
        for (Node n = head.next; n != head; n = n.next) {
            if (n.elem == elem) {
                System.out.println("Element Already Exists");
                return;
            }
        }
            Node tail = findNode(countNode()-1);
            temp.next = head;
            temp.prev = tail;
            tail.next = temp;
    }

//Task.d
    void insert(Object elem,int idx){
        Node tail;
        Node temp=new Node(elem,null,null);

        if (idx==0){
            temp.next=head.next;
            (head.next).prev=temp;
            head.next=temp;
            temp.prev=head;
        }
        else{
            Node pre=findNode(idx-1);
            temp.next=pre.next;
            (pre.next).prev=temp;
            pre.next=temp;
            temp.prev=pre;
        }
    }
//Task.e
    Object remove(int idx){
        Object n=null;

        if (idx==0){
            n=head.next.elem;
            head.next=head.next.next;
            head.next.prev=head;
        }

        else{
            Node pre=findNode(idx-1);
            n=pre.next.elem;
            pre.next=pre.next.next;
            pre.next.prev=pre;
        }
        return n;
    }

//Task.f
    void removeKey(Object key){
        int count =0;
        for (Node n = head.next; n != head; n = n.next) {

           if(n.elem ==key){
               count++;
               break;
           }
           else
               count++;
        }
        int l = count-1; //Storing delete key's index
        remove(l); //calling task5 method.
}

}