class Solution {
    public int singleNumber(int[] nums) {
        int finder = 0;
        
        for(int i=0; i < nums.length;i++){
            finder^=nums[i];
        }

        return finder;
    }

    public int singleNumber2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int sumOfSet = 0;
        int sumOfNums = 0;

        for (int num : nums) {
            if (!set.contains(num)) {
                set.add(num);
                sumOfSet += num;
            }
            sumOfNums += num;
        }

        return 2 * sumOfSet - sumOfNums;
    }
}