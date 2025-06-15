class Solution {
    public int maxSubArray(int[] nums) {
                // Initialize the current and global maximum
        int maxCurrent = nums[0];
        int maxGlobal = nums[0];
        
        // Loop through the array starting from the second element
        for (int i = 1; i < nums.length; i++) {
            // Update maxCurrent by deciding whether to include the current element in the subarray or start fresh from current element
            maxCurrent = Math.max(nums[i], maxCurrent + nums[i]);
            
            // Update maxGlobal to the maximum value found so far
            if (maxCurrent > maxGlobal) {
                maxGlobal = maxCurrent;
            }
        }
        
        return maxGlobal;
    }

    public int printMaxSubArray(int[] nums) {
        int maxCurrent = nums[0];
        int maxGlobal = nums[0];
        
        // Initialize variables to keep track of the start and end of the subarray
        int start = 0, end = 0, tempStart = 0;
        
        // Loop through the array starting from the second element
        for (int i = 1; i < nums.length; i++) {
            // If current element is greater than current maxCurrent + nums[i], reset start index
            if (nums[i] > maxCurrent + nums[i]) {
                maxCurrent = nums[i];
                tempStart = i;
            } else {
                maxCurrent = maxCurrent + nums[i];
            }
            
            // Update maxGlobal and the indices of the maximum subarray
            if (maxCurrent > maxGlobal) {
                maxGlobal = maxCurrent;
                start = tempStart;
                end = i;
            }
        }
        
        // Print the subarray
        System.out.print("Maximum subarray is: ");
        for (int i = start; i <= end; i++) {
            System.out.print(nums[i]);
        }
        
        return maxGlobal;
    }
}