class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> occurances = new HashMap<>();

        for(int i=0; i<nums1.length; i++) {
            if (occurances.containsKey(nums1[i])) {
                occurances.put(nums1[i], occurances.get(nums1[i])+1);
            } else {
                occurances.put(nums1[i], 1);
            }
        }
        
        List<Integer> res = new ArrayList<>();
        
        for(int i=0; i<nums2.length; i++) {
            if(occurances.containsKey(nums2[i]) && occurances.get(nums2[i]) > 0) {
                res.add(nums2[i]);
                occurances.put(nums2[i], occurances.get(nums2[i])-1);
            }
        }

        return res.stream().mapToInt(i->i).toArray();        
    }
}