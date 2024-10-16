public class Demo {

    private static int[] base = new int[]{0, 1, 1};

    public static void main(String[] args) {
        int[] test = new int[]{1, 2, 3, 1};
        System.out.println(rob(test));
    }

    public static int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        int n = nums.length;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        dp[2] = Math.max(nums[0], nums[1]);
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }

        return dp[n];
    }

    public static int tribonacci(int n) {
        if (n <= 2) {
            return base[n];
        }

        int[] dp = new int[n + 1];
        dp[0] = base[0];
        dp[1] = base[1];
        dp[2] = base[2];
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }

        return dp[n];
    }

    public static int fib(int n) {
        if (n == 0 || n == 1) {
            return base[n];
        }

        int[] dp = new int[n + 1];
        dp[0] = base[0];
        dp[1] = base[1];
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    public static int climbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        if (n > 1) {
            dp[2] = 2;
        }
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    public static int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length + 1];
        for (int i = 2; i <= cost.length; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }

        return dp[cost.length];
    }
}
