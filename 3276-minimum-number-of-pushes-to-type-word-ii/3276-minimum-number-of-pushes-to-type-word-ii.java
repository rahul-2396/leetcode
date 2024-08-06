class Solution 
{
    public int minimumPushes(String word) 
    {
        int[] frequency = new int[26];
        for(char ch : word.toCharArray())
        {
            frequency[ch - 'a']++;
        }
        Integer[] sortedFrequency = Arrays.stream(frequency).boxed().toArray(Integer[]::new);
        Arrays.sort(sortedFrequency, (a, b) -> b - a);
        int totalPushes = 0;
        for(int i = 0; i < 26; i++)
        {
            if(sortedFrequency[i] == 0)
            {
                break;
            }
            totalPushes += (i / 8 + 1) * sortedFrequency[i];
        }
        return totalPushes;
    }
}