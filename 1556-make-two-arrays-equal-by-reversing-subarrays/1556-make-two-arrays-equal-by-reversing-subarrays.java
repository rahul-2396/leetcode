class Solution 
{
    public boolean canBeEqual(int[] target, int[] arr) 
    {
        if(target.length != arr.length)
        {
            return false;
        }
        Arrays.sort(target);
        Arrays.sort(arr);
        // for(int i = 0; i < target.length; i++)
        // {
        //     if(target[i] == arr[i])
        //     {
        //         continue;
        //     }
        //     else
        //     {
        //         return false;
        //     }
        // }
        if(Arrays.equals(target, arr))
        {
            return true;
        }
        return false;
    }
}