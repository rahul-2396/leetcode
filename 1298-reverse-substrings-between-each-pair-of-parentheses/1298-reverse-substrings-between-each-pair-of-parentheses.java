class Solution 
{
    public String reverseParentheses(String s) 
    {
        int length = s.length();
        Stack<Integer> openParenthesesIndices = new Stack<>();
        int[] pair = new int[length];
        for(int i = 0; i < length; ++i)
        {
            if(s.charAt(i) == '(')
            {
                openParenthesesIndices.push(i);
            }
            if(s.charAt(i) == ')')
            {
                int j = openParenthesesIndices.pop();
                pair[i] = j;
                pair[j] = i;
            }
        }
        StringBuilder result = new StringBuilder();
        for(int currIndex = 0, direction = 1; currIndex < length; currIndex += direction)
        {
            if(s.charAt(currIndex) == '(' || s.charAt(currIndex) == ')')
            {
                currIndex = pair[currIndex];
                direction = -direction;
            }
            else
            {
                result.append(s.charAt(currIndex));
            }
        }
        return result.toString();
    }
}