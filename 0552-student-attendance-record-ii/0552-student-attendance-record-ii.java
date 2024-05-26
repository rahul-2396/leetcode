class Solution 
{
    public int checkRecord(int n) 
    {
        int mod = 1000000007;
        int[][][] dp = new int[n + 1][2][3];
        dp[0][0][0] = 1;
        for(int length = 0; length < n; ++length)
        {
            for(int totalAbsences = 0; totalAbsences <= 1; ++totalAbsences)
            {
                for(int consecutiveLates = 0; consecutiveLates <= 2; ++consecutiveLates)
                {
                    dp[length + 1][totalAbsences][0] = (dp[length + 1][totalAbsences][0] + dp[length][totalAbsences][consecutiveLates]) % mod;
                    if(totalAbsences < 1)
                    {
                        dp[length + 1][totalAbsences + 1][0] = (dp[length + 1][totalAbsences + 1][0] + dp[length][totalAbsences][consecutiveLates]) % mod;
                    }
                    if(consecutiveLates < 2)
                    {
                        dp[length + 1][totalAbsences][consecutiveLates + 1] = (dp[length + 1][totalAbsences][consecutiveLates + 1] + dp[length][totalAbsences][consecutiveLates]) % mod;
                    }
                }
            }
        }
        int count = 0;
        for(int totalAbsences = 0; totalAbsences <= 1; ++totalAbsences)
        {
            for(int consecutiveLates = 0; consecutiveLates <= 2; ++consecutiveLates)
            {
                count = (count + dp[n][totalAbsences][consecutiveLates]) % mod;
            }
        }
        return count;
    }
}