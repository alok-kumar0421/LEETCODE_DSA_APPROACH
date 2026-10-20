class Solution {
    public static class Pair{
        int i;
        int j;
        Pair(int i, int j){
            this.i=i;
            this.j=j;
        }
    }
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int freshOrange=0;
        boolean [][] vis = new boolean[m][n];
        Queue<Pair> q = new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2){
                    q.add(new Pair(i,j));
                    vis[i][j]=true;
                }
                if(grid[i][j]==1){
                    freshOrange++;
                }
            }
        }
        int minutes=0;
        if(freshOrange==0)return 0;

        while(q.size()>0){
            int size=q.size();
            for(int i=0;i<size;i++){
                int row = q.peek().i;
                int col = q.peek().j;
                q.poll();

                if(row>0 && grid[row-1][col]==1 && vis[row-1][col]==false){
                    q.add(new Pair(row-1, col));
                    vis[row-1][col]=true;
                    freshOrange--;
                }

                if(row+1<m && grid[row+1][col]==1 && vis[row+1][col]==false){
                    q.add(new Pair(row+1, col));
                    vis[row+1][col]=true;
                    freshOrange--;

                }

                if(col>0 && grid[row][col-1]==1 && vis[row][col-1]==false){
                    q.add(new Pair(row, col-1));
                    vis[row][col-1]=true;
                    freshOrange--;

                }
                if(col+1<n && grid[row][col+1]==1 && vis[row][col+1]==false){
                    q.add(new Pair(row, col+1));
                    vis[row][col+1]=true;
                    freshOrange--;

                }
            }
            minutes++;
        }
        if(freshOrange==0){
            return --minutes;
        }
        return -1;
    }
}