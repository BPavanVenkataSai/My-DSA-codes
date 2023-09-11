import java.util.Scanner;

public class TreeTraversals {
    public static class Node{
        int data;
        Node left = null;
        Node right = null;
        //constructor
        Node(int data){
            this.data = data;
        }
    }
    public static void createBST(int[] arr, int n){
        Node r = null;
        for(int i=0;i<n;i++){
            r = insert(r,arr[i]);
        }
        preOrder(r);
        System.out.println();
        inOrder(r);
        System.out.println();
        postOrder(r);
        System.out.println();
    }
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
    public static void inOrder(Node r){
        if(r == null){
            return;
        }
        inOrder(r.left);
        System.out.print(r.data + " ");
        inOrder(r.right);
    }
    public static void preOrder(Node r){
        if(r == null){
            return;
        }
        System.out.print(r.data + " ");
        preOrder(r.left);
        preOrder(r.right);
    }public static void postOrder(Node r){
        if(r == null){
            return;
        }
        postOrder(r.left);
        postOrder(r.right);
        System.out.print(r.data + " ");
    }
    public static void main(String[] args) {
        try (/* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in)) {
            int t = in.nextInt();
            while(t-->0){
                int n = in.nextInt();
                int[] arr = new int[n];
                for(int i=0;i<n;i++){
                    arr[i] = in.nextInt();
                }
                createBST(arr,n);
                System.out.println();
            }
        }
    }
}
