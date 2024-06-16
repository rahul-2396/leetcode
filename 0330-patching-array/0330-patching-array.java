class Solution 
{
    public int minPatches(int[] nums, int n) 
    {
        long miss = 1;
        int result = 0;
        int i = 0;
        while(miss <= n)
        {
            if(i < nums.length && nums[i] <= miss)
            {
                miss += nums[i];
                i += 1;
            }
            else
            {
                miss += miss;
                result += 1;
            }
        }
        return result;
    }
}