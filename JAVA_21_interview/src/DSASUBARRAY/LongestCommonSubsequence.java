package DSASUBARRAY;

public class LongestCommonSubsequence {
    public static int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m + 1][n + 1];

        // Build the DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char a=text1.charAt(i - 1);
                char b=text2.charAt(j - 1);
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;  // Match: extend LCS
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);  // No match: take max
                }
            }
        }

        return dp[m][n];  // The bottom-right cell contains the LCS length
    }

    public static void main(String[] args) {
        String A = "abcde";
        String B = "ace";
        System.out.println(longestCommonSubsequence(A,B));
    }
}
