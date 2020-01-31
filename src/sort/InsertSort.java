package sort;

import java.util.Arrays;

/**
 * @Description: 插入排序
 * @Author: li
 * @Create: 2020-01-31 20:19
 */
public class InsertSort {

    public static int[] sort(int[] arr) {
        int insertIndex = 0;
        int insertVal = 0;
        for (int i = 1; i < arr.length; i++) {
            //定义插入的位置
            insertIndex = i - 1;
            //定义待插入的数
            insertVal = arr[i];

            // 1. insertIndex >= 0 保证在给insertVal 找插入位置，不越界
            // 2. arr[insertIndex] > insertVal 待插入的数，还没有找到插入位置
            // 3. 就需要将 arr[insertIndex] 后移
            while (insertIndex >= 0 && arr[insertIndex] > insertVal) {
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }

            //用if进行优化 因为insertIndex = i -1
            //如果insertIndex没有变化 说明未排序 不进行赋值
            // if (insertIndex + 1 != i) {
                arr[insertIndex + 1] = insertVal;
            // }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3432, 23, 54, 5, 13, 12, 5234, 32, 532423, 432, 4, 23, 4, 21312};
        System.out.println(Arrays.toString(InsertSort.sort(arr)));
    }
}
