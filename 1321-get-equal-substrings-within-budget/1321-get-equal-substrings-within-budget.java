class Solution 
{
    public int equalSubstring(String s, String t, int maxCost) 
    {
        int length = s.length();
        int maxLength = 0;
        int start = 0;
        int currCost = 0;
        for(int i = 0; i < length; i++)
        {
            currCost += Math.abs(s.charAt(i) - t.charAt(i));
            while(currCost > maxCost)
            {
                currCost -= Math.abs(s.charAt(start) - t.charAt(start));
                start += 1;
            }
            maxLength = Math.max(maxLength, i - start + 1);
        }
        return maxLength;
    }
}