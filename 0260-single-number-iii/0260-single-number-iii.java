class Solution 
{
    public int[] singleNumber(int[] nums) 
    {
        List<Integer> numbers = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        int length = nums.length;
        for(int i = 0; i < length; i++)
        {
            int element = nums[i];
            map.put(element, map.getOrDefault(element, 0) + 1);
        }
        int frequency = 1;
        for(Map.Entry<Integer, Integer> entry : map.entrySet())
        {
            if(entry.getValue() == 1)
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