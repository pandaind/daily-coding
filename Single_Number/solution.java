class Solution {
    public int singleNumber(int[] nums) {
        int finder = 0;
        
        for(int i=0; i < nums.length;i++){
            finder^=nums[i];
        }

        return finder;
    }
}