package tree;

/**
 * @Description: 平衡树
 * @Author: li
 * @Create: 2020-02-04 18:23
 */
public class AvlTreeDemo {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};

        AvlTree avlTree = new AvlTree();
        for (int i : arr) {
            avlTree.add(new BSTNode(i));
        }

        System.out.println(avlTree.height(avlTree.root));

    }
}

class AvlTree {
    BSTNode root = null;

    /**
     * @param node 节点
     * @Return int 从node算的树高
     */
    public int height(BSTNode node) {
        if (node != null){
            return Math.max(node.left == null ? 0 : height(node.left), node.right == null ? 0 : height(node.right)) + 1;
        }
        return 0;
    }

    //左子树高
    public int leftHeight(){
        return height(root.left);
    }
    //右子树高
    public int rightHeight(){
        return height(root.right);
    }

    //添加
    public void add(BSTNode node) {
        if (root == null) {
            root = node;
            return;
        }
        root.add(node);

        //如果左子树大于右子树 右旋
        if (leftHeight() - rightHeight() > 1) {
            rightHeight();
        }
        //如果右子树大于左子树 左旋
        if (rightHeight() - leftHeight() > 1){
            leftHeight();
        }
    }


    //左旋转
    public void leftR(){
        //新建一个节点
        BSTNode temp = new BSTNode(root.val);
        //temp的左子树指向当前节点的左子树
        temp.left = root.left;
        //temp的右子树指向当前节点的右子树的左子树
        temp.right = root.right.left;
        //当前节点的值改为当前节点的右子树的值
        root.val = root.right.val;
        //当前节点的右子树指向当前节点的右子树的右子树
        root.right = root.right.right;
        //当前节点的左子树指向temp
        root.left = temp;
    }

    //右旋转
    public void rightR(){
        //新建一个节点
        BSTNode temp = new BSTNode(root.val);
        //temp的右子树指向当前节点的右子树
        temp.right = root.right;
        //temp的左子树指向当前节点的左子树的右子树
        temp.left = root.left.right;
        //当前节点的值改为当前节点的左子树的值
        root.val = root.left.val;
        //当前节点的左子树指向当前节点的左子树的左子树
        root.left = root.left.left;
        //当前节点的右子树指向temp
        root.right = temp;
    }



}
