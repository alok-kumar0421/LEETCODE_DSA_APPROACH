class Solution {
    public static class Pair{
        int i;
        int j;
        Pair(int i, int j){
            this.i=i;
            this.j=j;
        }
    }
    public static void bfs(char[][] grid, boolean [][] vis, int i, int j){
        Queue<Pair> q = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;
        q.add(new Pair(i, j));
        vis[i][j]=true;
        while(q.size()>0){
            int row = q.peek().i;
            int col = q.peek().j;
            q.poll();
            // top
            if(row>0 && grid[row-1][col]=='1' && vis[row-1][col]==false){
                q.add(new Pair(row-1,col));
                vis[row-1][col]=true;
            }
            //right
            if(col+1<n && grid[row][col+1]=='1' && vis[row][col+1]==false){
                q.add(new Pair(row, col+1));
                vis[row][col+1]=true;
            }
            //bottom
            if(row+1<m && grid[row+1][col]=='1' && vis[row+1][col]==false){
                q.add(new Pair(row+1, col));
                vis[row+1][col]=true;
            }
            if(col>0 && grid[row][col-1]=='1' && vis[row][col-1]==false){
                q.add(new Pair(row, col-1));
                vis[row][col-1]=true;
            }
        }
    }
    public int numIslands(char[][] grid) {
        int count=0;
        int m = grid.length;
        int n = grid[0].length;
        boolean [][] vis = new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1' && vis[i][j]==false){
                    bfs(grid, vis, i, j);
                    count++;
                }
            }
        }
        return count++;
    }
}