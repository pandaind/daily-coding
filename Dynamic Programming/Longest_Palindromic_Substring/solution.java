class Solution {
    public String longestPalindrome(String s) {
        // Check for the base case where the input string is null or empty
        if (s == null || s.length() < 1) return "";

        int start = 0, end = 0; // Variables to store the start and end indices of the longest palindromic substring found
        
        // Loop through each character in the string to consider it as a center for potential palindromes
        for (int i = 0; i < s.length(); i++) {
            // Consider the current character as the center of an odd-length palindrome
            int len1 = expandAroundCenter(s, i, i);       
            // Consider the current and next character as the center of an even-length palindrome
            int len2 = expandAroundCenter(s, i, i + 1);   
            // Get the maximum length of palindrome found from both cases
            int len = Math.max(len1, len2);
            
            // If the palindrome length found is greater than the previously recorded longest length
            if (len > end - start) {
                // Update the start index to the new start of the palindrome
                start = i - (len - 1) / 2;
                // Update the end index to the new end of the palindrome
                end = i + len / 2;
            }
        }
        
        // Return the longest palindromic substring found using the start and end indices
        return s.substring(start, end + 1);
    }

    // Helper method to expand around the center and find the length of the palindrome
    private int expandAroundCenter(String s, int left, int right) {
        // Expand outwards as long as the characters on both sides are equal
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;  // Move the left pointer to the left
            right++; // Move the right pointer to the right
        }
        // Return the length of the palindrome found (right - left - 1)
        return right - left - 1;
    }




    public String longestPalindromeDP(String s) {
    int len = s.length(); // Length of the input string
    int left = 0, right = 1, max = 0; // Initialize variables to store the starting and ending indices of the longest palindrome found and its length

    // 2D boolean array to track if a substring s[i...j] is a palindrome
    var isPalindrome = new boolean[len][len];

    // Iterate over the string in reverse order
    for (int i = len - 1; i >= 0; i--) {
        // Iterate from the current position to the end of the string
        for (int j = i; j < len; j++) {
            if (i == j) {
                // A single character is always a palindrome
                isPalindrome[i][j] = true;
            } else if (s.charAt(i) == s.charAt(j)) {
                // Check if the characters at positions i and j are the same
                if (j - i == 1) {
                    // If it's two consecutive characters and they're the same, it's a palindrome
                    isPalindrome[i][j] = true;
                } else {
                    // For longer substrings, check if the inner substring s[i+1...j-1] is a palindrome
                    isPalindrome[i][j] = isPalindrome[i + 1][j - 1];
                }
            }

            // If the current substring s[i...j] is a palindrome and longer than the previously found maximum
            if (isPalindrome[i][j] && j - i + 1 > max) {
                max = j - i + 1; // Update the maximum length
                left = i; // Update the start index of the longest palindrome
                right = j + 1; // Update the end index (exclusive) of the longest palindrome
            }
        }
    }

    // Return the longest palindromic substring
    return s.substring(left, right);
}


}