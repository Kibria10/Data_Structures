package DHDCLL;

public class Node {
    public int element;
    public Node next;
    public Node prev;

    public Node(int e, Node n, Node p) {
        element = e;
        next = n;
        prev =p;
    }
}