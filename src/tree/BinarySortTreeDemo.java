package tree;

/**
 * @Description: 二叉排序树
 * @Author: li
 * @Create: 2020-02-04 15:57
 */
public class BinarySortTreeDemo {
    public static void main(String[] args) {
        int[] arr = {7, 3, 10, 12, 5, 1, 9, 2, 13};
        BinarySortTree tree = new BinarySortTree();
        for (int i : arr) {
            tree.add(new BSTNode(i));
        }

        tree.preOrder();

        System.out.println("===================");

        //1 删除叶子节点
        // tree.del(5);
        // tree.del(12);
        // tree.preOrder();
        // System.out.println("===================");

        // //3 删除只有一颗子树的节点
        // tree.del(2);
        // tree.del(13);
        // tree.preOrder();
        // System.out.println("===================");

        //2 删除有两颗子树的节点.
        // tree.del(10);
        tree.del(7);
        tree.preOrder();
        System.out.println("===================");

    }
}

class BinarySortTree {
    BSTNode root;

    //添加
    public void add(BSTNode node) {
        if (root == null) {
            root = node;
            return;
        }
        root.add(node);
    }

    //删除
    public void del(int val) {
        //查找值的父节点
        BSTNode par = root.search(val);

        if (par == null) {
            System.out.println("不存在");
            return;
        }
        //要删除的节点
        BSTNode cur = null;
        //true cur为par的左节点
        //false cur为par的右节点
        boolean flag = true;
        if (par.left != null && par.left.val == val) {
            cur = par.left;
        } else {
            cur = par.right;
            flag = false;
        }

        //1 删除叶子节点
        if (cur.left == null && cur.right == null) {
            //确定 cur 是 par的左子结点 还是右子结点
            if (flag) {
                //左子结点 parent.left = null
                par.left = null;
            } else {
                //右子结点 parent.right = null;
                par.right = null;
            }
        } else if (cur.left != null && cur.right != null) {
            //2 删除有两颗子树的节点.
            //从cur的右子树找到最小的结点
            // 用一个临时变量，将 最小结点的值保存 temp
            //删除该最小结点
            int temp = delMin(cur.right);
            cur.val = temp;
        } else {
            //3 删除只有一颗子树的节点
            //确定 cur 是 par的左子结点 还是右子结点
            if (flag) {
                //左子结点
                if (cur.left != null) {
                    par.left = cur.left;
                } else {
                    par.right = cur.right;
                }
            } else {
                //右子结点
                if (cur.right != null) {
                    par.right = cur.right;
                } else {
                    par.right = cur.left;
                }
            }
        }

    }

    /**
     * @param node 以node节点开始
     * @Return int 查找最小值 并 删除这个节点
     */
    public int delMin(BSTNode node) {
        BSTNode temp = node;

        //查找最小值 并 删除这个节点
        while (temp.left != null) {
            temp = temp.left;
        }
        //删除这个节点
        del(temp.val);
        return temp.val;
    }

    public void preOrder() {
        preOrder(root);
    }

    public void preOrder(BSTNode node) {
        if (node != null) {
            System.out.println(node.val);
            preOrder(node.left);
            preOrder(node.right);
        }
    }

}


class BSTNode {
    int val;
    BSTNode left;
    BSTNode right;

    public BSTNode(int val) {
        this.val = val;
    }

    public BSTNode() {
    }

    @Override
    public String toString() {
        return "BSTNode{" +
                "val=" + val +
                '}';
    }

    //添加
    public void add(BSTNode node) {
        if (node == null) {
            return;
        }
        if (node.val > this.val) {
            if (this.right == null) {
                this.right = node;
            } else {
                this.right.add(node);
            }
        } else {
            if (this.left == null) {
                this.left = node;
            } else {
                this.left.add(node);
            }
        }
    }


    //查找 返回要查找值的父节点
    public BSTNode search(int val) {
        if (this.left != null && this.left.val == val || this.right != null && this.right.val == val) {
            return this;
        }

        if (this.left != null && val < this.val) {
            return this.left.search(val);
        }
        if (this.right != null && val > this.val) {
            return this.right.search(val);
        }
        return null;
    }

}
