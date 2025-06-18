class Solution {
    public int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        double sumOfSet = 0; // double to handle int overflow
        double sumOfNums = 0; // double to handle int overflow

        for (int num : nums) {
            if (!set.contains(num)) {
                set.add(num);
                sumOfSet += num;
            }
            sumOfNums += num;
        }

        return (int) ((3 * sumOfSet - sumOfNums)/2);
    }
}