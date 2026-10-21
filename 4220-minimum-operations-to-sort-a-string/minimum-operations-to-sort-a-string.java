class Solution {
    public int minOperations(String s) {
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        int n = arr.length;
        char[] arr2 = s.toCharArray();
        if(Arrays.equals(arr,arr2)){
            return 0;
        }
        if(n==2)return -1;
        char max = arr[n-1];
        char min = arr[0];
        if(max==arr2[0] && min == arr2[n-1]){
            for(int i=1;i<n-1;i++){
                if(arr2[i]==min || max==arr2[i]){
                    return 2;
                }
            }
            return 3;
        }
        else if(max==arr2[n-1] || min==arr2[0]){
            return 1;
        }
        return 2;
    }
}