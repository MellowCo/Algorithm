package stack;

/**
 * @Description:
 * @Author: li
 * @Create: 2020-01-30 17:49
 */
public class ArrayStackDemo {
    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(5);
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
    }
}

class ArrayStack{
    //最大容量
    private int maxSize;
    //数组
    private int[] arr;
    //栈顶 初始化为-1
    private int top = -1;

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
    }

    //栈满
    public boolean isFull(){
        return top == maxSize-1;
    }

    //栈空
    public boolean isEmpty(){
        return top == -1;
    }

    //入栈
    public void push(int data){
        if (isFull()){
            System.out.println("栈满");
            return;
        }

        arr[++top] = data;
    }

    //出栈
    public int pop(){
        if (isEmpty()){
            throw new RuntimeException("栈空");
        }
        return arr[top--];
    }
}