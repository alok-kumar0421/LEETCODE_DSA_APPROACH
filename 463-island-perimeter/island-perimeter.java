class Solution {
    public static class Pair{
        int i;
        int j;
        Pair(int i, int j){
            this.i=i;
            this.j=j;
        }
    }
    public static void bfs(int[][] grid, int i, int j, int[] count,boolean[][] vis){
        int m = grid.length;
        int n = grid[0].length;
        vis[i][j]=true;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(i,j));
        while(q.size()>0){
            int row = q.peek().i;
            int col = q.peek().j;
            q.poll();
            if(row>0 && grid[row-1][col]==1 ){
                if(vis[row-1][col]==false){
                    q.add(new Pair(row-1,col));
                    vis[row-1][col]=true;
                }
            }else{
                count[0]++;
            }
            if(row+1<m && grid[row+1][col]==1){
                if(vis[row+1][col]==false){
                    q.add(new Pair(row+1,col));
                    vis[row+1][col]=true;
                }
            }else{
                count[0]++;
            }
            if(col>0 && grid[row][col-1]==1){
                if(vis[row][col-1]==false){
                    q.add(new Pair(row,col-1));
                    vis[row][col-1]=true;
                }
            }else{
                count[0]++;
            }
            if(col+1<n && grid[row][col+1]==1){
                if(vis[row][col+1]==false){
                    q.add(new Pair(row,col+1));
                    vis[row][col+1]=true;
                }
            }else{
                count[0]++;
            }
        }
    }
    public int islandPerimeter(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] count=new int[1];
        boolean[][] vis = new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1 && vis[i][j]==false){
                    bfs(grid,i,j,count, vis);
                }
            }
        }
        return count[0];
    }
}