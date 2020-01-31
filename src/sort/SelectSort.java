package sort;

import java.util.Arrays;

/**
 * @Description: 选择排序
 * @Author: li
 * @Create: 2020-01-31 19:35
 */
public class SelectSort {

    public static int[] sort(int[] arr) {
        //假定最小值的下标
        int minIndex = 0;
        //假定最小值
        int min = 0;
        for (int i = 0; i < arr.length; i++) {

            minIndex = i;
            min = arr[i];

            for (int j = i+1; j < arr.length; j++) {
                //如果当前数 小于 假定最小值下标
                if (arr[j] < arr[minIndex]) {
                    //记录最小值下标
                    minIndex = j;
                }
            }

            //说明最小值下标出现变化
            if (minIndex != i){
                arr[i] = arr[minIndex];
                arr[minIndex] = min;
            }
        }

        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3432, 23, 54, 5, 13, 12, 5234, 32, 532423, 432, 4, 23, 4, 21312};
        System.out.println(Arrays.toString(SelectSort.sort(arr)));
    }
}
