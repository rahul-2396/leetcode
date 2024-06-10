class Solution 
{
    public int heightChecker(int[] heights) 
    {
        int length = heights.length;
        int[] expected = new int[length];
        int count = 0;
        for(int i = 0; i < length; i++)
        {
            expected[i] = heights[i];
        }
        Arrays.sort(expected);
        for(int i = 0; i < length; i++)
        {
            if(expected[i] != heights[i])
            {
                count += 1;
            }
        }
        return count;
    }
}