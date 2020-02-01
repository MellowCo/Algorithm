package sort;

import java.util.Arrays;

/**
 * @Description: 希尔排序
 * @Author: li
 * @Create: 2020-02-01 14:33
 */
public class ShellSort {

    public static void main(String[] args) {
        int arr[] = {8, 9, 1, 7, 2, 3, 5, 4, 7, 0};

        // ShellSort.sort(arr);
        ShellSort.sort2(arr);
    }

    // 希尔排序时， 对有序序列在插入时采用交换法
    //类似冒泡排序 效率很低
    public static void sort(int[] arr) {
        //临时变量
        int temp = 0;
        for (int g = arr.length / 2; g > 0; g /= 2) {
            for (int i = g; i < arr.length; i++) {
                //遍历各组中所有的元素(共gap组，每组有个元素), 步长gap
                for (int j = i - g; j >= 0; j -= g) {
                    //如果当前元素大于加上步长后的那个元素，说明交换
                    //类似冒泡排序
                    if (arr[j] > arr[j + g]) {
                        temp = arr[j];
                        arr[j] = arr[j + g];
                        arr[j + g] = temp;
                    }
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    //对交换式的希尔排序进行优化->移位法
    //类似插入排序 效率高
    public static void sort2(int[] arr) {
        int index = 0;
        int val = 0;

        for (int g = arr.length / 2; g > 0; g /= 2) {
            for (int i = g; i < arr.length; i++) {
                //定义插入的位置和待插入的数
                index = i - g;
                val = arr[i];

                //后面的数 小于 前面的数
                if (val < arr[index]) {
                    //做移位操作
                    //使用插入排序
                    while (index >= 0 && arr[index] > val) {
                        arr[index + g] = arr[index];
                        index -= g;
                    }
                    arr[index + g] = val;
                }
            }
        }

        System.out.println(Arrays.toString(arr));
    }
}
