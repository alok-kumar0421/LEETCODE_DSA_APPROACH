class Solution {
    public static class Pair{
        int i;
        int j;
        Pair(int i, int j){
            this.i=i;
            this.j=j;
        }
    }
    public int nearestExit(char[][] maze, int[] entry) {
        int level = 0;
        int m = maze.length;
        int n = maze[0].length;
        boolean[][] vis = new boolean[m][n];
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(entry[0],entry[1]));
        vis[entry[0]][entry[1]]=true;
        while(q.size()>0){
            int size = q.size();
            for(int i=0;i<size;i++){
                int row = q.peek().i;
                int col = q.peek().j;
                q.poll();
                if(level!=0 && (row==0 || row==m-1 || col==0 || col==n-1))return level;

                if(row>0 && maze[row-1][col]=='.' && vis[row-1][col]==false){
                    q.add(new Pair(row-1, col));
                    vis[row-1][col]=true;
                }
                if(row+1<m && maze[row+1][col]=='.' && vis[row+1][col]==false){
                    q.add(new Pair(row+1, col));
                    vis[row+1][col]=true;
                }
                if(col>0 && maze[row][col-1]=='.' && vis[row][col-1]==false){
                    q.add(new Pair(row, col-1));
                    vis[row][col-1]=true;
                }
                if(col+1<n && maze[row][col+1]=='.' && vis[row][col+1]==false){
                    q.add(new Pair(row, col+1));
                    vis[row][col+1]=true;
                }
            }
            level++;
        }
        return -1;
    }
}