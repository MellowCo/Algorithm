package recursion;

/**
 * @Description: 递归 解决 迷宫问题
 * @Author: li
 * @Create: 2020-01-31 15:13
 */
public class MiGong {

    public static void main(String[] args) {
        //创建一个8行7列的数组迷宫
        // 1 1 1 1 1 1 1
        // 1 0 0 0 0 0 1
        // 1 0 0 0 0 0 1
        // 1 1 1 0 0 0 1
        // 1 0 0 0 0 0 1
        // 1 0 0 0 0 0 1
        // 1 0 0 0 0 0 1
        // 1 1 1 1 1 1 1
        int[][] map = new int[8][7];

        //设置墙和障碍
        // 上下全部置为1
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }

        // 左右全部置为1
        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }

        //设置挡板, 1 表示
        map[3][1] = 1;
        map[3][2] = 1;

        // 输出地图
        System.out.println("地图的情况");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

        MiGong miGong = new MiGong();
        miGong.setWay(map, 1, 1);


        // 输出地图
        System.out.println("地图的情况");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

    }


    //使用递归回溯来给小球找路
    //说明
    //1. map 表示地图
    //2. i,j 表示从地图的哪个位置开始出发 (1,1)
    //3. 如果小球能到 map[6][5] 位置，则说明通路找到.
    //4. 约定： 当map[i][j] 为 0 表示该点没有走过 当为 1 表示墙  ； 2 表示通路可以走 ； 3 表示该点已经走过，但是走不通
    //5. 在走迷宫时，需要确定一个策略(方法) 下->右->上->左 , 如果该点走不通，再回溯

    /**
     * @param map 二维数组地图
     * @param i   起点坐标
     * @param j
     * @Return boolean
     */
    public boolean setWay(int[][] map, int i, int j) {
        //终点在 (6,5)
        if (map[6][5] == 2) {
            return true;
        } else {
            if (map[i][j] == 0) {
                map[i][j] = 2;
                //下->右->上->左
                if (setWay(map, i + 1, j)) {
                    return true;
                } else if (setWay(map, i, j + 1)) {
                    return true;
                } else if (setWay(map, i - 1, j)) {
                    return true;
                } else if (setWay(map, i, j - 1)) {
                    return true;
                } else {
                    map[i][j] = 3;
                    return false;
                }
            } else {
                return false;
            }

        }
    }
}
