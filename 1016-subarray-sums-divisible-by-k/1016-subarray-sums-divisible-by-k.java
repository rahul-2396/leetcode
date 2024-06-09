// class Solution 
// {
//     public int subarraysDivByK(int[] nums, int k) 
//     {
//         int length = nums.length;
//         int count = 0;
//         for(int i = 0; i < length; i++)
//         {
//             int sum = 0;
//             for(int j = i; j < length; j++)
//             {
//                 sum += nums[j];
//                 if(sum % k == 0)
//                 {
//                     count += 1;
//                 }
//             }
//         }
//         return count;
//     }
// }

import java.util.HashMap;

class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        // HashMap to store the frequency of prefix sums modulo k
        HashMap<Integer, Integer> prefixSumCount = new HashMap<>();
        prefixSumCount.put(0, 1);
        
        int sum = 0;
        int count = 0;
        
        for (int num : nums) {
            sum += num;
            int mod = ((sum % k) + k) % k; // Handle negative mods
            
            // If mod value has been seen before, add the count of those occurrences
            if (prefixSumCount.containsKey(mod)) {
                count += prefixSumCount.get(mod);
            }
            
            // Update the count of the current mod value in the hashmap
            prefixSumCount.put(mod, prefixSumCount.getOrDefault(mod, 0) + 1);
        }
        
        return count;
    }
}
