import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BST {
    public static class Node{
        int data;
        Node left = null;
        Node right = null;
        //constructor
        Node(int data){
            this.data = data;
        }
    }

    //create BST
    public static void createBST(int[] arr, int n){
        Node r = null;
        for(int i=0;i<n;i++){
            r = insert(r,arr[i]);
        }
        delete(r, 5);
        boolean ans = search(r, 5);
        System.out.println(ans);
        preOrder(r);
        System.out.println();
        inOrder(r);
        System.out.println();
        postOrder(r);
        System.out.println();
    }

    //insertion
    public static Node insert(Node r,int x){
        if(r == null){
            return new Node(x);
        }
        if(r.data <x){
            r.right = insert(r.right,x);
        }else if(r.data >x){
            r.left = insert(r.left, x);
        }
        return r;
    }

    //inorder
    public static void inOrder(Node r){
        if(r == null){
            return;
        }
        inOrder(r.left);
        System.out.print(r.data + " ");
        inOrder(r.right);
    }

    //preorder
    public static void preOrder(Node r){
        if(r == null){
            return;
        }
        System.out.print(r.data + " ");
        preOrder(r.left);
        preOrder(r.right);
    }

    //postorder
    public static void postOrder(Node r){
        if(r == null){
            return;
        }
        postOrder(r.left);
        postOrder(r.right);
        System.out.print(r.data + " ");
    }

    //deletion
    public static Node delete(Node r,int x){
        if(r == null){
            return null;
        }
        if(r.data < x){
            r.right = delete(r.right,x);
        }else if(r.data >x){
            r.left = delete(r.left, x);
        }else{
            if(r.left == null && r.right == null){
                return null;
            }else if(r.left == null){
                return r.right;
            }else if(r.right == null){
                return r.left;
            }else{
                int val = MIN_VALUE(r.right);
                r.data =val;
                r.right = delete(r.right, val);
            }
        }
        return r;
    }
    private static int MIN_VALUE(BST.Node right) {
        return 0;
    }

    //search
    public static boolean search(Node r, int x){
        if(r==null){
            return false;
        }
        if(r.data == x){
            return true;
        }else if(r.data < x){
            return search(r.right, x);
        }else if(r.data > x){
            return search(r.left, x);
        }
        return false;
    }

    //inorder iterative
    public List<Integer> inorderTraversal(Node root) {
        List<Integer> res = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        Node curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            res.add(curr.data);
            curr = curr.right;
            }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        int n = 5;
        createBST(arr, n);
        System.out.println();
    }
}
