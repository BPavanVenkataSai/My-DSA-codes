import java.util.Scanner;

public class KMPSubstringCount {
    public static int[] computeLPS(String pattern) {
        int m = pattern.length();
        int[] lps = new int[m];
        int length = 0;
        int i = 1;

        while (i < m) {
            if (pattern.charAt(i) == pattern.charAt(length)) {
                length++;
                lps[i] = length;
                i++;
            } else {
                if (length != 0) {
                    length = lps[length - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }

        return lps;
    }

    public static int countOccurrences(String pattern, String text) {
        int m = pattern.length();
        int n = text.length();
        int[] lps = computeLPS(pattern);
        int i = 0;
        int j = 0;
        int count = 0;

        while (i < n) {
            if (pattern.charAt(j) == text.charAt(i)) {
                i++;
                j++;

                if (j == m) {
                    count++;
                    j = lps[j - 1];
                }
            } else {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character after t

        for (int i = 0; i < t; i++) {
            String[] input = scanner.nextLine().split(" ");
            String A = input[0];
            String B = input[1];
            int occurrences = countOccurrences(A, B);
            System.out.println(occurrences);
        }

        scanner.close();
    }
}
