package sort;

import java.util.Arrays;

/**
 * @Description: 归并排序
 * @Author: li
 * @Create: 2020-02-01 17:30
 */
public class MergetSort {

    public static void main(String[] args) {
        int arr[] = {2, 6, 1, 3, 9, 34, 27, 18, 28, 87, 73, 90};
        MergetSort.sort(arr, 0, arr.length - 1, new int[arr.length]);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            //向左递归进行分解
            sort(arr, left, mid, temp);
            //向右递归进行分解
            sort(arr, mid + 1, right, temp);
            //合并
            merge(arr, left, right, mid, temp);
        }

    }

    public static void merge(int[] arr, int left, int right, int mid, int[] temp) {
        //合并两个有序数组，左边的第一个位置
        int l = left;
        //右边的第一个位置
        int r = mid + 1;
        //临时数组的下标
        int t = 0;

        while (l <= mid && r <= right) {
            if (arr[l] <= arr[r]) {
                temp[t++] = arr[l++];
            } else {
                temp[t++] = arr[r++];
            }
        }

        //说明 左边的数组 还有数
        while (l <= mid) {
            temp[t++] = arr[l++];
        }

        while (r <= right) {
            temp[t++] = arr[r++];
        }

        int l2 = left;
        t = 0;
        //第一次合并 tempLeft = 0 , right = 1 //  tempLeft = 2  right = 3 // tL=0 ri=3
        //最后一次 tempLeft = 0  right = 7
        while (l2 <= right) {
            arr[l2++] = temp[t++];
        }
    }
}
