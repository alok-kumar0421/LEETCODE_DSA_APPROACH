class Solution {

    public static class Pair{
        int i;
        int j;
        Pair(int i, int j){
            this.i=i;
            this.j=j;
        }
    }

    public static void bfs(char[][] board, boolean [][]vis, int i, int j){
        int m = board.length;
        int n = board[0].length;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(i,j));
        vis[i][j]=true;
        board[i][j]='T';
        while(q.size()>0){
            int row = q.peek().i;
            int col = q.peek().j;
            q.poll();
            if(row>0 && board[row-1][col]=='O' && vis[row-1][col]==false){
                q.add(new Pair(row-1,col));
                vis[row-1][col]=true;
                board[row-1][col]='T';
            }
            if(row+1<m && board[row+1][col]=='O' && vis[row+1][col]==false){
                q.add(new Pair(row+1,col));
                vis[row+1][col]=true;
                board[row+1][col]='T';
            }
            if(col>0 && board[row][col-1]=='O' && vis[row][col-1]==false){
                q.add(new Pair(row,col-1));
                vis[row][col-1]=true;
                board[row][col-1]='T';
            }
            if(col+1<n && board[row][col+1]=='O' && vis[row][col+1]==false){
                q.add(new Pair(row,col+1));
                vis[row][col+1]=true;
                board[row][col+1]='T';
            }
        }
    }
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        boolean[][] vis = new boolean[m][n];
        //upper row
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0){
                    if(board[i][j]=='O' && vis[i][j]==false){
                        bfs(board,vis,i,j);
                    }
                }
                if(i==m-1){
                    if(board[i][j]=='O' && vis[i][j]==false){
                        bfs(board, vis, i, j);
                    }
                }
                if(j==0){
                    if(board[i][j]=='O' && vis[i][j]==false){
                        bfs(board, vis, i, j);
                    }
                }
                if(j==n-1){
                    if(board[i][j]=='O' && vis[i][j]==false){
                        bfs(board, vis, i, j);
                    }
                }
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]=='O'){
                    board[i][j]='X';
                }
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]=='T'){
                    board[i][j]='O';
                }
            }
        }
    }
}