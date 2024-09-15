class Solution {
    public int characterReplacement(String s, int k) {
        int[] occurrences = new int[26];
        int left = 0;
        int right = 0;
        int maxLength = 0;
        int maxOccurrences = 0;
        while (right < s.length()) {
            maxOccurrences = Math.max(maxOccurrences, ++occurrences[s.charAt(right) - 'A']);
            if (right - left + 1 - maxOccurrences > k) {
                occurrences[s.charAt(left) - 'A']--;
                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }

        return maxLength;
    }
}