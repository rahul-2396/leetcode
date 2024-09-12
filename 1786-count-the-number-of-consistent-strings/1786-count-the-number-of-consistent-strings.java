class Solution 
{
    public int countConsistentStrings(String allowed, String[] words) 
    {
        int n = words.length;
        int count = 0;
        for(int i = 0; i < n; i++)
        {
            boolean isValid = true;
            for(char ch : words[i].toCharArray())
            {
                if(!allowed.contains(Character.toString(ch)))
                {
                    isValid = false;
                    break;
                }
            }
            if(isValid)
            {
                count += 1;
            }
        }
        return count;
    }
}