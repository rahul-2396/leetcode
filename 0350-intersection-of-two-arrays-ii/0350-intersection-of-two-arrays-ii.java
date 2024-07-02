class Solution 
{
    public int[] intersect(int[] nums1, int[] nums2) 
    {
        int length1 = nums1.length;
        int length2 = nums2.length;
        if(length1 > length2)
        {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums1)
        {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<Integer> list = new ArrayList<>();
        for(int num : nums2)
        {
            if(map.containsKey(num) == true)
            {
                if(map.get(num) > 0)
                {
                    list.add(num);
                    map.put(num, map.get(num) - 1);
                }
            }
        }
        int[] result = new int[list.size()];
        for(int i = 0; i < list.size(); i++)
        {
            result[i] = list.get(i);
        }
        return result;
    }
}