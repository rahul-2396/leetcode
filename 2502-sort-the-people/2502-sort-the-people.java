class Solution 
{
    public String[] sortPeople(String[] names, int[] heights) 
    {
        int length = heights.length;
        Map<Integer, String> map = new HashMap<>();
        for(int i = 0; i < length; i++)
        {
            map.put(heights[i], names[i]);
        }
        Arrays.sort(heights);
        String[] result = new String[length];
        for(int i = length - 1; i >= 0; i--)
        {
            result[length - i - 1] = map.get(heights[i]);
        }
        return result;
    }
}