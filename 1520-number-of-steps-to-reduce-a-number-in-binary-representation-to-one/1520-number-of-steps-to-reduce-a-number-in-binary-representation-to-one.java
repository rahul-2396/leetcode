class Solution 
{
    public int numSteps(String s) 
    {
        int length = s.length();
        int operations = 0;
        int carry = 0;
        for(int i = length - 1; i > 0; i--)
        {
            int digit = Character.getNumericValue(s.charAt(i)) + carry;
            if(digit % 2 == 1)
            {
                operations += 2;
                carry = 1;
            }
            else
            {
                operations += 1;
            }
        }
        return operations + carry;
    }
}