package Stack;


import java.util.Scanner;

public class ParenthesesChecker {
    public static void checkBalance(String str, int x) {

        if (x == 1) {

            StackList listStack = new StackList();

            for (int i = 0; i < str.length(); i++) {

                char ch = str.charAt(i);

                if (ch == '[' || ch == '(' || ch == '{') {
                    listStack.push(ch);
                }
                else if ((ch == ']' || ch == '}' || ch == ')')  && (!listStack.isEmpty()))
                {
                    if (((char) listStack.peek() == '(' && ch == ')')  || ((char) listStack.peek() == '{' && ch == '}') || ((char) listStack.peek() == '[' && ch == ']'))
                    {
                        listStack.pop();
                    }
                    else {
                        System.out.println("Not Balanced (list)");
                        return;
                    }
                } else {
                    if ((ch == ']' || ch == '}' || ch == ')')) {
                        System.out.println("Not Balanced (list)");
                        return;
                    }
                }

            }

            if (listStack.isEmpty())
                System.out.println("Balanced");
            else
                System.out.println("Not Balanced");
        }
        else if (x == 2) {
            int k = str.length();
            StackArray arrStack = new StackArray();
            arrStack.JStack(k);

            for (int i = 0; i < str.length(); i++) {

                char ch = str.charAt(i);

                if (ch == '[' || ch == '(' || ch == '{') {
                    arrStack.push(ch);
                } else if ((ch == ']' || ch == '}' || ch == ')')
                        && (!arrStack.isEmpty())) {
                    if (((char) arrStack.peek() == '(' && ch == ')')
                            || ((char) arrStack.peek() == '{' && ch == '}')
                            || ((char) arrStack.peek() == '[' && ch == ']')) {
                        arrStack.pop();
                    } else {
                        System.out.println("Not Balanced(array1)");
                        return;
                    }
                } else {
                    if ((ch == ']' || ch == '}' || ch == ')')) {
                        System.out.println("Not Balanced(array2)");
                        return;
                    }
                }

            }

            if (arrStack.isEmpty())
                System.out.println("Balanced");
            else {
                System.out.println("Not Balanced");
                return;
            }
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the pattern you want to input:");
        String str = sc.nextLine();
        if (str.isEmpty()) {
            System.out.println("Empty String");
            return;


        } else {
            System.out.println("Choose how you want to execute the process.");
            System.out.println("Enter 1 if you want to use the operation with linkedlist based stack");
            System.out.println("If you want to proceed with array based stack then press 2");
            int x =sc.nextInt();
            ParenthesesChecker.checkBalance(str,x);

        }


    }
}


 class StackArray {
    private Object[] data;
    private int index = 0;
    private int size = 0;

    public void JStack (int a) {
        this.size = a;
        data = new Object[this.size];
    }

    public void push(char o) {
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


 class StackList {
    private class Node {

        int data; // integer data
        Node link; // reference variable Node type
    }

    Node top;

    StackList()
    {
        this.top = null;
    }


    public void push(int x) // insert at the beginning
    {

        Node temp = new Node();

        if (temp == null) {
            System.out.print("\nstack Overflow");
            return;
        }


        temp.data = x;


        temp.link = top;

        top = temp;
    }

    public boolean isEmpty()
    {
       // System.out.println("list empty");
        return top == null;

    }

    // Utility function to return top element in a stack
    public int peek()
    {
        // check for empty stack
        if (!isEmpty()) {
            return top.data;
        }
        else {
            System.out.println("Stack is empty");
            return -1;
        }
    }

    public void pop()
    {
        // check for stack underflow
        if (top == null) {
            System.out.print("\nStack Underflow");
            return;
        }


        top = top.link;
    }

}