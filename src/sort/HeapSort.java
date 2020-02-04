package sort;

import java.util.Arrays;

/**
 * @Description: 堆排序
 * @Author: li
 * @Create: 2020-02-03 16:23
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {4, 6, 8, 5, 9};
        HeapSort.sort(arr);
    }

    public static void sort(int[] arr) {
        int temp = 0;

        //调整
        //将无序序列构建成一个堆，根据升序降序需求选择大顶堆或小顶堆
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjust(arr, i, arr.length);
        }
        //将堆顶元素与末尾元素交换，将最大元素"沉"到数组末端;
        for (int i = arr.length - 1; i >= 0; i--) {
            temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            adjust(arr, 0, i );
        }
        System.out.println(Arrays.toString(arr));
    }


    /**
     * @param arr    数组
     * @param index  非叶子节点下标
     * @param length 调整的范围
     * @Return void
     */
    public static void adjust(int[] arr, int index, int length) {
        //当前非叶子节点的值
        int temp = arr[index];
        //向下比较 2*index+1 左子树的下标
        for (int i = 2 * index + 1; i < length; i = 2 * i + 1) {
            //找出左右子树的最大值
            //i + 1 < length 最后一层可以没有右子树
            if (i + 1 < length && arr[i + 1] > arr[i]) {
                i++;
            }
            //左右子树的值大于temp
            if (arr[i] > temp) {
                //更改当前非叶子节点的值
                arr[index] = arr[i];
                //下标指向左右子树 继续循环比较
                index = i;
            } else {
                break;
            }
            //当for 循环结束后，我们已经将以i为父结点的树的最大值，放在了 最顶(局部)
            //将temp值放到调整后的位置
            arr[index] = temp;
        }

    }
}


