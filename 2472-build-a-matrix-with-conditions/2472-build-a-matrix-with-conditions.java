class Solution 
{
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) 
    {
        int[] orderRows = topoSort(rowConditions, k);
        int[] orderColumns = topoSort(colConditions, k);
        if(orderRows.length == 0 || orderColumns.length == 0)
        {
            return new int[0][0];
        }
        int[][] matrix = new int[k][k];
        for(int i = 0; i < k; i++)
        {
            for(int j = 0; j < k; j++)
            {
                if(orderRows[i] == orderColumns[j])
                {
                    matrix[i][j] = orderRows[i];
                }
            }
        }
        return matrix;
    }
    private int[] topoSort(int[][] edges, int n)
    {
        List<Integer>[] adj = new ArrayList[n + 1];
        for(int i = 0; i <= n; i++)
        {
            adj[i] = new ArrayList<Integer>();
        }
        int[] deg = new int[n + 1];
        int[] order = new int[n];
        int index = 0;
        for(int[] x : edges)
        {
            adj[x[0]].add(x[1]);
            deg[x[1]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1; i <= n; i++)
        {
            if(deg[i] == 0)
            {
                queue.offer(i);
            }
        }
        while(!queue.isEmpty())
        {
            int f = queue.poll();
            order[index++] = f;
            n -= 1;
            for(int v : adj[f])
            {
                if(--deg[v] == 0)
                {
                    queue.offer(v);
                }
            }
        }
        if(n != 0)
        {
            return new int[0];
        }
        return order;
    }
}