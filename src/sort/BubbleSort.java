package sort;

import java.util.Arrays;

/**
 * @Description: 冒泡排序
 * @Author: li
 * @Create: 2020-01-31 18:54
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = {1,2,65,3,6,34,3,235,4,565,32,34235,4534};
        System.out.println(Arrays.toString(BubbleSort.sort(arr)));
    }

    public static int[] sort(int[] arr){
        int temp = 0;
        //对冒泡排序进行优化
        boolean flag = false;

        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                if (arr[i] > arr[j]){
                    flag = true;
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }

            if (!flag){
                //在一趟排序中，一次交换都没有发生过
                //说明排序提前完成了，结束循环
                break;
            }else {
                flag = false;
            }

        }
        return arr;
    }
}
