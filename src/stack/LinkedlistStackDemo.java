package stack;

/**
 * @Description: 使用链表实现栈
 * @Author: li
 * @Create: 2020-01-30 18:14
 */
public class LinkedlistStackDemo {
    public static void main(String[] args) {
        LinkedlistStack stack = new LinkedlistStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        System.out.println("================");
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}



class LinkedlistStack{
    private List top = new List();

    //栈空
    public boolean isEmpty(){
        if (top.next == null){
            return true;
        }

        return false;
    }
    
    //入栈
    public void push(int data){
        //辅助节点
        List temp = top.next;
        //创建一个新的节点
        List node = new List(data);

        top.next = node;
        node.next = temp;
    }
    
    //出栈
    public int pop(){
        if (isEmpty()){
            throw new RuntimeException("栈空");
        }
        
        //取出数据
        int value = top.next.data;
        //删除节点
        top.next = top.next.next;
        return value;
    }

}

class List{
    int data;
    List next;

    public List(int data) {
        this.data = data;
    }

    public List() {
    }

    @Override
    public String toString() {
        return "List{" +
                "data=" + data +
                '}';
    }
}
