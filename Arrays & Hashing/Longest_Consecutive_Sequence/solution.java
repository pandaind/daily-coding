class Solution {
    public int longestConsecutive(int[] nums) {
   Arrays.sort(nums);
    nums = Arrays.stream(nums).distinct().toArray();
    List<List<Integer>> results = new ArrayList<>();
    List<Integer> res = new ArrayList<>();
    if(nums.length == 0) return 0;
    for (int i = 0; i < nums.length - 1; i++) {
      if (nums[i]+1 == nums[i+1]) {
        res.add(nums[i]);
      } else {
        res.add(nums[i]);
        results.add(res);
        res = new ArrayList<>();
      }
    }
    res.add(nums[nums.length - 1]);
    results.add(res);

    System.out.println(results);
    return results.stream().sorted((a, b) -> b.size() - a.size()).findFirst().orElse(new ArrayList<>()).size();
    }
}