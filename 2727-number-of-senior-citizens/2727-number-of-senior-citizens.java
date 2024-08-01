class Solution 
{
    public int countSeniors(String[] details) 
    {
        int count = 0;
        for(String str : details)
        {
            StringBuilder sb = new StringBuilder();
            if(str.length() > 12)
            {
                sb.append(str.charAt(11));
                sb.append(str.charAt(12));
            }
            else
            {
                break;
            }
            int age = Integer.parseInt(sb.toString());
            if(age > 60)
            {
                count += 1;
            }
        }
        return count;
    }
}