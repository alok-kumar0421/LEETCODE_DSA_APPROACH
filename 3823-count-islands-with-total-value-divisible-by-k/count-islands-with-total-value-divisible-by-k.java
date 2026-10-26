class Solution {
    public class Pair{
        int i;
        int j;
        Pair(int i, int j){
            this.i=i;
            this.j=j;
        }
    }
    public void bfs(int[][] grid, int i, int j, long[] count){
        int m = grid.length;
        int n = grid[0].length;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(i,j));
        count[0]+=grid[i][j];
        grid[i][j]=0;
        
        while(q.size()>0){
            int row = q.peek().i;
            int col = q.peek().j;
            q.poll();

            if(row>0 && grid[row-1][col]>0){
                q.add(new Pair(row-1,col));
                count[0]+=grid[row-1][col];
                grid[row-1][col]=0;
            }

            if(row+1<m && grid[row+1][col]>0){
                q.add(new Pair(row+1,col));
                count[0]+=grid[row+1][col];
                grid[row+1][col]=0;
            }

            if(col>0 && grid[row][col-1]>0){
                q.add(new Pair(row,col-1));
                count[0]+=grid[row][col-1];
                grid[row][col-1]=0;
            }

            if(col+1<n && grid[row][col+1]>0){
                q.add(new Pair(row,col+1));
                count[0]+=grid[row][col+1];
                grid[row][col+1]=0;
            }
        }
    }
    public int countIslands(int[][] grid, int k) {
        int count = 0;
        int m = grid.length;
        int n = grid[0].length;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]>0){
                    long [] temp = new long[1];
                    temp[0]=0;
                    bfs(grid,i,j,temp);
                    if(temp[0]%k==0){
                        count++;
                    }
                }
            }
        }
        return count;
    }
}