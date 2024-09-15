class Solution {
    public String minWindow(String s, String t) {
                if (s == null || s.length() == 0 || t == null || t.length() == 0) {
            return "";
        }

        // Frequency map for characters in t
        HashMap<Character, Integer> targetMap = new HashMap<>();
        for (char c : t.toCharArray()) {
            targetMap.put(c, targetMap.getOrDefault(c, 0) + 1);
        }

        // Sliding window pointers and tracking variables
        int left = 0, right = 0, required = targetMap.size();
        int formed = 0, minLen = Integer.MAX_VALUE, start = 0;

        // Frequency map for characters in the current window
        HashMap<Character, Integer> windowCounts = new HashMap<>();

        while (right < s.length()) {
            // Add the current character to the window
            char c = s.charAt(right);
            windowCounts.put(c, windowCounts.getOrDefault(c, 0) + 1);

            // If the current character's frequency in the window matches the frequency in t
            if (targetMap.containsKey(c) && windowCounts.get(c).intValue() == targetMap.get(c).intValue()) {
                formed++;
            }

            // Try to contract the window if it satisfies the condition
            while (left <= right && formed == required) {
                c = s.charAt(left);

                // Update the smallest window
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }

                // Remove the leftmost character from the window
                windowCounts.put(c, windowCounts.get(c) - 1);
                if (targetMap.containsKey(c) && windowCounts.get(c).intValue() < targetMap.get(c).intValue()) {
                    formed--;
                }

                left++;
            }

            right++;
        }

        // Return the minimum window substring or an empty string if no valid window found
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}