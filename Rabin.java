import java.util.Scanner;

public class Rabin {
    
    private static final int BASE = 31; // base used for hashing
    private static final int MOD1 = 1_000_000_007; // first prime number used for hashing
    private static final int MOD2 = 1_000_000_009; // second prime number used for hashing
    
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int t = in.nextInt();
            while (t-- > 0) {
                String A = in.next();
                String B = in.next();
                System.out.println(countOccurrences(A, B));
            }
        }
    }
    
    private static int countOccurrences(String A, String B) {
        int count = 0;
        int n = B.length();
        int m = A.length();
        long[] Ahash = new long[m];
        long[] Bhash1 = new long[n - m + 1];
        long[] Bhash2 = new long[n - m + 1];
        long[] pow1 = new long[n];
        long[] pow2 = new long[n];
        pow1[0] = pow2[0] = 1;
        for (int i = 1; i < n; i++) {
            pow1[i] = (pow1[i - 1] * BASE) % MOD1;
            pow2[i] = (pow2[i - 1] * BASE) % MOD2;
        }
        for (int i = 0; i < m; i++) {
            Ahash[i] = (A.charAt(i) * pow1[m - i - 1]) % MOD1;
            Bhash1[0] = (Bhash1[0] * BASE + B.charAt(i)) % MOD1;
            Bhash2[0] = (Bhash2[0] * BASE + B.charAt(i)) % MOD2;
        }
        for (int i = 1; i <= n - m; i++) {
            Bhash1[i] = (Bhash1[i - 1] - (B.charAt(i - 1) * pow1[m - 1]) % MOD1 + MOD1) % MOD1;
            Bhash1[i] = (Bhash1[i] * BASE + B.charAt(i + m - 1)) % MOD1;
            Bhash2[i] = (Bhash2[i - 1] - (B.charAt(i - 1) * pow2[m - 1]) % MOD2 + MOD2) % MOD2;
            Bhash2[i] = (Bhash2[i] * BASE + B.charAt(i + m - 1)) % MOD2;
        }
        for (int i = 0; i <= n - m; i++) {
            if (Ahash[0] == Bhash1[i] && Ahash[0] == Bhash2[i] && A.equals(B.substring(i, i + m))) {
                count++;
            }
        }
        return count;
    }
}