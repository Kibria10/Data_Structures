package linkedList;

public class Tester {

    public static void main(String[] args) {
//Task1(a,b)
        System.out.println("\nCreating List from an array");
        int[] arr1 = {10, 20, 30, 40};
        MyList ref1 = new MyList(arr1);
        System.out.println("\nNew List: ");
        ref1.printList(); // This should print: 10,20,30,40.
        System.out.println("\nTotal Number of Nodes: " + ref1.countNode());
//Task1(c)
        System.out.println("\nCopying A Linked List");
        int[] a2 = {10, 20, 30, 40, 50, 60, 70};
        MyList cop = new MyList(a2);
        cop.printList();
        Node copyH = cop.copyList();
        MyList h3 = new MyList(copyH);
        System.out.println("\nNew List: ");
        h3.printList();
//Just a much needed method for other methods^^
        System.out.println("\nReturns The Element of Given Index");
        Node myNode = ref1.nodeAt(1);
        System.out.println(myNode.element);
//Just a much needed method for other methods^^
        System.out.println("\nReturns The Index of Given Element");
        int index = ref1.indexOf(40);
        System.out.println(index);
//Task2.4
        System.out.println("\n♛EMPTYING A LINKED LIST♛");
        int[] reset = {10, 20, 30, 40, 50};
        MyList res = new MyList(reset);
//         res.printList();
//         res.reset();
//         res.printList();

//Task2.5
        System.out.println("\n♛INSERTION at LAST NODE♛");
        int[] insert = {10, 20, 30, 40, 50};
        MyList iln = new MyList(insert);
        iln.printList();
        iln.insertAtLast(85);
        iln.insertAtLast(85);
        iln.printList();

//Task2.6
        System.out.println("\n♛INSERTION at ANY INDEX♛");
        int[] arr6 = {10, 20, 30, 40};
        MyList ins = new MyList(arr6);
        ins.printList();
        ins.insert(85, 0);
        ins.printList();
        ins.insert(40, 3);
        ins.printList();
        ins.insert(75, 6);
        ins.printList();
//Task2.7
        System.out.println("\n♛DELETE or REMOVE PARTICULAR ELEMENT♛");
        int[] arr7 = {10, 20, 30, 40, 50, 60, 70};
        MyList rem = new MyList(arr7);
        System.out.println("Input Values:");
        rem.printList();
        rem.Removing(30);
        System.out.println("Output Values:");
        rem.printList();
//Task3.1
        System.out.println("\n♛EVEN NUMBER DETECTION♛");
        int[] arr10 = {10, 20, 33, 69, 70, 99};
        MyList eve = new MyList(arr10);
        System.out.println("Input Values:");
        eve.printList();
        eve.EvenNumDetector();
        System.out.println("Output Values:");
        eve.printList();
//Task3.2
        System.out.println("\n♛AVAILABILITY♛");
        boolean ans = ref1.Exist(40);
        System.out.println(ans);
//Task3.3
        System.out.println("\n♛REVERSE♛");
        int[] arr4 = {10, 20, 30, 40, 50};
        MyList rev = new MyList(arr4);
        System.out.println("Input Values:");
        rev.printList();
        Node revH = rev.reverseList();
        MyList h5 = new MyList(revH);
        System.out.println("Output Values:");
        h5.printList();
//Task3.4
        System.out.println("\n♛SORTING♛");
        int[]sort={7,11,3,4,6,1};
        MyList sorty = new MyList(sort);
        System.out.println("Input Values:");
        sorty.printList();
        sorty.SortingList();
        System.out.println("Output Values:");
        sorty.printList();
//Task3.5
        System.out.println("\n♛SUMMATION♛");
        int[] sum = {1, 2, 3, 4, 5};
        MyList h11 = new MyList(sum);
        System.out.println("Input Values:");
        h11.printList();
        System.out.println("Sum of the nodes: "+ h11.Summation());
//Task3.6(LeftShift)
        System.out.println("\n♛LEFT SHIFT K TIMES♛");
        int[] arr8 = {10, 20, 30, 40, 50, 60};
        MyList lsh = new MyList(arr8);
        System.out.println("Input Values:");
        lsh.printList();
        lsh.rotateLeftRunTime(2);
        System.out.println("Output Values:");
        lsh.printList();
//Task3.6(RightShift)
        System.out.println("\n♛RIGHT SHIFT K TIMES♛");
        int[] a9 = {10, 20, 30, 40};
        MyList h9 = new MyList(a9);
        System.out.println("Input Values:");
        h9.printList();
        h9.rotateRightRunTime(3);
        System.out.println("Output Values:");
        h9.printList();

        System.out.println(h9.countNode());


    }
}
