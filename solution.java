import java.util.Scanner;

public class solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int j = 0; j < n; j++) {
                a[j] = sc.nextInt();
            }
            System.out.println(solve(a));
        }
        sc.close();
    }

    public static long solve(int[] a) {
        long max1 = Long.MIN_VALUE;
        long max2 = Long.MIN_VALUE;
        long min = Long.MAX_VALUE;

        for (int i = 0; i < a.length; i++) {
            if (a[i] < 0) {
                long temp = max1;
                max1 = min;
                min = temp;
            }

            max1 = Math.max(max1, a[i] * max1);
            max1 = Math.max(max1, a[i] * min);

            if (i > 0) {
                max2 = Math.max(max2, a[i] * a[i - 1]);
            }
        }

        return Math.max(max1, max2);
    }
}
