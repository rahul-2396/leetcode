class Solution 
{
    public int longestPalindrome(String s) 
    {
        Set<Character> set = new HashSet<>();
        int result = 0;
        for(char character : s.toCharArray())
        {
            if(set.contains(character))
            {
                set.remove(character);
                result += 2;
            }
            else
            {
                set.add(character);
            }
        }
        if(!set.isEmpty())
        {
            result += 1;
        }
        return result;
    }
}