class Solution {
    public int openLock(String[] deadends, String target) {
        String start = "0000";
        HashSet<String> set = new HashSet<>();
        for(int i=0;i<deadends.length;i++){
            set.add(deadends[i]);
        }
        if(set.contains(start))return -1;
        Queue<String> q = new LinkedList<>();
        int level = 0;
        q.add(start);
        while(q.size()>0){
            int size = q.size();
            for(int j=0;j<size;j++){
                String str = q.peek();
                q.poll();
                if(str.equals(target))return level;

                for(int i=0;i<4;i++){
                    char [] temp = str.toCharArray();
                    char ch = temp[i];
                    char inc = ch == '9' ? '0' : (char)(ch+1);
                    char dec = ch == '0' ? '9' : (char)(ch-1);
                    temp[i]=inc;
                    String str1 = new String(temp);
                    if(!set.contains(str1)){
                        q.add(str1);
                        set.add(str1);
                    }
                    temp[i]=dec;
                    str1 = new String(temp);
                    if(!set.contains(str1)){
                        q.add(str1);
                        set.add(str1);
                    }
                }
                
            }
            level++;
        }
        return -1;
    }
}