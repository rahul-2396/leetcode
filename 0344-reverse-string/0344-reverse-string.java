class Solution 
{
    public void reverseString(char[] s) 
    {
        int length = s.length;
        int i = 0;
        int j = length - 1;
        while(i < j)
        {
            char temp;
            temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i += 1;
            j -= 1;
        }
    }
}