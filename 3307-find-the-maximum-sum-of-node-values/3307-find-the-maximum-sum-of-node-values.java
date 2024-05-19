class Solution 
{
    public long maximumValueSum(int[] nums, int k, int[][] edges) 
    {
        int length = nums.length;
        long[][] dp = new long[length + 1][2];
        dp[length][1] = 0;
        dp[length][0] = Integer.MIN_VALUE;
        for(int index = length - 1; index >= 0; index--)
        {
            for(int isEven = 0; isEven <= 1; isEven++)
            {
                long performOperation = dp[index + 1][isEven ^ 1] + (nums[index] ^ k);
                long dontPerformOperation = dp[index + 1][isEven] + nums[index];
                dp[index][isEven] = Math.max(performOperation, dontPerformOperation);
            }
        }
        return dp[0][1];
    }
}