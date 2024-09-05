class Solution {
    public int rob(int[] nums) {
       int prevMax = 0;
       int currMax = 0;

       for(int i: nums){
        int temp = currMax;
        currMax = Math.max(prevMax + i, currMax);
        prevMax = temp;
       } 

       return currMax;
    }
}