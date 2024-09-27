public class Demo {
    private static int minCount = Integer.MAX_VALUE;
    private static int[] values = {1, 3, 5};
    private static int[] mem = new int[10];


    public static void main(String[] args) {
        System.out.println(f2(9));
    }


    private static int f2(int val) {
        if (val == 1 || val == 3 || val == 5) { // 剩下的钱如果能一次结清，可以用 set 进行优化
            return 1;
        }
        if (val <= 0) {
            return Integer.MAX_VALUE;
        }

        if (mem[val] > 0) {
            return mem[val];
        }

        int i = 1 + min(f2(val - 1), f2(val - 3), f2(val - 5));
        mem[val] = i;
        return i;
    }

    private static int min(int a, int b, int c) {
        return Math.min(Math.min(a, b), c);
    }
}
