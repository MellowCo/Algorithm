package recursion;

import java.util.Arrays;

/**
 * @Description: 八皇后 问题
 * 八皇后问题，是一个古老而著名的问题，是回溯算法的典型案例。
 * 该问题是国际西洋棋棋手马克斯·贝瑟尔于1848年提出：在8×8格的国际象棋上摆放八个皇后，使其不能互相攻击，
 * 即：任意两个皇后都不能处于同一行、同一列或同一斜线上，问有多少种摆法。
 * @Author: li
 * @Create: 2020-01-31 15:35
 */
public class Queen {

    int max[] = new int[8];

    public static void main(String[] args) {
        Queen q = new Queen();
        q.setChess(0);
    }

   /**
    * @param n 第n个皇后
    * @Return boolean
    */
    public boolean isRight(int n) {
        for (int i = 0; i < n; i++) {
            //array[i] == array[n]  表示判断 第n个皇后是否和前面的n-1个皇后在同一列
            //Math.abs(n-i) == Math.abs(array[n] - array[i]) 表示判断第n个皇后是否和第i皇后是否在同一斜线
            //Math.abs() 取绝对值 可以看做等腰直角三角形
            if (max[i] == max[n] || Math.abs(i - n) == Math.abs(max[i] - max[n])) {
                return false;
            }
        }
        return true;
    }

    /**
     * @param n 放入第n个皇后
     * @Return voidn
     */
    public  void setChess(int n) {

        if (n == 8) {
            System.out.println(Arrays.toString(max));
            return;
        } else {
            for (int i = 0; i < 8; i++) {
                max[n] = i;
                if (isRight(n)){
                    //不冲突 放下一个皇后
                    setChess(n+1);
                }
            }

        }
    }
}