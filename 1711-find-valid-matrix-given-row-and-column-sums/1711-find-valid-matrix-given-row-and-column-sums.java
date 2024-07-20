class Solution 
{
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) 
    {
        int n = rowSum.length;
        int m = colSum.length;
        int[] currRowSum = new int[n];
        int[] currColSum = new int[m];
        int[][] originalMatrix = new int[n][m];
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < m; j++)
            {
                originalMatrix[i][j] = Math.min(rowSum[i] - currRowSum[i], colSum[j] - currColSum[j]);
                currRowSum[i] += originalMatrix[i][j];
                currColSum[j] += originalMatrix[i][j];
            }
        }
        return originalMatrix;
    }
}