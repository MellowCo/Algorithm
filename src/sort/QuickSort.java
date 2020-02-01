package sort;

import java.util.Arrays;

/**
 * @Description: 快速排序
 * @Author: li
 * @Create: 2020-02-01 16:11
 */
public class QuickSort {

    public static void main(String[] args) {
        int arr[] = {2,6,1,3,9,34,27,18,28,87,73,90};
        QuickSort.sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr,int left,int right) {
        if (left > right) {
            return ;
        }

        //临时变量
        int temp = 0;
        int i = left;
        int j = right;
        //以第一个值为基准
        int val = arr[left];

        //i 必须在 j 的左边 不能相遇
        while (i < j) {
            //j先从右边移动
            //找到 比基准小的值
            while (arr[j] >= val && i < j) {
                j--;
            }

            //j移动后 i在从左边移动
            //找到 比基准大的值
            while (arr[i] <= val && i < j) {
                i++;
            }

            //交换两边的值
            if (i < j){
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        //i j 相遇后
        //说明当前位置左边都小于基准 右边都大于基准
        //将基准值 放到 当前位置
        arr[left] = arr[i];
        arr[i] = val;

        //递归左
        sort(arr,left,j-1);
        //递归右
        sort(arr, j + 1, right);
    }
}
