package linkedlist;

/**
 * @Description: 双向链表
 * @Author: li
 * @Create: 2020-01-30 14:11
 */
public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        DPersonNode node1 = new DPersonNode(1, "li");
        DPersonNode node2 = new DPersonNode(2, "wang");
        DPersonNode node3 = new DPersonNode(3, "zhao");
        DPersonNode node4 = new DPersonNode(4, "zhao1");
        DPersonNode node5 = new DPersonNode(5, "zhao2");
        DPersonNode node6 = new DPersonNode(6, "zhao26");
        DPersonNode node7 = new DPersonNode(7, "zhao2677");
        DPersonNode node8 = new DPersonNode(8, "zhao2688");

        DoubleLinkedList list = new DoubleLinkedList();
        //添加
        list.add(node1);
        list.add(node2);
        list.add(node3);
        list.add(node4);
        list.add(node5);
        list.add(node6);
        list.add(node7);
        list.add(node8);

        //遍历
        list.show();
        System.out.println("=============================");

        //修改
        DPersonNode node9 = new DPersonNode(1, "li99999999");
        list.update(node9);
        list.show();
        System.out.println("======================");

        //删除
        list.del(1000);
        list.del(1);
        list.del(5);
        list.del(8);
        list.del(7);
        list.show();
    }
}

class DoubleLinkedList{
    DPersonNode head = new DPersonNode();

    //判断空链表
    public boolean isEmpty(){
        if (head.next == null){
            return true;
        }
        return false;
    }

    // 遍历双向链表的方法
    // 显示链表[遍历]
    public void show(){
        if (isEmpty()){
            System.out.println("空链表");
            return;
        }

        //辅助节点
        DPersonNode temp = head.next;

        while (temp != null){
            System.out.println(temp);
            temp = temp.next;
        }
    }

    // 添加一个节点到双向链表的最后.
    public void add(DPersonNode node){
        //辅助节点
        DPersonNode temp = head;
        while (temp.next != null){
            //找到最后的节点
            temp = temp.next;
        }

        temp.next = node;
        node.pre = temp;
    }

    // 根据no 修改信息
    public void update(DPersonNode node){
        if (isEmpty()){
            System.out.println("空链表");
            return;
        }

        //可能不存在no
        boolean flag = false;
        DPersonNode temp = head.next;

        while (temp != null){
            //找到no的节点
            if (temp.no == node.no){
                flag = true;
                break;
            }
        }

        if (flag){
           temp.name = node.name;
        }else{
            System.out.println("编号不存在");
        }
    }

    // 根据no删除节点
    // 说明
    // 1 对于双向链表，我们可以直接找到要删除的这个节点
    // 2 找到后，自我删除即可
    public void del(int no){
        if (isEmpty()){
            System.out.println("空链表");
            return;
        }

        //辅助节点
        DPersonNode temp = head.next;
        boolean flag = false;

        while (temp != null){
            if (temp.no == no){
                //找到删除的节点
                flag = true;
                break;
            }
            temp = temp.next;
        }
        
        if (flag){
            temp.pre.next = temp.next;

            //如果删的是最后一个节点 temp.next==null
            //出现空指针
            if (temp.next != null){
                temp.next.pre = temp.pre;
            }
        }else{
            System.out.println("编号不存在");
        }

    }

}

class DPersonNode{
    int no;
    String name;
    DPersonNode pre;
    DPersonNode next;

    public DPersonNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public DPersonNode() {
    }

    @Override
    public String toString() {
        return "DPersonNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }
}