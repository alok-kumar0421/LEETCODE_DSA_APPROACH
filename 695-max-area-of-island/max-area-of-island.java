class Solution {
    public static class Pair{
        int i;
        int j;
        Pair(int i, int j){
            this.i=i;
            this.j=j;
        }
    }
    public static void bfs(int[][] grid, boolean [][] vis, int [] count, int i, int j){
        int m = grid.length;
        int n = grid[0].length;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(i,j));
        vis[i][j]=true;
        count[0]++;
        while(q.size()>0){
            int row = q.peek().i;
            int col = q.peek().j;
            q.poll();
            if(row>0 && grid[row-1][col]==1 && vis[row-1][col]==false){
                q.add(new Pair(row-1,col));
                vis[row-1][col]=true;
                count[0]++;
            }
            if(row+1<m && grid[row+1][col]==1 && vis[row+1][col]==false){
                q.add(new Pair(row+1,col));
                vis[row+1][col]=true;
                count[0]++;
            }if(col+1<n && grid[row][col+1]==1 && vis[row][col+1]==false){
                q.add(new Pair(row,col+1));
                vis[row][col+1]=true;
                count[0]++;
            }if(col>0 && grid[row][col-1]==1 && vis[row][col-1]==false){
                q.add(new Pair(row,col-1));
                vis[row][col-1]=true;
                count[0]++;
            }
        }
    }
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean [][] vis = new boolean[m][n];
        int area = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1 && vis[i][j]==false){
                    int[] count = new int [1];
                    bfs(grid, vis, count, i, j);
                    area = Math.max(area, count[0]);
                }
            }
        }
        return area;
    }
}