class Solution 
{
    public String countOfAtoms(String formula) 
    {
        int[] multiplier = new int[formula.length()];
        int runningMul = 1;
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        int index = formula.length() - 1;
        StringBuilder currNumber = new StringBuilder();
        while(index >= 0)
        {
            if(Character.isDigit(formula.charAt(index)))
            {
                currNumber.insert(0, formula.charAt(index));
            }
            else if(Character.isAlphabetic(formula.charAt(index)))
            {
                currNumber = new StringBuilder();
            }
            else if(formula.charAt(index) == ')')
            {
                int currMultiplier = currNumber.length() > 0 ? Integer.parseInt(currNumber.toString()) : 1;
                runningMul *= currMultiplier;
                stack.push(currMultiplier);
                currNumber = new StringBuilder();
            }
            else if(formula.charAt(index) == '(')
            {
                runningMul /= stack.pop();
                currNumber = new StringBuilder();
            }
            multiplier[index] = runningMul;
            index -= 1;
        }
        Map<String, Integer> finalMap = new HashMap<>();
        index = 0;
        while(index < formula.length())
        {
            if(Character.isUpperCase(formula.charAt(index)))
            {
                StringBuilder currAtom = new StringBuilder();
                currAtom.append(formula.charAt(index));
                StringBuilder currCount = new StringBuilder();
                index += 1;
                while(index < formula.length() && Character.isLowerCase(formula.charAt(index)))
                {
                    currAtom.append(formula.charAt(index));
                    index += 1;
                }
                while(index < formula.length() && Character.isDigit(formula.charAt(index)))
                {
                    currCount.append(formula.charAt(index));
                    index += 1;
                }
                int count = currCount.length() > 0 ? Integer.parseInt(currCount.toString()) : 1;
                finalMap.put(currAtom.toString(), finalMap.getOrDefault(currAtom.toString(), 0) + count * multiplier[index - 1]);
            }
            else
            {
                index += 1;
            }
        }
        TreeMap<String, Integer> sortedMap = new TreeMap<>(finalMap);
        StringBuilder answer = new StringBuilder();
        for(String atom : sortedMap.keySet())
        {
            answer.append(atom);
            if(sortedMap.get(atom) > 1)
            {
                answer.append(sortedMap.get(atom));
            }
        }
        return answer.toString();
    }
}