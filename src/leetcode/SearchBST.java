package leetcode;

public class SearchBST {
    public static void main(String[] args) {
        SearchBST bst = new SearchBST();
        int[] array = {4, 2, 7, 1, 3, 6, 9};
        TreeNode root = bst.createBinaryTree(array);
        TreeNode searchedNode = bst.searchBST(root, 1);
        bst.printNode(searchedNode);
    }

    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null || root.val == val) return root;// Base Cases: root is null or val is present at root
        if(root.val > val) return searchBST(root.left, val); // Value is greater than root's val then search in right side of the root
        return searchBST(root.right, val);//Value is smaller than root's val then search in left side of the root
    }

    public  TreeNode createBinaryTree(int[] array) {
        if (array == null || array.length == 0) {
            return null;
        }
        return createBinaryTreeHelper(array, 0, array.length - 1);
    }

    private TreeNode createBinaryTreeHelper(int[] array, int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = (start + end) / 2;
        TreeNode node = new TreeNode(array[mid]);

        node.left = createBinaryTreeHelper(array, start, mid - 1);
        node.right = createBinaryTreeHelper(array, mid + 1, end);

        return node;
    }

    public void printNode(TreeNode node) {
        if (node != null) {
            System.out.println(node.val);
        } else {
            System.out.println("Node is null.");
        }
    }

}
