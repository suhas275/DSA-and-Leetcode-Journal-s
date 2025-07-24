public class DecodeWays {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') return 0;

        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1; // Empty string
        dp[1] = 1; // First character already checked is not '0'

        for (int i = 2; i <= n; i++) {
            // Single digit (s.charAt(i - 1))
            if (s.charAt(i - 1) != '0') {
                dp[i] += dp[i - 1];
            }

            // Two digits (s.substring(i - 2, i))
            int twoDigit = Integer.parseInt(s.substring(i - 2, i));
            if (twoDigit >= 10 && twoDigit <= 26) {
                dp[i] += dp[i - 2];
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        DecodeWays dw = new DecodeWays();
        System.out.println(dw.numDecodings("12"));    // Output: 2
        System.out.println(dw.numDecodings("226"));   // Output: 3
        System.out.println(dw.numDecodings("06"));    // Output: 0
        System.out.println(dw.numDecodings("11106")); // Output: 2
    }
}
