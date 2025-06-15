class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> uniques = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!uniques.add(nums[i])) {
                return true;
            }
        }
        return false;
    }
}