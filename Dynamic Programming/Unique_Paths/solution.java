class Solution {
    public int uniquePaths(int m, int n) {
        int[][] paths = new int[m+1][n+1];
        paths[m-1][n] = 1;
        for(int r = m-1; r>=0; r--) {
            for(int c = n-1; c>=0; c--) {
                paths[r][c] = paths[r+1][c] + paths[r][c+1];
            }
        }
        return paths[0][0];
    }
}