package hash;

/**
 * @Description: 哈希表
 * @Author: li
 * @Create: 2020-02-02 17:07
 */
public class HashTabDemo {
    public static void main(String[] args) {
        Emp e1 = new Emp(1, "li");
        Emp e2 = new Emp(2, "li1");
        Emp e3 = new Emp(3, "li3");
        Emp e4 = new Emp(4, "li4");
        Emp e5 = new Emp(5, "li5");

        HashTab tab = new HashTab(3);
        tab.add(e1);
        tab.add(e2);
        tab.add(e3);
        tab.add(e4);
        tab.add(e5);
        System.out.println("遍历===============");
        tab.list();

        System.out.println("查找===============");
        tab.findById(4);
        tab.findById(9);

        System.out.println("删除========");
        tab.del(1);
        tab.del(9);
        tab.del(4);
        tab.list();
    }
}

class HashTab {
    private int size;
    private EmpLinkedList[] lists;

    public HashTab(int size) {
        this.size = size;
        lists = new EmpLinkedList[size];
    }

    //算出下标
    public int hashFun(int id) {
        return id % size;
    }

    //添加
    public void add(Emp emp) {
        //找到hash表中的下标
        int index = hashFun(emp.getId());
        if (lists[index] == null) {
            lists[index] = new EmpLinkedList();
        }
        lists[index].add(emp);
    }

    //遍历
    public void list() {
        for (int i = 0; i < size; i++) {
            if (lists[i] != null) {
                lists[i].list();
                System.out.println();
            }
        }
    }

    //根据id查找
    public void findById(int id){
        int index = hashFun(id);

        //lists[index]==null 这个位置没有被使用
        if (lists[index] == null){
            System.out.println("空 id 不存在");
            return;
        }

        //辅助节点
        Emp curEmp = lists[index].getHead();

        while (curEmp != null) {
            //遍历查找id
            if (curEmp.getId() == id){
                System.out.println(curEmp);
                return;
            }
            curEmp = curEmp.getNext();
        }

        System.out.println("id 不存在");
    }

    //根据id删除
    public void del(int id){
        int index = hashFun(id);

        //lists[index]==null 这个位置没有被使用
        if (lists[index] == null){
            System.out.println("空 id 不存在");
            return;
        }

        //辅助节点
        Emp curEmp = lists[index].getHead();


        //如果head.id == id
        //将头指针后移
        if (curEmp.getId() == id) {
            lists[index].setHead(curEmp.getNext());
            return;
        }

        while (curEmp.getNext() != null) {
            //遍历查找id 删除
            if (curEmp.getNext().getId() == id){
                curEmp.setNext(curEmp.getNext().getNext());
                return;
            }
            curEmp = curEmp.getNext();
        }
        System.out.println("id 不存在");
    }

}


class EmpLinkedList {
    //头指针
    private Emp head;

    public Emp getHead() {
        return head;
    }

    public void setHead(Emp head) {
        this.head = head;
    }

    public void add(Emp emp) {
        //插入第一条数据 head为null
        if (head == null) {
            head = emp;
            return;
        }
        //辅助节点
        Emp curEmp = head;

        //找到最后一个节点
        while (curEmp.getNext() != null) {
            curEmp = curEmp.getNext();
        }

        curEmp.setNext(emp);
    }

    public void list() {
        if (head == null) {
            System.out.println("链表为空");
            return;
        }

        //辅助节点
        Emp curEmp = head;

        while (curEmp != null) {
            System.out.print(curEmp + "-->");
            curEmp = curEmp.getNext();
        }
    }
}

class Emp {
    private int id;
    private String name;
    private Emp next;

    public Emp(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Emp getNext() {
        return next;
    }

    public void setNext(Emp next) {
        this.next = next;
    }
}