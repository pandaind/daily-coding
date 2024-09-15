class Solution {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> prevMap = new HashMap<>();
        return IntStream.range(0, nums.length)
                .mapToObj(i -> {
                    int diff = target - nums[i];
                    if (prevMap.containsKey(diff)) {
                        return new int[]{i, prevMap.get(diff)};
                    }
                    prevMap.put(nums[i], i);
                    return null;
                }).filter(Objects::nonNull)
                .findFirst().get();
    }

    public int[] twoSum1(int[] nums, int target) {
        Map<Integer, Integer> prevMap = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            int diff = target - nums[i];
            if(prevMap.containsKey(diff)){
                return new int[]{i, prevMap.get(diff)};
            }
            prevMap.put(nums[i], i);
        }

        return new int[]{};
    }
}