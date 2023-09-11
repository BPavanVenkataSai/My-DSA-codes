import java.util.*;

public class SieveofEratosthenes {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            boolean[] isPrime = new boolean[n+1];
            Arrays.fill(isPrime, true);
            isPrime[0] = isPrime[1] = false;
            for (int i = 2; i*i <= n; i++) {
                if (isPrime[i]) {
                    for (int j = i*i; j <= n; j += i) {
                        isPrime[j] = false;
                    }
                }
            }
            for (int i = 2; i <= n; i++) {
                if (isPrime[i]) {
                    System.out.print(i + " ");
                }
            }
        }
    }
}
