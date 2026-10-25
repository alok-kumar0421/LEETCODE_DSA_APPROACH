class Solution {
    public boolean dfs(int[][] grid, int i, int j){
        int m = grid.length;
        int n = grid[0].length;
        
        if(i>=m || i<0 || j>=n || j<0)return false;
        if(grid[i][j]==1)return true;
        grid[i][j]=1;

        boolean left = dfs(grid,i,j-1);
        boolean up = dfs(grid,i-1,j);
        boolean down = dfs(grid,i+1,j);
        boolean right = dfs(grid,i,j+1);

        return left&&up&&down&&right;
    }
    public int closedIsland(int[][] grid) {
        int count=0;
        int m = grid.length;
        int n = grid[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0){
                    if(dfs(grid,i,j)){
                        count++;
                    }
                }
            }
        }
        return count;
    }
}