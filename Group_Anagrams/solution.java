class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0)
            return new ArrayList<>();

        Map<String, List<String>> ansMap = new HashMap<>();

        for (String str : strs) {
            char[] strArray = str.toCharArray();
            Arrays.sort(strArray);
            String key = new String(strArray);
            ansMap.putIfAbsent(key, new ArrayList<>());
            ansMap.get(key).add(str);
        }

        return new ArrayList<>(ansMap.values());
    }
}