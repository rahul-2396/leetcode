class Solution 
{
    public int beautifulSubsets(int[] nums, int k) 
    {
        int totalCount = 1;
        Map<Integer, Map<Integer, Integer>> freqMap = new TreeMap<>();
        for(int num : nums)
        {
            int remainder = num % k;
            Map<Integer, Integer> map = freqMap.getOrDefault(remainder, new TreeMap<>());
            map.put(num, map.getOrDefault(num, 0) + 1);
            freqMap.put(remainder, map);
        }
        for(Map.Entry<Integer, Map<Integer, Integer>> entry : freqMap.entrySet())
        {
            List<Pair<Integer, Integer>> subsets = new ArrayList<>();
            for(Map.Entry<Integer, Integer> subset : entry.getValue().entrySet())
            {
                subsets.add(new Pair<>(subset.getKey(), subset.getValue()));
            }
            int[] counts = new int[subsets.size()];
            Arrays.fill(counts, -1);
            totalCount *= countBeautifulSubsets(subsets, subsets.size(), k, 0, counts);
        }
        return totalCount - 1;
    }
    private int countBeautifulSubsets(List<Pair<Integer, Integer>> subsets, int numSubsets, int difference, int i, int[] counts)
    {
        if(i == numSubsets)
        {
            return 1;
        }
        if(counts[i] != -1)
        {
            return counts[i];
        }
        int skip = countBeautifulSubsets(subsets, numSubsets, difference, i + 1, counts);
        int take = (1 << subsets.get(i).getValue()) - 1;
        if(i + 1 < numSubsets && subsets.get(i + 1).getKey() - subsets.get(i).getKey() == difference)
        {
            take *= countBeautifulSubsets(subsets, numSubsets, difference, i + 2, counts);
        }
        else
        {
            take *= countBeautifulSubsets(subsets, numSubsets, difference, i + 1, counts);
        }
        return counts[i] = skip + take;
    }
}