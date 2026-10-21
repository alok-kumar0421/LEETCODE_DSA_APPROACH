class Solution {
    public static class Pair{
        int i;
        int j;
        Pair(int i, int j){
            this.i=i;
            this.j=j;
        }
    }
    public int[][] highestPeak(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] vis = new boolean[m][n];
        Queue<Pair> q = new LinkedList<>();

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    grid[i][j]=0;
                    vis[i][j]=true;
                    q.add(new Pair(i,j));
                }
            }
        }
        int level=1;
        
        while(q.size()>0){
            int size=q.size();
            for(int k=0;k<size;k++){
                int row = q.peek().i;
                int col = q.peek().j;
                q.poll();
                if(row>0 && grid[row-1][col]==0 && vis[row-1][col]==false){
                    vis[row-1][col]=true;
                    q.add(new Pair(row-1, col));
                    grid[row-1][col]=level;
                }
                if(row+1<m && grid[row+1][col]==0 && vis[row+1][col]==false){
                    vis[row+1][col]=true;
                    q.add(new Pair(row+1, col));
                    grid[row+1][col]=level;
                }
                if(col>0 && grid[row][col-1]==0 && vis[row][col-1]==false){
                    vis[row][col-1]=true;
                    q.add(new Pair(row, col-1));
                    grid[row][col-1]=level;
                }
                if(col+1<n && grid[row][col+1]==0 && vis[row][col+1]==false){
                    vis[row][col+1]=true;
                    q.add(new Pair(row, col+1));
                    grid[row][col+1]=level;
                }
            }
            level++;
        }
        return grid;
    }
}