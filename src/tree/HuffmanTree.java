package tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Description: 哈夫曼树
 * @Author: li
 * @Create: 2020-02-04 15:24
 */
public class HuffmanTree {
    HuffmanNode head;

    public void create(int[] arr) {

        // 第一步为了操作方便
        // 1. 遍历 arr 数组
        // 2. 将arr的每个元素构成成一个Node
        // 3. 将Node 放入到ArrayList中
        List<HuffmanNode> nodes = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            nodes.add(new HuffmanNode(arr[i]));
        }

        while (nodes.size() > 1) {
            //排序 从小到大
            Collections.sort(nodes);

            //取出根节点权值最小的两颗二叉树
            //(1) 取出权值最小的结点（二叉树）
            //(2) 取出权值第二小的结点（二叉树）
            HuffmanNode left = nodes.get(0);
            HuffmanNode right = nodes.get(1);

            //(3)构建一颗新的二叉树
            HuffmanNode par = new HuffmanNode(left.data + right.data);
            par.left = left;
            par.right = right;
            //(4)从ArrayList删除处理过的二叉树
            nodes.remove(par.left);
            nodes.remove(par.right);
            //(5)将parent加入到nodes
            nodes.add(par);
        }
        head = nodes.get(0);
    }

    public void preOrder() {
        preOrder(head);
    }

    public void preOrder(HuffmanNode node) {
        if (node != null) {
            System.out.println(node.data);
            preOrder(node.left);
            preOrder(node.right);
        }
    }



    public static void main(String[] args) {
        int[] arr = {13, 7, 8, 3, 29, 6, 1};
        HuffmanTree tree = new HuffmanTree();
        tree.create(arr);
        tree.preOrder();
    }
}

/*
 * 为了让Node 对象持续排序Collections集合排序
 * 让Node 实现Comparable接口
 */
class HuffmanNode implements Comparable<HuffmanNode>{
    int data;
    HuffmanNode left;
    HuffmanNode right;

    public HuffmanNode(int data) {
        this.data = data;
    }

    public HuffmanNode() {
    }

    @Override
    public int compareTo(HuffmanNode o) {
        // 表示从小到大排序
        return this.data - o.data;
    }
}