class Solution 
{
    public String[] findRelativeRanks(int[] score) 
    {
        int length = score.length;
        int[] scoreCopy = new int[length];
        System.arraycopy(score, 0, scoreCopy, 0, length);
        Map<Integer, Integer> scoreToIndex = new HashMap<>();
        for(int i = 0; i < length; i++)
        {
            scoreToIndex.put(scoreCopy[i], i);
        }
        Arrays.sort(scoreCopy);
        String[] rank = new String[length];
        for(int i = 0; i < length; i++)
        {
            if(i == 0)
            {
                rank[scoreToIndex.get(scoreCopy[length - i - 1])] = "Gold Medal";
            }
            else if(i == 1)
            {
                rank[scoreToIndex.get(scoreCopy[length - i - 1])] = "Silver Medal";
            }
            else if(i == 2)
            {
                rank[scoreToIndex.get(scoreCopy[length - i - 1])] = "Bronze Medal";
            }
            else
            {
                rank[scoreToIndex.get(scoreCopy[length - i - 1])] = Integer.toString(i + 1);
            }
        }
        return rank;
    }
}