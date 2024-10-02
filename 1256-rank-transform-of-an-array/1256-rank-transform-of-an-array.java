class Solution 
{
    public int[] arrayRankTransform(int[] arr) 
    {
        if(arr.length == 0)
        {
            return new int[0];
        }
        int[] newArr = new int[arr.length];
        System.arraycopy(arr, 0, newArr, 0, arr.length);
        Arrays.sort(newArr);
        Map<Integer, Integer> map = new HashMap<>();
        int rank = 1;
        for(int num : newArr)
        {
            if(!map.containsKey(num))
            {
                map.put(num, rank);
                rank += 1;
            }
        }
        int[] result = new int[arr.length];
        for(int i = 0; i < arr.length; i++)
        {
            result[i] = map.get(arr[i]);
        }
        return result;
    }
}