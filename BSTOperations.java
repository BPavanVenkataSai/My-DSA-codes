import java.util.*;

public class BSTOperations {
public static void main(String[] args) {
Scanner in = new Scanner(System.in);
int t = in.nextInt();
int q, type, val;
BinarySearchTree bst;
    for (int i = 1; i <= t; i++) {
        bst = new BinarySearchTree();
        q = in.nextInt();
        System.out.println("Case #" + i + ":");
        
    for (int j = 0; j < q; j++) {
        type = in.nextInt();
            
        if (type == 1) {
            val = in.nextInt();
            bst.insert(val);
        } else if (type == 2) {
            val = in.nextInt();
            bst.delete(val);
        } else if (type == 3) {
            val = in.nextInt();
            if (bst.search(val))
                System.out.println("Yes");
            else
                System.out.println("No");
        } else {
            bst.preorder();
        }
    }
}
    
    in.close();
}
}

class Node {
int val;
Node left, right;
    public Node(int val) {
    this.val = val;
    left = null;
    right = null;
}
    }

class BinarySearchTree {
Node root;
    public BinarySearchTree() {
    root = null;
}

public void insert(int val) {
    root = insertRec(root, val);
}

public void delete(int val) {
    root = deleteRec(root, val);
}

public boolean search(int val) {
    return searchRec(root, val);
}

public void preorder() {
    preorderRec(root);
    System.out.println();
}

private Node insertRec(Node root, int val) {
    if (root == null) {
        root = new Node(val);
        return root;
    }
    
    if (val < root.val)
        root.left = insertRec(root.left, val);
    else if (val > root.val)
        root.right = insertRec(root.right, val);
    
    return root;
}

private Node deleteRec(Node root, int val) {
    if (root == null)
        return root;
    
    if (val < root.val)
        root.left = deleteRec(root.left, val);
    else if (val > root.val)
        root.right = deleteRec(root.right, val);
    else {
        if (root.left == null)
            return root.right;
        else if (root.right == null)
            return root.left;
        
        root.val = minValue(root.right);
        root.right = deleteRec(root.right, root.val);
    }
    
    return root;
}

private int minValue(Node root) {
    int minv = root.val;
    while (root.left != null) {
        minv = root.left.val;
        root = root.left;
    }
    return minv;
}

private boolean searchRec(Node root, int val) {
    if (root == null)
        return false;
    
    if (root.val == val)
        return true;
    
    if (val < root.val)
        return searchRec(root.left, val);
    
    return searchRec(root.right, val);
}

private void preorderRec(Node root) {
    if (root != null) {
        System.out.print(root.val + " ");
        preorderRec(root.left);
        preorderRec(root.right);
    }
}
}