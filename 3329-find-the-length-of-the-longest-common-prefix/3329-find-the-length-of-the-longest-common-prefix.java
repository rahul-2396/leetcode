class Solution 
{
    public int longestCommonPrefix(int[] arr1, int[] arr2) 
    {
        Set<Integer> set = new HashSet<Integer>();
        for(int val : arr1)
        {
            while(!set.contains(val) && val > 0)
            {
                set.add(val);
                val /= 10;
            }
        }
        int longestPrefix = 0;
        for(int val : arr2)
        {
            while(!set.contains(val) && val > 0)
            {
                val /= 10;
            }
            if (val > 0)
            {
                longestPrefix = Math.max(longestPrefix, (int) Math.log10(val) + 1);
            }
        }
        return longestPrefix;
    }
}