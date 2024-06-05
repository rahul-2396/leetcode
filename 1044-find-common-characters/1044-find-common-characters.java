class Solution 
{
    public List<String> commonChars(String[] words) 
    {
        List<String> result = new ArrayList<>();
        int[] commonCount = new int[26];
        int[] currentCount = new int[26];
        int length = words.length;
        for(char c : words[0].toCharArray())
        {
            commonCount[c - 'a']++;
        }
        for(int i = 1; i < length; i++)
        {
            Arrays.fill(currentCount, 0);
            for(char c : words[i].toCharArray())
            {
                currentCount[c - 'a']++;
            }
            for(int letter = 0; letter < 26; letter++)
            {
               commonCount[letter] = Math.min(commonCount[letter], currentCount[letter]);
            }
        }
        for(int letter = 0; letter < 26; letter++)
        {
            for(int common = 0; common < commonCount[letter]; common++)
            {
                result.add(String.valueOf((char)(letter + 'a')));
            }
        }
        return result;
    }
}