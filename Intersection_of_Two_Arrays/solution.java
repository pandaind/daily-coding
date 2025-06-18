class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> uniqueNumbers = new HashSet<Integer>();

        for(int i=0; i<nums1.length; i++) {
            uniqueNumbers.add(nums1[i]);
        }
        
        List<Integer> res = new ArrayList<>();
        
        for(int i=0; i<nums2.length; i++) {
            if(uniqueNumbers.contains(nums2[i])) {
                uniqueNumbers.remove(nums2[i]);
                res.add(nums2[i]);
            }
        }

        return res.stream().mapToInt(i->i).toArray();
    }
}