class Solution 
{
    private static final int[] directions = {-1, 0, 1, 0, -1};
    public int orangesRotting(int[][] grid) 
    {
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();

        int freshOranges = 0;
        for(int r = 0; r < rows; r++)
        {
            for(int c = 0; c < cols; c++)
            {
                if(grid[r][c] == 2)
                {
                    queue.offer(new int[] {r, c});
                }
                else if(grid[r][c] == 1)
                {
                    freshOranges += 1;
                }
            }
        }

        int minutes = 0;
        while(!queue.isEmpty() && freshOranges > 0)
        {
            int size = queue.size();
            for(int i = 0; i < size; i++)
            {
                int[] cell = queue.poll();
                int row1 = cell[0];
                int col1 = cell[1];
                for(int j = 0; j < 4; j++)
                {
                    int newRow = row1 + directions[j];
                    int newCol = col1 + directions[j + 1];
                    if(newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols 
&& grid[newRow][newCol] == 1)
                    {
                        grid[newRow][newCol] = 2;
                        queue.offer(new int[] {newRow, newCol});
                        freshOranges -= 1;
                    }
                }
            }
            minutes += 1;
        }
        return freshOranges == 0 ? minutes : -1;
    }
}

