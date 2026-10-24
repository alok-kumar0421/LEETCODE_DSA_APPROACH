class Solution {
    static boolean ans;
    public void bfs(int[][] graph, int vis[], int i){
        vis[i]=0;
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        while(q.size()>0){
            int front = q.poll();
            int color = vis[front];
            for(int x : graph[front]){
                if(vis[x]==color){
                    ans=false;
                    return;
                }
                if(vis[x]==-1){
                    vis[x]=1-color;
                    q.add(x);
                }
            }
        }
    }
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int vis[] = new int[n];//0-> blue, 1-> red
        ans=true;
        Arrays.fill(vis,-1);
        for(int i=0;i<n;i++){
            if(vis[i]==-1){
                bfs(graph, vis, i);
            }
        }
        return ans;
    }
}