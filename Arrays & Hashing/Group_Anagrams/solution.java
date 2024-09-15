class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0)
            return new ArrayList<>();

        Map<String, List<String>> ansMap = new HashMap<>();

        for (String str : strs) {
            int[] count = new int[26];
            for (char c : str.toCharArray()) {
                count[c - 'a']++;
            }
            String key = Arrays.toString(count);
            ansMap.putIfAbsent(key, new ArrayList<>());
            ansMap.get(key).add(str);
        }

        return new ArrayList<>(ansMap.values());
    }
}