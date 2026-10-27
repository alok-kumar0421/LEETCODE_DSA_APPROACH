class Solution {
    public String[] createGrid(int m, int n) {
        char[][] ans = new char[m][n];
        for(int i=0;i<n;i++){
            ans[0][i]='.';
        }

        for(int i=0;i<m;i++){
            ans[i][n-1]='.';
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(ans[i][j]!='.'){
                    ans[i][j]='#';
                }
            }
        }
        String[] result = new String[m];
        for(int i = 0;i<m;i++){
            result[i] = new String(ans[i]);
        }
        return result;
    }
}