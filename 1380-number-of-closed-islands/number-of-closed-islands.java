class Solution {
    public class Pair{
        int i;
        int j;
        Pair(int i, int j){
            this.i=i;
            this.j=j;
        }
    }
    public boolean bfs(int [][] grid, int i, int j){
        int m = grid.length;
        int n = grid[0].length;
        boolean ans=true;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(i,j));
        grid[i][j]=1;
        while(q.size()>0){
            int row = q.peek().i;
            int col = q.peek().j;
            q.poll();

            if(row>0){
                if(grid[row-1][col]==0){
                    q.add(new Pair(row-1,col));
                    grid[row-1][col]=1;
                }
            }else{
                ans= false;
            }
            if(row+1<m){
                if(grid[row+1][col]==0){
                    q.add(new Pair(row+1,col));
                    grid[row+1][col]=1;
                }
            }else{
                ans= false;
            }
            if(col>0){
                if(grid[row][col-1]==0){
                    q.add(new Pair(row,col-1));
                    grid[row][col-1]=1;
                }
            }else{
                ans= false;
            }
            if(col+1<n){
                if(grid[row][col+1]==0){
                    q.add(new Pair(row,col+1));
                    grid[row][col+1]=1;
                }
            }else{
                ans= false;
            }
        }
        return ans;
    }
    public int closedIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0){
                    if(bfs(grid,i,j)){
                        count++;
                    }
                }
            }
        }
        return count;
    }
}


// class Solution {
//     public boolean dfs(int[][] grid, int i, int j){
//         int m = grid.length;
//         int n = grid[0].length;
        
//         if(i>=m || i<0 || j>=n || j<0)return false;
//         if(grid[i][j]==1)return true;
//         grid[i][j]=1;

//         boolean left = dfs(grid,i,j-1);
//         boolean up = dfs(grid,i-1,j);
//         boolean down = dfs(grid,i+1,j);
//         boolean right = dfs(grid,i,j+1);

//         return left&&up&&down&&right;
//     }
//     public int closedIsland(int[][] grid) {
//         int count=0;
//         int m = grid.length;
//         int n = grid[0].length;
//         for(int i=0;i<m;i++){
//             for(int j=0;j<n;j++){
//                 if(grid[i][j]==0){
//                     if(dfs(grid,i,j)){
//                         count++;
//                     }
//                 }
//             }
//         }
//         return count;
//     }
// }