package SortSearchRecursion;

// Java program to construct binary tree from
// given array in level order fashion

import java.util.Scanner;

public class BinaryTree {
    Node root;

    // Tree Node
    static class Node {
        String data;
        Node left, right;
        Node(String data)
        {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // Function to insert nodes in level order
    public Node insertLevelOrder(String[] arr, Node root,
                                 int i)
    {
        // Base case for recursion
        if (i < arr.length) {
            Node temp = new Node(arr[i]);
            root = temp;

            // insert left child
            root.left = insertLevelOrder(arr, root.left,
                    2 * i + 1);

            // insert right child
            root.right = insertLevelOrder(arr, root.right,
                    2 * i + 2);
        }
        return root;
    }


    public void preOrder(Node root)
    {
        if (root != null) {
            System.out.print(root.data + " ");
            preOrder(root.left);
            preOrder(root.right);

        }
    }
    // Function to print tree nodes in InOrder fashion
    public void inOrder(Node root)
    {
        if (root != null) {
            inOrder(root.left);
            System.out.print(root.data + " ");
            inOrder(root.right);
        }
    }

    public void postOrder(Node root)
    {
        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data + " ");
        }
    }

    // Driver program to test above function
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        BinaryTree t2 = new BinaryTree();
        System.out.println("enter array size:");
        int a = sc.nextInt();
        String arr[] = new String[a+1];
        System.out.println("Enter values: ");
        for(int i =0; i< arr.length; i++){
            arr[i]= sc.nextLine();
        }

        t2.root = t2.insertLevelOrder(arr, t2.root, 0);
//
//        System.out.println("Pre Order: ");
//        t2.postOrder(t2.root);
        System.out.println("Pre Order: ");
        t2.preOrder(t2.root);

        System.out.println("\nIn Order: ");
        t2.inOrder(t2.root);

        System.out.println("\nPost Order: ");
        t2.postOrder(t2.root);
    }
}
