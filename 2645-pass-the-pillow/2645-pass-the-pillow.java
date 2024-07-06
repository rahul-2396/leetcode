class Solution 
{
    public int passThePillow(int n, int time) 
    {
        int currentPosition = 1;
        int direction = 1;
        int currentTime = 0;
        while(currentTime < time)
        {
            if(0 < currentPosition + direction && currentPosition + direction <= n)
            {
                currentPosition += direction;
                currentTime += 1;
            }
            else
            {
                direction *= -1;
            }
        }
        return currentPosition;
    }
}