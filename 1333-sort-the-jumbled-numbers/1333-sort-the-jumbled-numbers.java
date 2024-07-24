import java.util.*;

class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        // Step 1: Create a list of pairs where each pair consists of the original number and its mapped value
        List<Pair> pairs = new ArrayList<>();
        for (int num : nums) {
            pairs.add(new Pair(num, getMappedValue(num, mapping)));
        }
        
        // Step 2: Sort the list of pairs based on the mapped values using a custom comparator
        pairs.sort((p1, p2) -> {
            if (p1.mappedValue != p2.mappedValue) {
                return Integer.compare(p1.mappedValue, p2.mappedValue);
            } else {
                // If mapped values are the same, maintain original relative order
                return 0;
            }
        });
        
        // Step 3: Extract the original numbers from the sorted pairs
        int[] result = new int[nums.length];
        for (int i = 0; i < pairs.size(); i++) {
            result[i] = pairs.get(i).originalValue;
        }
        
        return result;
    }
    
    // Helper method to get the mapped value of a number based on the given mapping
    private int getMappedValue(int num, int[] mapping) {
        StringBuilder mappedStr = new StringBuilder();
        String numStr = Integer.toString(num);
        for (char c : numStr.toCharArray()) {
            mappedStr.append(mapping[c - '0']);
        }
        return Integer.parseInt(mappedStr.toString());
    }
    
    // Helper class to hold the original number and its mapped value
    private static class Pair {
        int originalValue;
        int mappedValue;
        
        Pair(int originalValue, int mappedValue) {
            this.originalValue = originalValue;
            this.mappedValue = mappedValue;
        }
    }
}
