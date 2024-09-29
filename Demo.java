public class Demo {
    
    public static void main(String[] args) {
        System.out.println(climbStairs(2));
    }

    public static int climbStairs(int n) {
        int[] mem = new int[n + 1];
        mem[1] = 1;
        if (n >= 2) {
            mem[2] = 2;
        }
        return f(n, mem);
    }

    private static int f(int n, int[] mem) {
        if (n <= 0) {
            return 0;
        }

        if (mem[n] > 0) {
            return mem[n];
        }

        int i = f(n - 1, mem) + f(n - 2, mem);
        mem[n] = i;

        return i;
    }

}
