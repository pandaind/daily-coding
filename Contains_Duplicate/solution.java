class Solution {

    public boolean containsDuplicate(int[] nums) {
        int arrLength = nums.length;
        int dLength = Arrays.stream(nums).boxed().distinct().toList().size();
        return arrLength!=dLength;
    }


    public boolean containsDuplicate1(int[] nums) {
        Set<Integer> uniques = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!uniques.add(nums[i])) {
                return true;
            }
        }
        return false;
    }
}