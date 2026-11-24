class Solution {
    public int newHcf(int a, int b){
        if(a==0)return b;
        return newHcf(b%a,a);
    }
    public int newLcm(int a, int b){
        return (a*b)/newHcf(a,b);
    }
    public int maxLength(int[] nums) {
        int ans = 0;
        int n = nums.length;
        for(int i=0;i<n;i++){
            int lcm = 1;
            int hcf = 0;
            int prod = 1;
            for(int j=i;j<n;j++){
                prod *=nums[j];
                hcf = newHcf(hcf,nums[j]);
                lcm = newLcm(lcm,nums[j]);
                if(prod == lcm*hcf){
                    ans = Math.max(ans,j-i+1);
                }
            }
        }
        return ans;
    }
}