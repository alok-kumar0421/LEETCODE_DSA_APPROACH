class Solution {
    public boolean checkString(String s) {
        int start = -1;
        int n = s.length();
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='b'){
                start=i;
                break;
            }
        }
        if(start==-1)return true;
        for(int i=start; i<n;i++){
            if(s.charAt(i)=='a'){
                return false;
            }
        }
        return true;
    }
}