class Solution {
    public int findLongestChain(int[][] pairs) {
            // Sort by the end of the interval
            Arrays.sort(pairs, Comparator.comparingInt(a -> a[1]));
            int currentEnd = Integer.MIN_VALUE; // The end of the last interval
            int count = 0;// The number of intervals in the longest chain
            for (int[] pair : pairs) { // Iterate through the intervals
            if (pair[0] > currentEnd) { // If the start of the current interval is greater than the end of the last interval
                currentEnd = pair[1]; // Update the end of the last interval
                count++; // Increment the number of intervals in the longest chain
            }
            }
            return count;
    }
}