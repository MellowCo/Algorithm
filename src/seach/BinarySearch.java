package seach;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 二分查找
 * @Author: li
 * @Create: 2020-02-02 14:53
 */
public class BinarySearch {

    public static void main(String[] args) {
        // int[] arr = {1, 2, 3, 4, 5, 6, 7, 7, 8, 8, 10};
        // System.out.println(BinarySearch.search(arr, 0, arr.length - 1, 9));
        // System.out.println(BinarySearch.search(arr, 0, arr.length - 1, 4));
        // System.out.println(BinarySearch.search(arr, 0, arr.length - 1, 5));
        // System.out.println(BinarySearch.search(arr, 0, arr.length - 1, 8));
        // System.out.println(BinarySearch.search(arr, 0, arr.length - 1, 10));
        // System.out.println(BinarySearch.search(arr, 0, arr.length - 1, 11));

        int[] arr = {1,1, 8, 10, 89, 1000, 1000};
        System.out.println(BinarySearch.search2(arr, 0, arr.length - 1, 1000, new ArrayList<Integer>()));
        System.out.println(BinarySearch.search2(arr, 0, arr.length - 1, 1, new ArrayList<Integer>()));

    }

    public static int search(int[] arr, int left, int right, int data) {
        // 当 left > right 时，说明递归整个数组，但是没有找到
        if (left > right) {
            return -1;
        }

        int mid = (left + right) / 2;

        if (data > arr[mid]) {
            //向右
            return search(arr, mid + 1, right, data);
        } else if (data < arr[mid]) {
            //向左
            return search(arr, left, mid - 1, data);
        } else {
            //相等 返回下标
            return mid;
        }
    }

    //{1,8, 10, 89, 1000, 1000，1234}
    // 当一个有序数组中，有多个相同的数值时，如何将所有的数值都查找到，比如这里的 1000.
    public static List<Integer> search2(int[] arr, int left, int right, int data, ArrayList<Integer> tempArr) {
        // 当 left > right 时，说明递归整个数组，但是没有找到
        if (left > right) {
            return tempArr;
        }

        int mid = (left + right) / 2;

        if (data > arr[mid]) {
            //向右
            return search2(arr, mid + 1, right, data,tempArr);
        } else if (data < arr[mid]) {
            //向左
            return search2(arr, left, mid - 1, data,tempArr);
        } else {
            tempArr.add(mid);
            int tempM= mid;
            //向左查找
            //当mid 数组越界 或 不等于data 跳出循环
            while (--mid >= 0 && arr[mid] == data) {
                tempArr.add(mid);
            }

            //向右查找
            //当mid 数组越界 或 不等于data 跳出循环
            while (++tempM <= arr.length - 1 && arr[tempM] == data) {
                tempArr.add(tempM);
            }

            return tempArr;
        }
    }


}
