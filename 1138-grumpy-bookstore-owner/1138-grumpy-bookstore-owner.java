class Solution 
{
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) 
    {
        int originalCustomers = 0;
        int satisfiedCustomers = 0;
        int length = customers.length;
        for(int i = 0; i < length; i++)
        {
            if(grumpy[i] == 0)
            {
                originalCustomers += customers[i];
            }
        }
        for(int i = 0; i < minutes; i++)
        {
            satisfiedCustomers += customers[i] * grumpy[i];
        }
        int maxSatisfiedCustomers = satisfiedCustomers;
        int start = 0;
        int end = minutes;
        while(end < length)
        {
            satisfiedCustomers += customers[end] * grumpy[end] - customers[start] * grumpy[start];
            maxSatisfiedCustomers = Math.max(maxSatisfiedCustomers, satisfiedCustomers);
            start += 1;
            end += 1;
        }
        return maxSatisfiedCustomers + originalCustomers;
    }
}
