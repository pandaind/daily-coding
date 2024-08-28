class Solution {
public int[] topKFrequent(int[] nums, int k) {
        // Step 1: Count the frequency of each element using a HashMap
        Map<Integer, Long> frequencyMap = Arrays.stream(nums)
            .boxed()
            .collect(Collectors.groupingBy(num -> num, Collectors.counting()));

        // Step 2: Sort the elements by frequency in descending order and get the top k elements
        List<Integer> topKElements = frequencyMap.entrySet()
            .stream()
            .sorted((entry1, entry2) -> Long.compare(entry2.getValue(), entry1.getValue()))
            .limit(k)
            .map(Map.Entry::getKey)
            .collect(Collectors.toList());

        // Step 3: Convert the result list to an array
        return topKElements.stream().mapToInt(Integer::intValue).toArray();
    }
}