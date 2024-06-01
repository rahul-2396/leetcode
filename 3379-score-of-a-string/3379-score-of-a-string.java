class Solution 
{
    public int scoreOfString(String s) 
    {
        int length = s.length();
        int i = 0;
        int j = 1;
        int result = 0;
        while(i < length && j < length)
        {
            int value = Math.abs((int)s.charAt(i) - (int)s.charAt(j));
            result += value;
            i += 1;
            j += 1;
        }
        return result;
    }
}