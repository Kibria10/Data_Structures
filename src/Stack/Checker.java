package Stack;
import java.util.Scanner;



class Tester {
    public static void main(String[] args) {
        Checker gg = new Checker();
        Scanner sc = new Scanner(System.in);
        System.out.println("Please Enter Parentheses: ");
        String pt = sc.nextLine();
        if (pt.isEmpty()) {
            System.out.println("Empty String");
            return;
        } else {
            System.out.println("////CHOOSE WHICH METHOD YOU WANT TO USE////");
            System.out.println("Press 1 For LinkedList Based Execution");
            System.out.println("Press 2 For Array Based Execution");
            int x = sc.nextInt();
            gg.ParenthesesChecker(pt, x);

        }
    }
}


class Checker {
    public void ParenthesesChecker(String parentheses, int selector) {
        StackViaLinkedList listStack = new StackViaLinkedList();
        StackViaArray arrStack = new StackViaArray();

        if (selector == 1) {
            System.out.println("////RESULT GIVEN IN LINKED LIST BASED STACK IMPLEMENTATION////");

            char[] input = parentheses.toCharArray();


            int count = 0;
            for (int i = 0; i < input.length; i++) {
                if (input[i] == '[' || input[i] == '{' || input[i] == '(') {
                    listStack.push(count);
                    listStack.push(input[i]);
                } else if ((input[i] == ']' || input[i] == '}' || input[i] == ')') && (!listStack.isEmpty())) {
                    if (((char) listStack.peek() == '(' && input[i] == ')') || ((char) listStack.peek() == '{' && input[i] == '}') || ((char) listStack.peek() == '[' && input[i] == ']')) {
                        listStack.pop();
                        listStack.pop();
                    } else {
                        System.out.println("❌ Unbalanced Parentheses ❌ ");
                        System.out.println("Parentheses causing this is: "+(char)listStack.pop());
                        System.out.println("Which is in index: " + listStack.pop());
                        return;
                    }
                } else {
                    if ((input[i] == ']' || input[i] == '}' || input[i] == ')')) {
                        System.out.println("❌ Unbalanced Parentheses ❌ ");
                        System.out.println("Parentheses causing this is: "+(char)listStack.pop());
                        System.out.println("Which is in index: " + listStack.pop());
                        return;
                    }
                }
                count++;
            }


            if (listStack.isEmpty()) {
                System.out.println(" ✔️Your Given Input Has Balanced Parentheses ✔️");
                //listStack.display();
            } else {
                System.out.println("❌ Unbalanced Parentheses ❌ ");
                int a = listStack.lastElem();
                //System.out.println(a);
                char b = (char) a; //Making ASCII to CHAR again
                System.out.print("The parentheses causing this error is: '" + b + "' which is in index: " + listStack.getIndex());
                if (b == '[' || b == '(' || b == '{')
                    System.out.print(" and not closed.");
                else if (b == ']' || b == '}' || b == ')')
                    System.out.print(" and not opened.");
            }
        }

        ///////////////////////////////////////////////////////////////////////////////////////////

        else if (selector == 2) {
            System.out.println("////RESULT GIVEN IN ARRAY BASED STACK IMPLEMENTATION////");
            int k = parentheses.length();

            arrStack.dynamicSize(k*2);
            char [] input = parentheses.toCharArray();

            int count = 0;
            for (int i = 0; i < input.length; i++) {
                if (input[i] == '[' || input[i] == '(' || input[i] == '{') {
                    arrStack.push((Object) count);
                    arrStack.push(input[i]);
                } else if ((input[i] == ']' || input[i] == '}' || input[i] == ')')
                        && (!arrStack.isEmpty())) {
                    if (((char) arrStack.peek() == '(' && input[i] == ')')
                            || ((char) arrStack.peek() == '{' && input[i] == '}')
                            || ((char) arrStack.peek() == '[' && input[i] == ']')) {
                        arrStack.pop();
                        arrStack.pop();
                    } else {
                        System.out.println("❌ Unbalanced Parentheses ❌");
                        System.out.println("Parentheses causing this error is: "+arrStack.pop());
                        System.out.println("Which is in index: " + arrStack.pop());
                        return;
                    }
                } else {
                    if ((input[i] == ']' || input[i] == '}' || input[i] == ')')) {
                        System.out.println("❌ Unbalanced Parentheses ❌");
                        System.out.println("Parentheses causing this error is: "+arrStack.pop());
                        System.out.println("Which is in index: " + arrStack.pop());
                        return;
                    }
                }
                count++;
            }

//without special condition.

//            for(int i=0;i<input.length;i++){
//                if(input[i] == '[' || input[i] == '{' || input[i] == '('){
//                    arrStack.push((Object) count);
//                    arrStack.push(input[i]);
//                }else if(((char)arrStack.peek() == '[' && input[i] == ']') || ((char)arrStack.peek() == '{' && input[i] == '}') || ((char)arrStack.peek() == '(' && input[i] == ')')){
//                    arrStack.pop();
//                    arrStack.pop();
//                }
//            count++;
//            }

            if (arrStack.isEmpty())
                System.out.println("✔️Your Given Input Has Balanced Parentheses  ✔️");
            else {
                System.out.println("❌ Unbalanced Parentheses ❌");
                Object pt = arrStack.pop();
                System.out.print("Parentheses causing this error is: '"+pt + "', ");
                if ((char)pt == '[' || (char)pt == '(' || (char)pt == '{')
                    System.out.print(" which is not closed.");
                else if ((char)pt == ']' || (char)pt == '}' || (char)pt == ')')
                    System.out.print(" which is not opened.");

                Object idx = arrStack.pop();
                System.out.println(" And its in index: " + idx);
                return;
            }
        }
    }
}



//Stack functions based on linked lists
class StackViaLinkedList {
    private class Node {
        int data;
        Node nextLink;
    }
    Node head;
    StackViaLinkedList() {

        this.head = null;
    }

    public void push(int x) {
        Node var = new Node();
        if (var == null) {
            System.out.print("\nHeap Overflow");
            return;
        }
        var.data = x;
        var.nextLink = head;
        head = var;
    }
//method for passing an array and pushing the full array in
    public void PushFullList(int[] a) {

        for (int i = 0; i < a.length; i++) {
            Node var = new Node();
            var.data = a[i];
            var.nextLink = head;
            head = var;
        }
    }

    public boolean isEmpty()
    {
        return head == null;
    }

    public int peek() {
        if (!isEmpty()) {
            return head.data;
        } else {
           // System.out.println("Stack is empty");
            return -1;
        }
    }

//    public void display() {
//        if (head == null) {
//            System.out.printf("\nStack is empty");
//            return;
//        }
//        else {
//            Node temp = head;
//            while (temp != null) {
//                System.out.printf("%d->", temp.data);
//                temp = temp.nextLink;
//            }
//        }
//    }


    public int lastElem(){
        Node temp =head;
        int k = temp.data;
        return k;
    }

    public int getIndex(){
        Node idx = head.nextLink;
        int value = idx.data;
        return value;
    }

    public int pop()
    {

        if (head == null) {
            System.out.print("\nStack is Empty");
            return -1;
        }
        Node temp = head;
        head = (head).nextLink;
        return temp.data;
    }
}

//Stack functions based on array
class StackViaArray {
    private Object[] data;
    private int index = 0;
    private int size = 0;

    public void dynamicSize(int a) {
        this.size = a;
        data = new Object[this.size];
    }

    public void push(Object o) {
        this.data[index] = o;
        index++;

    }

    public Object pop() {
        if (index != 0) {
            Object obj = data[index - 1];
            this.data[index - 1] = null; // Deleted
            index--;
            return obj;
        } else
            return null;
    }

    public Object peek() throws RuntimeException {
        if (index != 0)
            return this.data[index - 1];
        else
            return null;
    }

    public boolean isEmpty() {
        return index == 0;
    }

    }


