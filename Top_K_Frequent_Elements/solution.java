class Solution {

    public int[] topKFrequent(int[] nums, int k) {
        if (nums.length == k)
            return nums;

        Map<Integer, Long> countMap = Arrays.stream(nums).boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        Queue<Map.Entry<Integer, Long>> heap 
                = new PriorityQueue<>((a, b) -> b.getValue().intValue() - a.getValue().intValue());
        heap.addAll(countMap.entrySet());

        return Stream.generate(heap::poll).limit(k)
                .mapToInt(Map.Entry::getKey).toArray();
    }





    public int[] topKFrequentB(int[] nums, int k) {
        if (nums.length == k)
            return nums;

        Map<Integer, Long> countMap = Arrays.stream(nums).boxed()
        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        Queue<Integer> heap = new PriorityQueue<>(Comparator.comparing(countMap::get));

        countMap.keySet().forEach(key -> {
            heap.add(key);
            if (heap.size() > k)
                heap.poll();
        });

        return heap.stream().mapToInt(Integer::intValue).toArray();
    }
}