package algorithm.binarySearch;

/**
 * @Description: 不使用递归的二分查找
 * @Author: li
 * @Create: 2020-02-05 16:46
 */
public class BinarySearchNoRecur {

    public static int search(int[] arr,int data) {
        int left = 0;
        int right = arr.length - 1;
        int mid = 0;

        while (left <= right){
            mid = (left + right) / 2;
            if (arr[mid] == data){
                return mid;
            }else if (arr[mid] < data){
                left = mid+1;
            }else{
                right = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println("index=" + BinarySearchNoRecur.search(arr,0));
        System.out.println("index=" + BinarySearchNoRecur.search(arr,1));
        System.out.println("index=" + BinarySearchNoRecur.search(arr,8));
    }
}
