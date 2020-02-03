    package tree;

    /**
     * @Description: 二叉树
     * @Author: li
     * @Create: 2020-02-02 20:53
     */
    public class BinaryTreeDemo {
        public static void main(String[] args) {
            Node node1 = new Node("A");
            Node node2 = new Node("B");
            Node node3 = new Node("C");
            Node node4 = new Node("D");
            Node node5 = new Node("E");
            Node node6 = new Node("F");
            Node node7 = new Node("G");
            Node node8 = new Node("H");

            node1.setLeft(node2);
            node1.setRight(node3);
            node2.setLeft(node4);
            node4.setRight(node7);
            node3.setLeft(node5);
            node3.setRight(node6);
            node6.setLeft(node8);

            BinaryTree tree = new BinaryTree(node1);
            System.out.println("前");
            tree.preOrder();
            System.out.println("中");
            tree.inOrder();
            System.out.println("后");
            tree.postOrder();
        }
    }

    class BinaryTree {
        Node root;

        public BinaryTree(Node root) {
            this.root = root;
        }


        //前序遍历
        public void preOrder() {
            if (this.root != null) {
                this.root.preOrder();
            } else {
                System.out.println("二叉树为空，无法遍历");
            }
        }

        //中序遍历
        public void inOrder() {
            if (this.root != null) {
                this.root.inOrder();
            } else {
                System.out.println("二叉树为空，无法遍历");
            }
        }

        //后序遍历
        public void postOrder() {
            if (this.root != null) {
                this.root.postOrder();
            } else {
                System.out.println("二叉树为空，无法遍历");
            }
        }


    }

    class Node {
        String val;
        Node left;
        Node right;

        public void setLeft(Node left) {
            this.left = left;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        public Node(String val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "val=" + val +
                    '}';
        }

        //删除节点
        /*
             1. 因为我们的二叉树是单向的，所以我们是判断当前结点的子结点是否需要删除结点，而不能去判断当前这个结点是不是需要删除结点.
            2. 如果当前结点的左子结点不为空，并且左子结点 就是要删除结点，就将this.left = null; 并且就返回(结束递归删除)
            3. 如果当前结点的右子结点不为空，并且右子结点 就是要删除结点，就将this.right= null ;并且就返回(结束递归删除)
            4. 如果第2和第3步没有删除结点，那么我们就需要向左子树进行递归删除
            5.  如果第4步也没有删除结点，则应当向右子树进行递归删除.
         */
        public void del(String no) {
            //删除左节点
            if (this.left != null && this.left.val == no) {
                this.left = null;
                return;
            }
            //删除右节点
            if (this.right != null && this.right.val == no) {
                this.right = null;
                return;
            }

            if (this.left != null) {
                this.left.del(no);
            }

            if (this.right != null) {
                this.right.del(no);
            }
        }

        //编写前序遍历的方法
        public void preOrder() {
            System.out.println(this);
            //递归向左子树前序遍历
            if (this.left != null) {
                this.left.preOrder();
            }
            //递归向右子树前序遍历
            if (this.right != null) {
                this.right.preOrder();
            }
        }

        //前序查找
        public Node preOrderSearch(String val) {
            if (this.val == val) {
                return this;
            }

            Node temp = null;
            if (this.left != null) {
                temp = this.left.preOrderSearch(val);
            }

            if (temp != null) {
                return temp;
            }

            if (this.right != null) {
                temp = this.right.preOrderSearch(val);
            }
            return temp;
        }

        //中序遍历
        public void inOrder() {

            //递归向左子树中序遍历
            if (this.left != null) {
                this.left.inOrder();
            }
            //输出父结点
            System.out.println(this);
            //递归向右子树中序遍历
            if (this.right != null) {
                this.right.inOrder();
            }
        }

        //后序遍历
        public void postOrder() {
            if (this.left != null) {
                this.left.postOrder();
            }
            if (this.right != null) {
                this.right.postOrder();
            }
            System.out.println(this);
        }

    }
