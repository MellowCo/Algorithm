package seach;

/**
 * @Description: 二分查找
 * @Author: li
 * @Create: 2020-02-02 14:53
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 7, 8, 8, 10};
        System.out.println(BinarySearch.search(arr, 0, arr.length - 1, 9));
        System.out.println(BinarySearch.search(arr, 0, arr.length - 1, 4));
        System.out.println(BinarySearch.search(arr, 0, arr.length - 1, 5));
        System.out.println(BinarySearch.search(arr, 0, arr.length - 1, 8));
        System.out.println(BinarySearch.search(arr, 0, arr.length - 1, 10));
        System.out.println(BinarySearch.search(arr, 0, arr.length - 1, 11));
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
}
