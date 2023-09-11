import java.util.*;

public class enclosingSubstring {
    public static void main(String[] args) {
        try (/* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in)) {
            int t = in.nextInt();
            while(t-->0){
                String A = in.next();
                String B = in.next();
                int[] count = new int[26];
                for(int i=0;i<A.length();i++){
                    count[A.charAt(i)-'a']++;
                }
                int left =0;
                int right =0;
                int minLen = Integer.MAX_VALUE;
                int missing = A.length();
                while(right<B.length()){
                    if(count[B.charAt(right)-'a']-- > 0){
                        missing--;
                    }
                    while(missing == 0){
                        minLen = Math.min(minLen,right-left+1);
                        if(count[B.charAt(left++)-'a']++ == 0){
                            missing++;
                        }
                    }
                    right++;
                }
                if(minLen == Integer.MAX_VALUE){
                    System.out.println(-1);
                }else{
                    System.out.println(minLen);
                }
            }
        }
    }
}
