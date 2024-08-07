class Solution 
{
    public String kthDistinct(String[] arr, int k) 
    {
        Map<String, Integer> map = new HashMap<>();
        for(String str : arr)
        {
            map.put(str, map.getOrDefault(str, 0) + 1);
        }
        int distinct = 0;
        for(String str : arr)
        {
            if(map.get(str) == 1)
            {
                distinct += 1;
            }
            if(distinct == k)
            {
                return str;
            }
        }
        return "";
    }
}