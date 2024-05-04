class Solution 
{
    public int numRescueBoats(int[] people, int limit) 
    {
        int boats = 0;
        int length = people.length;
        Arrays.sort(people);
        int i = 0;
        int j = length - 1;
        while(i <= j)
        {
            if((people[j] + people[i]) <= limit)
            {
                i += 1;
            }
            j -= 1;
            boats += 1;
        }
        return boats;
    }
}