package theory.assignment01;

    public class Task5 {

        public static void main(String[] args) {
            int[] t5 = {1,2,3,4,5,10,13,25,27,40};
            Task5 v = new Task5(t5);
            System.out.println("\nOriginal List: ");
            v.printList();
            v.FiveMultipleRemoval();
            System.out.println("\nAfter removing nodes containing multiples of 5: ");
            v.printList();
        }


        Node head;
        //Creating singly linked list from array input
        public Task5(int[] a) {

            head = new Node(a[0], null);
            Node n = head; // Create Head for LinkList
            for (int i = 1; i < a.length; i++) {
                Node Temp = new Node(a[i], null);
                n.next = Temp; // Take Previous Node Reference
                n = n.next;
            }
        }

        public void FiveMultipleRemoval() {
            Node Head1 = null, Head2 = null, Last = null;
            Node temp = this.head;
            while (temp != null) {
                if (temp.element % 5 != 0)
                {
                    if (Head2 == null)
                    {
                        Head2 = Last = temp;
                    } else {
                        Last.next = temp;
                        Last = temp;
                    }
                }
                temp = temp.next;
            }
            if (Head2 != null)
            {
                this.head = Head2;
            }
            if (Last != null)
            {
                Last.next = Head1;
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
