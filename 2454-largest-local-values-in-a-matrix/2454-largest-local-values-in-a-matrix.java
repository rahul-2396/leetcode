class Solution 
{
    public int[][] largestLocal(int[][] grid) 
    {
        int length = grid.length;
        int[][] maxLocal = new int[length - 2][length - 2];
        for(int i = 0; i < length - 2; i++)
        {
            for(int j = 0; j < length - 2; j++)
            {
                maxLocal[i][j] = findMax(grid, i, j);
            }
        }
        return maxLocal;
    }
    private int findMax(int[][] grid, int x, int y)
    {
        int maxElement = 0;
        for(int i = x; i < x + 3; i++)
        {
            for(int j = y; j < y + 3; j++)
            {
                maxElement = Math.max(maxElement, grid[i][j]);
            }
        }
        return maxElement;
    }
}