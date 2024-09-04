class Solution {
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];

        // Initialize the DP table
        dp[0][0] = true; // Empty pattern matches empty string

        // Initialize the first row for patterns that can match an empty string
        for (int j = 1; j < dp[0].length; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                char pc = p.charAt(j - 1); // pattern character
                char sc = s.charAt(i - 1); // string character

                if (pc == '*') {
                    dp[i][j] = dp[i][j - 2]; // Match zero occurrences of the previous character

                    char pslc = p.charAt(j - 2); // Character before '*'
                    if (pslc == sc || pslc == '.') {
                        dp[i][j] = dp[i][j] || dp[i - 1][j]; // Match one or more occurrences
                    }
                } else if (pc == '.' || pc == sc) {
                    dp[i][j] = dp[i - 1][j - 1]; // Direct match or '.' match
                } else {
                    dp[i][j] = false;
                }
            }
        }

        return dp[s.length()][p.length()];

    }
}