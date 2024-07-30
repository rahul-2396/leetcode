class Solution 
{
    public int minimumDeletions(String s) 
    {
        int length = s.length();
        Stack<Character> stack = new Stack<>();
        int deleteCount = 0;
        for(int i = 0; i < length; i++)
        {
            if(!stack.isEmpty() && stack.peek() == 'b' && s.charAt(i) == 'a')
            {
                stack.pop();
                deleteCount += 1;
            }
            else
            {
                stack.push(s.charAt(i));
            }
        }
        return deleteCount;
    }
}