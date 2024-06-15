class Solution 
{
    public static class Project
    {
        int capital;
        int profit;
        Project(int capital, int profit)
        {
            this.capital = capital;
            this.profit = profit;
        }
    }
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) 
    {
        int length = profits.length;
        List<Project> projects = new ArrayList<>();
        for(int i = 0; i < length; i++)
        {
            projects.add(new Project(capital[i], profits[i]));
        }
        Collections.sort(projects, (a, b) -> a.capital - b.capital);
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((x, y) -> y - x);
        int i = 0;
        for(int j = 0; j < k; j++)
        {
            while(i < length && projects.get(i).capital <= w)
            {
                maxHeap.add(projects.get(i).profit);
                i += 1;
            }
            if(maxHeap.isEmpty())
            {
                break;
            }
            w += maxHeap.poll();
        }
        return w;
    }
}