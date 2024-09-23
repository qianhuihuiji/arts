import java.util.ArrayList;
import java.util.List;

public class Demo {
    private static int minLen = Integer.MAX_VALUE; // 结果放到 minLen 中
    private static int[][] triangle = {{2}, {3, 4}, {6, 5, 7}, {4, 1, 8, 3}};
    //    private static int[][] triangle = {{-1}, {-2, -3}};
    private static int n = 4; // 层数
    private static int[][] states = new int[2][2]; // 记录状态

    public static void main(String[] args) {
        List<List<Integer>> tr = intToList(triangle);
        System.out.println(minimumTotal(tr));
    }

    private static List<List<Integer>> intToList(int[][] states) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < states.length; i++) {
            List<Integer> tmp = new ArrayList<>();
            for (int j = 0; j < states[i].length; j++) {
                tmp.add(states[i][j]);
            }
            list.add(tmp);
        }

        return list;
    }

    public static int minimumTotal(List<List<Integer>> triangle) {
        int size = triangle.size();
        int[] states = new int[size];
        // 第一行数据处理
        states[0] = triangle.get(0).get(0);
        for (int i = 1; i < size; i++) {
            // 处理最后一个
            int lastIdx = triangle.get(i).size() - 1;
            states[lastIdx] = states[lastIdx - 1] + triangle.get(i).get(lastIdx);
            // 得倒着计算，如果从前往后算，得出的结果会影响后面的
            for (int j = triangle.get(i).size() - 2; j >= 1; j--) {
                states[j] = triangle.get(i).get(j) + Math.min(states[j], states[j - 1]);
            }
            // 处理第一个
            states[0] = states[0] + triangle.get(i).get(0);
        }
        int minLen = Integer.MAX_VALUE;
        for (int i = 0; i < size; i++) {
            if (states[i] < minLen) {
                minLen = states[i];
            }
        }

        return minLen;
    }

    private static void f(int i, int j, int cl, Integer minLen, List<List<Integer>> triangle) {
        if (i < triangle.size() && j < triangle.get(i).size()) {
            cl = cl + triangle.get(i).get(j);
        }
        if (i == n) {
            if (cl < minLen) {
                minLen = cl;
            }
            return;
        }

        // 往左走
        f(i + 1, j, cl);

        // 往右走
        f(i + 1, j + 1, cl);

    }

    private static void f(int i, int j, int cl) {
        if (i < n && j < triangle[i].length) {
            cl = cl + triangle[i][j];
        }
        if (i == n) {
            if (cl < minLen) {
                minLen = cl;
            }
            return;
        }

        // 往左走
        f(i + 1, j, cl);

        // 往右走
        f(i + 1, j + 1, cl);

    }

}
