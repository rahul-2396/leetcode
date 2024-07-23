class Solution 
{
    public int[] frequencySort(int[] nums) 
    {
        int length = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums)
        {
            if(map.containsKey(num) == true)
            {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
            else
            {
                map.put(num, 1);
            }
        }
        List<Integer> list = new ArrayList<>();
        for(int num : nums)
        {
            list.add(num);
        }
        Collections.sort(list, (a, b) ->
        {
            int freqCompare = map.get(a).compareTo(map.get(b));
            if(freqCompare != 0)
            {
                return freqCompare;
            }
            else
            {
                return b.compareTo(a);
            }
        });
        for(int i = 0; i < length; i++)
        {
            nums[i] = list.get(i);
        }
        return nums;
    }
}