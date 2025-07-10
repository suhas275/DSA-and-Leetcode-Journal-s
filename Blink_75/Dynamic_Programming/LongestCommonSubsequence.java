public class LongestCommonSubsequence {

    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();

        // Create a 2D dp array
        int[][] dp = new int[m + 1][n + 1];

        // Fill the dp table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // If characters match, take diagonal + 1
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    // Else, take max of left and top
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // Return the bottom-right value in the table
        return dp[m][n];
    }

    // Example usage
    public static void main(String[] args) {
        LongestCommonSubsequence lcs = new LongestCommonSubsequence();
        String text1 = "abcde";
        String text2 = "ace";

        int result = lcs.longestCommonSubsequence(text1, text2);
        System.out.println("Longest Common Subsequence length: " + result); // Output: 3
    }
}

// 🧠 Time and Space Complexity
// Time	    O(m * n)
// Space	O(m * n)
// Where m = text1.length() and n = text2.length()