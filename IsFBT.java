import java.util.Scanner;

class Node {
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}

public class IsFBT {

    public static boolean isFullBinaryTree(Node node) {
        if (node == null)
            return true;

        if (node.left == null && node.right == null)
            return true;

        if (node.left == null || node.right == null)
            return false;

        return isFullBinaryTree(node.left) && isFullBinaryTree(node.right);
    }

    public static Node insert(Node node, int value) {
        if (node == null)
            return new Node(value);

        if (value < node.value)
            node.left = insert(node.left, value);
        else if (value > node.value)
            node.right = insert(node.right, value);

        return node;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();

        while (t-- > 0) {
            int n = scanner.nextInt();
            Node root = null;

            for (int i = 0; i < n; i++) {
                int value = scanner.nextInt();
                root = insert(root, value);
            }

            boolean isFullBinary = isFullBinaryTree(root);
            System.out.println(isFullBinary ? "True" : "False");
        }

        scanner.close();
    }
}
