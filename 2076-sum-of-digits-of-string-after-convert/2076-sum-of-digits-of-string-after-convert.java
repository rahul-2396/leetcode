class Solution 
{
    public int getLucky(String s, int k) 
    {
        String numericString = "";
        for(char ch : s.toCharArray())
        {
            numericString += Integer.toString(ch - 'a' + 1);
        }
        while(k > 0)
        {
            int sum = 0;
            for(char digit : numericString.toCharArray())
            {
                sum += digit - '0';
            }
            numericString = Integer.toString(sum);
            k -= 1;
        }
        return Integer.parseInt(numericString);
    }
}