class Solution {
    public int longestConsecutiveSorted(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] res = Arrays.stream(nums).boxed().sorted().distinct()
                    .mapToInt(Integer::intValue).toArray();
        int ls = 1;
        int cs = 1;
        for (int i = 0; i < res.length - 1; i++) {
            cs = (res[i + 1] - res[i] == 1) ? cs + 1 : 1;
            ls = Math.max(ls, cs);
        }

        return ls;
    }

    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        var resSet = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        int ls = 1;
        for (Integer num : resSet) {
            if (!resSet.contains(num - 1)) {
                int cs = 1;
                while (resSet.contains(num + 1)) {
                    cs++;
                    num++;
                }
                ls = Math.max(ls, cs);
            }
        }
        return ls;
    }
}