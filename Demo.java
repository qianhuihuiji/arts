
public class Demo {
    private static int maxW = Integer.MIN_VALUE; //存储背包中物品总重量的最大值
    private static int[] items = {2,2,4,6,3}; // 物品重量
    private static int total = 5; // 物品个数
    private static int totalWeight = 10; // 背包承受的最大重量
    private static boolean[][] lookup = new boolean[5][10]; // 记录状态

    public static void main(String[] args) {
        // 假设背包可承受重量 5，物品个数 5，数组 items 存储物品重量：
        pack(0, 0);

        System.out.println("最大重量:" + maxW);
    }

    private static void pack(int currentItem, int currentWeight) {
        // currentWeight == totalWeight 表示已装满
        // currentItem == total 表示物品已遍历完
        if (currentWeight == totalWeight || currentItem == total) {
            if (currentWeight > maxW) maxW = currentWeight;

            return;
        }

        // 判断是否已经记录过该状态
        // 如果记录过的话，maxW 也已经被判断处理过了
        if (lookup[currentItem][currentWeight]) return;
        // 记录状态
        lookup[currentItem][currentWeight] = true;

        // 不装入当前物品，因此 currentWeight 不变
        pack(currentItem+1, currentWeight);

        // 只有在装入当前物品不超重的前提下，才会装入
        if (currentWeight + items[currentItem] <= totalWeight) {
            // 装入当前物品，因此 currentWeight 要加上当前物品的重量
            pack(currentItem+1, currentWeight + items[currentItem]);
        }
    }
}
