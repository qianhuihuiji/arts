
public class Demo {
    private static int maxV = Integer.MIN_VALUE; // 结果放到maxV中
    private static int[] weights = {2,2,4,6,2}; // 物品重量
    private static int[] values = {3,4,8,9,6}; // 物品的价值
    private static int n = 5; // 物品个数
    private static int w = 9; // 背包承受的最大重量
    private static int[] states = new int[w +1]; // 记录状态

    public static void main(String[] args) {
        pack();
        System.out.println(maxV);
    }

    private static void pack() {
        // 初始化为-1，区别出不可达状态
            for (int j = 0; j < w; j++) {
                states[j] = -1;
            }

        // 第一个物品特殊处理
        // 不放
        states[0] = 0;
        if(weights[0] <= w) {
            states[weights[0]] = values[0];
        }

        for(int i = 1; i < weights.length; i++) {
            // 不放
            // 放，前提是放得进
            for(int j = w-weights[i]; j >=0; j--) {
                if(states[j] >= 0) {
                    int v = states[j] + values[i];
                    if(v > states[j+weights[i]]) {
                        states[j+weights[i]] = v;
                    }
                }
            }
        }
    }

    private static void f(int i, int cw, int cv) {
        if (i == n || cw == w) {
            if(cv>maxV) {
                maxV = cv;
            }
            return;
        }
        // 不放
        f(i+1,cw,cv);
        // 放，前提是放得进
        if(cw+ weights[i] <= w) {
            f(i+1,cw+ weights[i],cv+ values[i]);
        }
    }
}
