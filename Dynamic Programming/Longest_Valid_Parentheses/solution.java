class Solution {
public int longestValidParentheses(String s) {
        int n = s.length();
        if (n == 0) return 0;

        // DP array to store the length of the longest valid parentheses ending at each index
        int[] dp = new int[n];
        int maxLen = 0;

        // Iterate through the string starting from the second character
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == ')') { // Only consider when we have a closing parenthesis

                /*// Case 1: The previous character is '('
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                }
                // Case 2: The previous character is ')'
                else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + ((i - dp[i - 1] >= 2) ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }*/


                if (s.charAt(i - 1) == '(') {  // Case 1: The previous character is '('
                    // Valid pair "()", so add 2 to the length ending at two indices before
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    // Case 2: The previous character is ')'

                    // The index of the matching '(' is `i - dp[i - 1] - 1`
                    // We need to check if this index is valid and has '('

                    int previousValidLength = dp[i - 1];  // Length of the longest valid substring ending at i-1
                    int matchingOpeningIndex = i - previousValidLength - 1;  // Index of the potential matching '('

                    if (matchingOpeningIndex >= 0 && s.charAt(matchingOpeningIndex) == '(') {
                        // If matching index is valid and there is a '(' at that position

                        int lengthBeforeMatching = (matchingOpeningIndex >= 1) ? dp[matchingOpeningIndex - 1] : 0;
                        // Get the length of valid substring before the matching '(' if it exists

                        dp[i] = previousValidLength + lengthBeforeMatching + 2;
                        // Update dp[i] by adding:
                        // 1. The length of the previous valid substring `dp[i - 1]`
                        // 2. The length before the matching '(' `dp[matchingOpeningIndex - 1]`
                        // 3. Plus 2 for the matching "()" pair
                    }
                }

                // Update maxLen to the maximum value in dp array
                maxLen = Math.max(maxLen, dp[i]);
            }
        }

        return maxLen;
    }
}