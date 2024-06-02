class Solution 
{
    public int[] singleNumber(int[] nums) 
    {
        int length = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < length; i++)
        {
            int element = nums[i];
            map.put(element, map.getOrDefault(element, 0) + 1);
        }
        List<Integer> numbers = new ArrayList<>();
        int frequency = 1;
        for(Map.Entry<Integer, Integer> entry : map.entrySet())
        {
            if(entry.getValue() == frequency)
            {
                numbers.add(entry.getKey());
            }
        }
        int[] result = new int[numbers.size()];
        for(int i = 0; i < numbers.size(); i++)
        {
            result[i] = numbers.get(i);
        }
        return result;
    }
}