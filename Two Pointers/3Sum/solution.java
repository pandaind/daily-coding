class Solution {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length && nums[i] <= 0; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                int a = nums[i];
                int j = i + 1;
                int k = nums.length - 1;
                while (j < k) {
                    int sum = a + nums[j] + nums[k];
                    if (sum > 0) {
                        k--;
                    } else if (sum < 0) {
                        j++;
                    } else {
                        res.add(Arrays.asList(a, nums[j], nums[k]));
                        j++;
                        k--;
                    }
                }
            }
        }
        return res.stream().distinct().toList();
    }
}