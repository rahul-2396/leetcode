class Solution 
{
    public boolean isNStraightHand(int[] hand, int groupSize) 
    {
        int length = hand.length;
        if(length % groupSize != 0)
        {
            return false;
        }
        Map<Integer, Integer> map = new TreeMap<>();
        for(int i = 0; i < length; i++)
        {
            map.put(hand[i], map.getOrDefault(hand[i], 0) + 1);
        }
        while(map.size() > 0)
        {
            int currentCard = map.entrySet().iterator().next().getKey();
            for(int i = 0; i < groupSize; i++)
            {
                if(!map.containsKey(currentCard + i))
                {
                    return false;
                }
                map.put(currentCard + i, map.get(currentCard + i) - 1);
                if(map.get(currentCard + i) == 0)
                {
                    map.remove(currentCard + i);
                }
            }
        }
        return true;
    }
}