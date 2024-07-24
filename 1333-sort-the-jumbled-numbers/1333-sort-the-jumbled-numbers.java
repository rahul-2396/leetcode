class Solution 
{
    public int[] sortJumbled(int[] mapping, int[] nums) 
    {
        List<Pair> pairs = new ArrayList<>();
        for(int num : nums)
        {
            pairs.add(new Pair(num, mappedValue(num, mapping)));
        }
        pairs.sort((p1, p2) -> {
            if(p1.mappedValue != p2.mappedValue)
            {
                return Integer.compare(p1.mappedValue, p2.mappedValue);
            }
            else
            {
                return 0;
            }
        });
        int[] result = new int[nums.length];
        for(int i = 0; i < pairs.size(); i++)
        {
            result[i] = pairs.get(i).originalValue;
        }
        return result;
    }
    private int mappedValue(int num, int[] mapping)
    {
        StringBuilder mappedStr = new StringBuilder();
        String newStr = Integer.toString(num);
        for(char c : newStr.toCharArray())
        {
            mappedStr.append(mapping[c - '0']);
        }
        return Integer.parseInt(mappedStr.toString());
    }
    private static class Pair
    {
        int originalValue;
        int mappedValue;
        Pair(int originalValue, int mappedValue)
        {
            this.originalValue = originalValue;
            this.mappedValue = mappedValue;
        }
    }
}

