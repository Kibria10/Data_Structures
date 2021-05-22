package linkedList;

public class MyList {

    Node head;

    public MyList(int[] a) {

        head = new Node(a[0], null);
        Node n = head; // Create Head for LinkList
        for (int i = 1; i < a.length; i++) {
            Node Temp = new Node(a[i], null);
            n.next = Temp; // Take Previous Node Reference
            n = n.next;
        }
    }

    public MyList(Node h) {
        // Set Head
        head = h;
    }



    public int countNode() {
        int count = 0;
        for (Node n = head; n != null; n = n.next) {
            count++;
        }
        if (count == 0){
            System.out.println("EMPTY LIST");
        }

        return count;
    }

    public void printList() {
        Node n = head;
        if(n.next == null) {
            System.out.println("\nEMPTY LIST");
        }


        for (; n.next != null; n = n.next) {
            System.out.print(n.element + ", ");
        }
        System.out.println(n.element + ". ");
    }

    public Node nodeAt(int idx) {
        if (idx < 0 || idx >= countNode()) { // Invalid Range
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


    public int indexOf(int elem) {
        int i = 0;
        for (Node n = head; n != null; n = n.next) {
            if (n.element == elem) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public boolean Exist(int elem) {
        for (Node n = head; n != null; n = n.next) {
            if (n.element == elem) {
                return true;
            }
        }
        return false;
    }

    //Makes a duplicate copy of the given List. Returns the reference of the duplicate list.
    public Node copyList() {
        // Take a Copy of Head & Tail
        Node ch = new Node(0, null);
        Node ct = new Node(0, null);
        for (Node now = head; now != null; now = now.next) {
            if (ch.element == 0) {
                ch.element = now.element;
                ch.next = ct;
                ct = ch;
            } else {
                ct.next = new Node(now.element, null);
                ct = ct.next;
            }
        }
        return ch;
    }



    public void insertAtLast(int elem) {
        for (Node n = head; n != null; n = n.next) {
            if (n.element == elem) {
                System.out.println("Element Already Exists");
                return;
            }
        }
        int idx = countNode();
        Node newNode = new Node(elem, null);
        Node prev = nodeAt(idx-1);
        prev.next = newNode;
    }


    public void insert(int elem, int idx) {
        for (Node n = head; n != null; n = n.next) {
            if (n.element == elem) {
                System.out.println("Element Already Exists");
                return;
            }
        }
        if (idx < 0 || idx > countNode()) {
            System.out.println("Invalid Index");
        } else {
            Node newNode = new Node(elem, null);
            if (idx == 0) {
                newNode.next = head;
                head = newNode;
            } else {
                Node priv = nodeAt(idx - 1);
                newNode.next = priv.next;
                priv.next = newNode;
            }
        }
    }

    public  void reset() {

        head = null;

    }


    public void rotateLeftRunTime(int time) {
        for (int i = 0; i < time; i++) {
            rotateLeft();
        }
    }
    public void rotateLeft() {
        Node n = head;
        while (n.next != null) {
            n = n.next;
        }
        Node temp = head.next;
        n.next = head;
        head.next = null;
        head = temp;
    }


    public void rotateRightRunTime(int time) {
        for (int i = 0; i < time; i++) {
            rotateRight();
        }
    }
    public void rotateRight() {
        Node n = head;
        Node tail = null;
        for (; n.next != null; n = n.next) {
            if ((n.next).next == null) {
                tail = n;
            }
        }
        Node temp = head;
        n.next = temp;
        head = n;
        tail.next = null;
    }

    public void Removing(int key)
    {
        Node n = head, prev = null;

        if (n != null && n.element == key) {
            head = n.next; // Changed head
            return;
        } //If head node has he key element that is needed to be deleted.
        while (n != null && n.element != key) {
            prev = n;
            n = n.next;
        }
        if (n == null)
            return;
        prev.next = n.next;
    }

    public void SortingList() {
        Node n = head, idx = null;
        int k;

        if(head == null) {
            return;
        }
        else {
            while(n != null) {
                idx = n.next;
                while(idx != null) {
                    if(n.element >idx.element) {
                        k = n.element;
                        n.element = idx.element;
                        idx.element = k;
                    }
                    idx = idx.next;
                }
                n = n.next;
            }
        }
    }

    public Node reverseList() {
        Node revNode = new Node(head.element, null);
        for (Node n = head.next; n != null; n = n.next) {
            Node Temp = new Node(n.element, revNode);
            revNode= Temp;
        }
        return revNode;
    }

    public void EvenNumDetector()
    {
        Node odd = null,  even = null,  last = null;
        Node temp = this.head;
        while (temp != null)
        {
            if (temp.element % 2 == 0) // even node
            {
                if (even == null) {
                    even = last = temp;
                }
                else {
                    last.next = temp;
                    last = temp;
                }
            }
            temp = temp.next;
        }
        if (even != null) {
            this.head = even;
        }
        if (last != null) {
            last.next = odd;
        }
    }

    public int Summation() {

        Node n = head;
        //    Node tail = null;
        if(n == null) {
            return 0;
        }
        int sum = 0;
        while(n != null) {
            sum = sum + n.element;
            n = n.next;
        }
        return sum;
    }



}
