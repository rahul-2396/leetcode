class Solution 
{
    public void sortColors(int[] nums) 
    {
        int zeroCount = 0;
        int oneCount = 0;
        int twoCount = 0;
        for(int i = 0; i < nums.length; i++)
        {
            if(nums[i] == 0)
            {
                zeroCount++;
            }
            else if(nums[i] == 1)
            {
                oneCount++;
            }
            else
            {
                twoCount++;
            }
        }
        int arrayIterator = 0;
        for(int i = 0; i < zeroCount; i++)
        {
            nums[arrayIterator] = 0;
            arrayIterator++;
        }
        for(int i = 0; i < oneCount; i++)
        {
            nums[arrayIterator] = 1;
            arrayIterator++;
        }
        for(int i = 0; i < twoCount; i++)
        {
            nums[arrayIterator] = 2;
            arrayIterator++;
        }
    }
}