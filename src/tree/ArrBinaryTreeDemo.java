package tree;

/**
 * @Description: 顺序二叉树
 * @Author: li
 * @Create: 2020-02-03 15:09
 */
public class ArrBinaryTreeDemo {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        ArrBinaryTree tree = new ArrBinaryTree(arr);
        tree.preOrder(0);
        System.out.println("============");
        tree.inOrder(0);
        System.out.println("============");
        tree.postOrder(0);
    }
}

class ArrBinaryTree {
    int[] arr;

    public ArrBinaryTree(int[] arr) {
        this.arr = arr;
    }


    //前序
    public void preOrder(int index) {
        //如果数组为空，或者 arr.length = 0
        if (arr == null || arr.length == 0) {
            System.out.println("数组为空，不能按照二叉树的前序遍历");
        }
        //输出当前节点
        System.out.println(arr[index]);

        //左节点
        if (2 * index + 1 < arr.length) {
            preOrder(2 * index + 1);
        }

        //右节点
        if (2 * index + 2 < arr.length) {
            preOrder(2 * index + 2);
        }
    }


    //中序
    public void inOrder(int index) {
        //如果数组为空，或者 arr.length = 0
        if (arr == null || arr.length == 0) {
            System.out.println("数组为空，不能按照二叉树的前序遍历");
        }

        //左节点
        if (2 * index + 1 < arr.length) {
            inOrder(2 * index + 1);
        }
        //输出当前节点
        System.out.println(arr[index]);

        //右节点
        if (2 * index + 2 < arr.length) {
            inOrder(2 * index + 2);
        }
    }

    //后序
    public void postOrder(int index) {
        //如果数组为空，或者 arr.length = 0
        if (arr == null || arr.length == 0) {
            System.out.println("数组为空，不能按照二叉树的前序遍历");
        }

        //左节点
        if (2 * index + 1 < arr.length) {
            postOrder(2 * index + 1);
        }
        //右节点
        if (2 * index + 2 < arr.length) {
            postOrder(2 * index + 2);
        }
        //输出当前节点
        System.out.println(arr[index]);

    }


}
