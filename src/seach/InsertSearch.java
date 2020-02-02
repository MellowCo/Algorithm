package seach;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 插值查找
 * @Author: li
 * @Create: 2020-02-02 16:08
 */
public class InsertSearch {

    public static void main(String[] args) {
        int[] arr = {1, 1, 8, 10, 89, 1000, 1000};
        System.out.println(InsertSearch.search(arr, 0, arr.length - 1, 1000));
        System.out.println(InsertSearch.search(arr, 0, arr.length - 1, 1));

    }

    public static List<Integer> search(int[] arr, int left, int right, int data) {

        if (left > right || arr[0] > data || arr[arr.length - 1] < data) {
            return null;
        }

        int mid = left + (right - left) * (data - arr[left]) / (arr[right] - arr[left]);

        if (arr[mid] > data) {
            return search(arr, left, mid - 1, data);
        } else if (arr[mid] < data) {
            return search(arr, mid + 1, right, data);
        } else {

            List<Integer> temp = new ArrayList<>();
            temp.add(mid);

            int tempM = mid;

            while (++mid <= arr.length - 1 && arr[mid] == data) {
                temp.add(mid);
            }

            while (--tempM >= 0 && arr[tempM] == data) {
                temp.add(tempM);
            }
            return temp;
        }
    }
}
