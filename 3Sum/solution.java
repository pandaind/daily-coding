class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // Result list to store the unique triplets
        List<List<Integer>> res = new ArrayList<>();
        
        // Sort the array to apply two-pointer technique
        Arrays.sort(nums);

        // If array is null or has less than 3 elements, no solution exists
        if(nums == null || nums.length < 3) {
            return res;
        }

        // Iterate through the array, treating each element as the potential first element of a triplet
        for(int i = 0; i < nums.length - 2; i++) {

            // Skip duplicate elements to avoid duplicate triplets
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }

            // Two pointers: left starts just after i, right starts from the end
            int left = i + 1;
            int right = nums.length - 1;

            // While left and right don't cross each other
            while(left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                // If the sum is zero, we found a valid triplet
                if(sum == 0){
                    // Add the triplet to the result list
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    
                    // Skip duplicates for left pointer
                    while(left < right && nums[left] == nums[left + 1]){
                        left++;
                    }

                    // Skip duplicates for right pointer
                    while(left < right && nums[right] == nums[right - 1]){
                        right--;
                    }

                    // Move both pointers to look for new pairs
                    left++;
                    right--;
                } 
                // If sum is less than 0, move left pointer to the right to increase the sum
                else if(sum < 0) {
                    left++;
                } 
                // If sum is greater than 0, move right pointer to the left to decrease the sum
                else {
                    right--;
                }
            }
        }

        // Return all unique triplets
        return res;
    }
}
