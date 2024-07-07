class Solution 
{
    public int numWaterBottles(int numBottles, int numExchange) 
    {
        int drank = numBottles;
        int emptyBottles = numBottles;
        while(emptyBottles >= numExchange)
        {
            int newBottles = emptyBottles / numExchange;
            drank += newBottles;
            emptyBottles = newBottles + (emptyBottles % numExchange);
        }
        return drank;
    }
}