import java.util.*;

class Solution {

    class MedianWindow {
        TreeMap<Integer, Integer> lo = new TreeMap<>();
        TreeMap<Integer, Integer> hi = new TreeMap<>();

        int ls = 0, hs = 0;
        long lsum = 0, hsum = 0;

        void add(int v) {
            if (lo.isEmpty() || v <= lo.lastKey()) {
                put(lo, v);
                ls++;
                lsum += v;
            } else {
                put(hi, v);
                hs++;
                hsum += v;
            }
            balance();
        }

        void remove(int v) {
            if (lo.containsKey(v)) {
                del(lo, v);
                ls--;
                lsum -= v;
            } else {
                del(hi, v);
                hs--;
                hsum -= v;
            }
            balance();
        }

        void put(TreeMap<Integer, Integer> m, int v) {
            m.merge(v, 1, Integer::sum);
        }

        void del(TreeMap<Integer, Integer> m, int v) {
            if (m.get(v) == 1) m.remove(v);
            else m.put(v, m.get(v) - 1);
        }

        void balance() {
            while (ls < hs) {
                int v = hi.firstKey();
                del(hi, v);
                hs--;
                hsum -= v;

                put(lo, v);
                ls++;
                lsum += v;
            }

            while (ls > hs + 1) {
                int v = lo.lastKey();
                del(lo, v);
                ls--;
                lsum -= v;

                put(hi, v);
                hs++;
                hsum += v;
            }
        }

        long cost() {
            long m = lo.lastKey();
            return m * ls - lsum + hsum - m * hs;
        }
    }
    public long minOperations(int[] nums, int x, int k) {
        int n = nums.length;
        int m = n - x + 1;
        long[] cost = new long[m];
        MedianWindow w = new MedianWindow();

        for (int i = 0; i < n; i++) {
            w.add(nums[i]);

            if (i >= x) {
                w.remove(nums[i - x]);
            }
            if (i >= x - 1) {
                cost[i - x + 1] = w.cost();
            }
        }
        long INF = Long.MAX_VALUE / 4;
        long[][] dp = new long[n + 1][k + 1];

        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], INF);
            dp[i][0] = 0;
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 1; j <= k; j++) {
                dp[i][j] = dp[i + 1][j];
                if (i + x <= n && dp[i + x][j - 1] != INF) {
                    dp[i][j] = Math.min(
                        dp[i][j],
                        cost[i] + dp[i + x][j - 1]
                    );
                }
            }
        }

        return dp[0][k];
    }
}