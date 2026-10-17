class Solution {
    public static void bfs(List<List<Integer>> rooms, boolean[] vis, int s){
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        vis[s]=true;
        while(q.size()>0){
            int curr = q.poll();
            for(int ele : rooms.get(curr)){
                if(vis[ele]==false){
                    vis[ele]=true;
                    q.add(ele);
                }
            }
        }
    }
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean [] vis = new boolean [n];
        bfs(rooms, vis, 0);
        for(int i=0;i<n;i++){
            if(vis[i]==false){
                return false;
            }
        }
        return true;
    }
}