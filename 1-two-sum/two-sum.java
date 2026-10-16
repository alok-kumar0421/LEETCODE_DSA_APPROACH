// class Solution {
//     public int[] twoSum(int[] arr, int target) {
//         // StringBuilder sb  = new StringBuilder("");
//         ArrayList<Integer> list = new ArrayList<>();
//          for(int i=0;i<arr.length;i++){
//             for(int j=i+1;j<arr.length;j++){
//                 if(arr[i]+arr[j]==target){
//                     list.add(i);
//                     list.add(j);
//                     break;
//                 }
//             }
//          }
//          int ans[] = new int[2];
//          ans[0]=list.get(0);
//          ans[1]=list.get(1);
//          return ans;
//     }
// }

// it is not optimise

class Solution {
    public int[] twoSum(int[] arr, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            int com = target-arr[i];
            if(map.containsKey(com)){
                return new int[]{map.get(com),i};
            }
            map.put(arr[i],i);
        }
        return new int[]{-1,-1};
    }
}