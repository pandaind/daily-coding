class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];

        // Calculate the maximum money if we rob from house 0 to n-2
        int maxRobFirstToSecondLast = robLinear(nums, 0, nums.length - 2);

        // Calculate the maximum money if we rob from house 1 to n-1
        int maxRobSecondToLast = robLinear(nums, 1, nums.length - 1);

        // The result is the maximum of the two scenarios
        return Math.max(maxRobFirstToSecondLast, maxRobSecondToLast);
    }

    private int robLinear(int[] nums, int start, int end) {
        if (start == end)
            return nums[start];

        int prevMax = 0;
        int curMax = 0;

        for (int i = start; i <= end; i++){
            int temp = curMax;
            curMax = Math.max(prevMax + nums[i], curMax);
            prevMax = temp;
        }

        return curMax;
    }
}