class Solution {
    public static void bfs(List<List<Integer>> list, boolean [] vis, int s, int d){
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        vis[s]=true;
        while(q.size()>0){
            int curr = q.poll();
            for(int ele : list.get(curr)){
                if(vis[ele]==false){
                    vis[ele]=true;
                    q.add(ele);
                    if(ele==d)return;
                }
            }
        }
    }
    public boolean validPath(int n, int[][] edges, int s, int d) {
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            list.get(edges[i][0]).add(edges[i][1]);
            list.get(edges[i][1]).add(edges[i][0]);
        }
        boolean [] vis = new boolean[n];
        bfs(list, vis, s, d);
        return vis[d]==true;
    }
}