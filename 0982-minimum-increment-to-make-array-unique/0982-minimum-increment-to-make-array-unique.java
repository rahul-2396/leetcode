class Solution 
{
    public int minIncrementForUnique(int[] nums) 
    {
        int minIncrement = 0;
        Arrays.sort(nums);
        for(int i = 1; i < nums.length; i++)
        {
            if(nums[i] <= nums[i - 1])
            {
                int increment = nums[i - 1] + 1 - nums[i];
                minIncrement += increment;
                nums[i] = nums[i - 1] + 1;
            }
        }
        return minIncrement;
    }
}