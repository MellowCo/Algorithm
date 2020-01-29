package linkedlist;

import java.util.Stack;

/**
 * @Description: 单向链表
 * @Author: li
 * @Create: 2020-01-29 14:40
 */
public class SingleLinkedListDemo {
    public static void main(String[] args) {
        PersonNode node1 = new PersonNode(1, "li");
        PersonNode node2 = new PersonNode(2, "wang");
        PersonNode node3 = new PersonNode(3, "zhao");
        PersonNode node4 = new PersonNode(4, "zhao1");
        PersonNode node5 = new PersonNode(5, "zhao2");
        PersonNode node6 = new PersonNode(6, "zhao26");
        PersonNode node7 = new PersonNode(7, "zhao2677");
        PersonNode node8 = new PersonNode(8, "zhao2688");

        // SingleLinkedList list = new SingleLinkedList();
        // // list.addNode(node1);
        // // list.addNode(node5);
        // // list.addNode(node2);
        // // list.addNode(node3);
        // // list.addNode(node4);
        //
        // SingleLinkedList list2 = new SingleLinkedList();
        // list2.addNodeByNo(node3);
        // list2.addNodeByNo(node1);
        // list2.addNodeByNo(node2);
        // list2.addNodeByNo(node4);
        // list2.addNodeByNo(node5);
        // list2.addNodeByNo(node6);
        //
        // PersonNode node7 = new PersonNode(1, "waaaa");
        //
        // // list.showNode();
        // list2.showNode();
        // 更新 删除
        // /list2.update(node7);
        // list2.del(1);
        // list.del(1);
        //反转链表
        // list2.reverseList(list2);

        //有效个数
        // System.out.println(list2.getSize());
        // System.out.println(list2.reverseNode(2));
        //反向遍历
        // list2.reversePrint();
        // list2.showNode();

        SingleLinkedList list3 = new SingleLinkedList();
        list3.addNodeByNo(node3);
        list3.addNodeByNo(node1);
        list3.addNodeByNo(node5);
        list3.addNodeByNo(node8);
        SingleLinkedList list4 = new SingleLinkedList();
        list4.addNodeByNo(node4);
        list4.addNodeByNo(node2);
        list4.addNodeByNo(node6);
        list4.addNodeByNo(node7);


        list3.showNode();
        System.out.println("============");
        list4.showNode();

        System.out.println("合并");
        SingleLinkedList list5 = list3.merge(list3, list4);
        list5.showNode();
    }
}

class SingleLinkedList {
    //定义头结点
    PersonNode head;

    public SingleLinkedList(PersonNode head) {
        this.head = head;
    }

    public SingleLinkedList() {
        head = new PersonNode();
    }

    //在尾部添加一个节点
    public void addNode(PersonNode node) {
        //定义一个辅助节点
        PersonNode temp = head;

        while (true) {
            if (temp.next == null) {
                //next为null 则为最后一个节点
                break;
            }
            //不是最后一个节点，一直下移
            temp = temp.next;
        }
        //在最后节点 添加新节点
        temp.next = node;
    }

    //按照编号 添加节点
    public void addNodeByNo(PersonNode node) {
        PersonNode temp = head;

        //存在编号相同
        boolean flag = false;

        while (true) {
            //后移 要判断是否为最后一个节点
            if (temp.next == null) {
                //到达最后一个节点
                break;
            }

            if (temp.next.no > node.no) {
                //找到插入的位置
                break;
            } else if (temp.next.no == node.no) {
                //编号相同
                flag = true;
                break;
            }
            //后移
            temp = temp.next;
        }

        if (flag) {
            System.out.println("编号以存在");
        } else {
            //插入新节点
            node.next = temp.next;
            temp.next = node;
        }
    }

    //根据编号 修改信息
    public void update(PersonNode node) {
        //判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }

        //定义一个辅助节点
        PersonNode temp = head.next;
        //可能不存在编号
        boolean flag = false;

        while (true) {
            //最后一个节点 也没有匹配的
            if (temp == null) {
                flag = true;
                break;
            }
            //找到匹配的no
            if (temp.no == node.no) {
                break;
            }
            temp = temp.next;
        }

        if (flag) {
            System.out.println("未找到匹配的no");
        } else {
            temp.name = node.name;
        }
    }

    //根据编号删除节点
    public void del(int no) {
        //判断链表是否为空
        //可写可不写
        // if (head.next == null) {
        //     System.out.println("链表为空");
        //     return;
        // }

        PersonNode temp = head;
        boolean flag = false;

        while (true) {
            if (temp.next == null) {
                //未找到对应的编号
                flag = true;
                break;
            }

            if (temp.next.no == no) {
                //找到要删除的节点
                break;
            }

            temp = temp.next;
        }

        if (flag) {
            System.out.println("编号不存在");
        } else {
            //更改next的指向
            temp.next = temp.next.next;
        }
    }

    //遍历节点
    public void showNode() {
        //判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }

        //定义一个辅助节点
        PersonNode temp = head.next;

        while (true) {
            if (temp == null) {
                break;
            }
            //不是最后一个节点，一直下移
            System.out.println(temp);
            temp = temp.next;
        }
    }


    //面试 反转链表
    public SingleLinkedList reverseList(SingleLinkedList list) {
        //如果当前链表为空，或者只有一个节点，无需反转，直接返回
        if (list.head.next == null || list.head.next.next == null) {
            return null;
        }
        PersonNode reverseHead = new PersonNode();
        //辅助节点
        PersonNode temp = list.head.next; //
        PersonNode p = null;

        //遍历原来的链表，每遍历一个节点，就将其取出，并放在新的链表reverseHead 的最前端
        while (temp != null) {
            //保存当前节点的下一个节点
            p = temp.next;
            temp.next = reverseHead.next;
            reverseHead.next = temp;
            //让temp后移
            temp = p;
        }
        list.head = reverseHead;
        return list;
    }

    //求单链表中有效节点的个数
    public int getSize() {
        //链表为空 返回0
        if (head.next == null) {
            return 0;
        }

        PersonNode t = head.next;
        //计数
        int count = 0;
        while (t != null) {
            count++;
            t = t.next;
        }
        return count;
    }

    //查找单链表中的倒数第k个结点
    public PersonNode reverseNode(int reverseNo) {
        //链表为空 reverseNo不正确 返回null
        if (head.next == null || reverseNo <= 0 || reverseNo > getSize()) {
            return null;
        }

        //总数
        int count = getSize();
        PersonNode t = head.next;
        for (int i = 0; i < count - reverseNo; i++) {
            t = t.next;
        }
        return t;
    }

    //从尾到头打印单链表 Stack栈
    public void reversePrint() {
        //链表为空
        if (head.next == null) {
            return;
        }

        //使用 栈 先进后出的特点 反向打印
        Stack<PersonNode> nodes = new Stack<>();
        //辅助节点
        PersonNode t = head.next;

        while (t != null) {
            nodes.push(t);
            t = t.next;
        }

        while (nodes.size() > 0) {
            System.out.println(nodes.pop());
        }
    }

    //合并两个有序的单链表，合并之后的链表依然有序
    public SingleLinkedList merge(SingleLinkedList list1, SingleLinkedList list2) {
        if (list1.head.next == null) {
            return list2;
        } else if (list2.head.next == null) {
            return list1;
        }

        PersonNode newNode = new PersonNode();
        PersonNode n1 = newNode;
        PersonNode l1 = list1.head.next;
        PersonNode l2 = list2.head.next;

        while (l1 != null && l2 != null) {
            if (l1.no < l2.no) {
                n1.next = l1;
                l1 = l1.next;
                n1 = n1.next;
            } else {
                n1.next = l2;
                l2 = l2.next;
                n1 = n1.next;
            }
        }

        if (l1 == null) {
            n1.next = l2;
        }
        if (l2 == null) {
            n1.next = l1;
        }
        return new SingleLinkedList(newNode);
    }


}

class PersonNode {
    int no;
    String name;
    PersonNode next;

    public PersonNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public PersonNode() {
    }


    @Override
    public String toString() {
        return "PersonNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }
}
