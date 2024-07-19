class Solution 
{
    public List<Integer> luckyNumbers (int[][] matrix) 
    {
        int n = matrix.length;
        int m = matrix[0].length;
        List<Integer> minInRow = new ArrayList<>();
        for(int i = 0; i < n; i++)
        {
            int rowMin = Integer.MAX_VALUE;
            for(int j = 0; j < m; j++)
            {
                rowMin = Math.min(rowMin, matrix[i][j]);
            }
            minInRow.add(rowMin);
        }
        List<Integer> maxInCol = new ArrayList<>();
        for(int i = 0; i < m; i++)
        {
            int colMax = Integer.MIN_VALUE;
            for(int j = 0; j < n; j++)
            {
                colMax = Math.max(colMax, matrix[j][i]);
            }
            maxInCol.add(colMax);
        }
        List<Integer> luckyNumbers = new ArrayList<>();
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < m; j++)
            {
                if(matrix[i][j] == minInRow.get(i) && matrix[i][j] == maxInCol.get(j))
                {
                    luckyNumbers.add(matrix[i][j]);
                }
            }
        }
        return luckyNumbers;
    }
}