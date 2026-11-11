class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        
        long both = Math.min(need1, need2);
        long max = Math.max(need1, need2);
        long case1 = (long) need1 * cost1 + (long) need2 * cost2;
        long case2 = both *costBoth
                   + (long) (need1 - both) * cost1
                   + (long) (need2 - both) * cost2;
        long case3 = max * costBoth;

        return Math.min(case1, Math.min(case2, case3));
    }
}