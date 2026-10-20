class Solution {
    public static class Pair{
        int i;
        int j;
        Pair(int i, int j){
            this.i=i;
            this.j=j;
         }
    }
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        boolean vis[][] = new boolean [m][n];
        int level=1;
        Queue<Pair> q = new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==0){
                    q.add(new Pair(i, j));
                    vis[i][j]=true;
                }
            }
        }
        while(q.size()>0){
            int size = q.size();
            for(int i=0;i<size;i++){
                int row = q.peek().i;
                int col = q.peek().j;
                q.poll();
                if(row>0 && mat[row-1][col]==1 && vis[row-1][col]==false){
                    mat[row-1][col]=level;
                    q.add(new Pair(row-1,col));
                    vis[row-1][col]=true;
                }
                if(row+1<m && mat[row+1][col]==1 && vis[row+1][col]==false){
                    mat[row+1][col]=level;
                    q.add(new Pair(row+1,col));
                    vis[row+1][col]=true;
                }
                if(col>0 && mat[row][col-1]==1 && vis[row][col-1]==false){
                    mat[row][col-1]=level;
                    q.add(new Pair(row,col-1));
                    vis[row][col-1]=true;
                }
                if(col+1<n && mat[row][col+1]==1 && vis[row][col+1]==false){
                    mat[row][col+1]=level;
                    q.add(new Pair(row,col+1));
                    vis[row][col+1]=true;
                }
            }
            level++;
        }
        return mat;
    }
}