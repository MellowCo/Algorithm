package linkedlist;

/**
 * @Description: 环形链表 Josephu(约瑟夫、约瑟夫环)  问题
 * Josephu  问题为：设编号为1，2，… n的n个人围坐一圈，约定编号为k（1<=k<=n）的人从1开始报数，
 * 数到m 的那个人出列，它的下一位又从1开始报数，数到m的那个人又出列，依次类推，
 * 直到所有人出列为止，由此产生一个出队编号的序列
 * <p>
 * 提示：用一个 不带头结点 的循环链表来处理Josephu 问题：
 * 先构成一个有n个结点的单循环链表，然后由k结点起从1开始计数，计到m时，对应结点从链表中删除，
 * 然后再从被删除结点的下一个结点又从1开始计数，直到最后一个结点从链表中删除算法结束。
 * @Author: li
 * @Create: 2020-01-30 15:32
 */
public class Josepfu {
    public static void main(String[] args) {
        CircleSingleLinkedList list = new CircleSingleLinkedList();
        // list.countBoy(5, 1, 2);
        // list.countBoy(9, 1, 5);
        list.countBoy(125, 10, 20);
        // list.show();
    }
}


/*
 * 环形链表
 */
class CircleSingleLinkedList {
    //指向第一个节点，不带头节点
    Boy first = null;

    //n个人围坐一圈 在环形链表中添加n个节点
    //返回最后一个节点的位置
    public Boy add(int n) {
        if (n < 1) {
            System.out.println("不能小于1个节点");
            return null;
        }

        //辅助节点指向最后一个节点
        Boy last = null;

        for (int i = 1; i <= n; i++) {
            Boy boy = new Boy(i);
            if (i == 1) {
                //第一个节点
                first = boy;
            } else {
                //1~n个节点
                last.next = boy;
            }
            last = boy;
            boy.next = first;
        }
        return last;
    }

    //遍历环形链表
    public void show() {

        if (first == null) {
            System.out.println("链表为空");
            return;
        }

        //辅助节点
        Boy cur = first;
        while (true) {
            System.out.println(cur.no);
            cur = cur.next;
            if (cur == first) {
                //回到第一个节点 停止遍历
                break;
            }
        }

    }

    /**
     * @param n 1，2，… n的n个人围坐一圈
     * @param k 约定编号为k（1<=k<=n）的人从1开始报数
     * @param m 数到m 的那个人出列
     * @Return void
     */
    public void countBoy(int n, int k, int m) {
        //判断数据是否正确
        if (n < 1 || k > n || m < 1) {
            System.out.println("错误");
            return;
        }

        //当前的节点 = 最后一个节点
        Boy cur = add(n);

        for (int i = 1; i < k; i++) {
            //找到第k个人
            //cur在第k个人前的那个节点，方便删除节点
            cur = cur.next;
        }

        int count = 0;
        while (true) {
            count++;
            //点到m
            if (count == m) {
                /*
                 * 打印no
                 * 删除节点，n减1
                 * count变为1 因为cur向下移动
                 */
                System.out.println(cur.next.no);
                cur.next = cur.next.next;
                if (--n == 0) {
                    //所有人都出去了
                    break;
                }
                count = 1;
            }
            cur = cur.next;
        }


    }

}

/*
 * 孩子节点
 */
class Boy {
    int no;
    Boy next;

    public Boy(int no) {
        this.no = no;
    }

    public Boy() {
    }

    @Override
    public String toString() {
        return "Boy{" +
                "no=" + no +
                '}';
    }
}
