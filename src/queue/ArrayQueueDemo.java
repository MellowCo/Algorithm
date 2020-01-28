package queue;

import java.util.Scanner;

/**
 * @Description: 数组队列
 * @Author: li
 * @Create: 2020-01-28 20:54
 */
public class ArrayQueueDemo {
    public static void main(String[] args) {
        //创建一个3的队列
        ArrayQueue queue = new ArrayQueue(3);

        Scanner scanner = new Scanner(System.in);
        //接收用户输入
        char key = ' ';
        boolean flag = true;

        while (flag){
            System.out.println("s(show): 显示队列");
            System.out.println("e(exit): 退出程序");
            System.out.println("a(add): 添加数据到队列");
            System.out.println("g(get): 从队列取出数据");
            System.out.println("h(head): 查看队列头的数据");
            //接收字符
            key = scanner.next().charAt(0);

            switch (key) {
                case 's':
                    queue.show();
                    break;
                case 'a':
                    System.out.println("输出一个数");
                    int value = scanner.nextInt();
                    queue.addQueue(value);
                    break;
                case 'g': //取出数据
                    try {
                        int res = queue.getQueue();
                        System.out.printf("取出的数据是%d\n", res);
                    } catch (Exception e) {
                        // TODO: handle exception
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h': //查看队列头的数据
                    try {
                        int res = queue.headQueue();
                        System.out.printf("队列头的数据是%d\n", res);
                    } catch (Exception e) {
                        // TODO: handle exception
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e': //退出
                    scanner.close();
                    flag = false;
                    break;
                default:
                    break;
            }
        }
    }
}

class ArrayQueue{
    private int maxSize; //队列最大容量
    private int front; //队列头
    private int rear; //队列尾
    private int[] arr; //队列的数组


    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
        //初始化 front = rear = -1
        front = -1; // 指向队列头部，分析出front是指向队列头的前一个位置.
        rear = -1; // 指向队列尾，指向队列尾的数据(即就是队列最后一个数据)
    }

    //队列是否满
    public boolean isFull(){
        return rear == maxSize-1;
    }

    //队列是否满
    public boolean isEmpty(){
        return rear == front;
    }

    //添加数据
    public void addQueue(int data) {
        if (isFull()) {
            System.out.println("队列满");
        }else{
            arr[++rear] = data;
        }
    }

    //取出数据
    public int getQueue(){
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }else{
            return arr[++front];
        }
    }

    //显示队列头数据
    public int headQueue(){
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }else{
            return arr[front+1];
        }
    }

    //显示所有数据
    public void show(){
        if (isEmpty()) {
            System.out.println("队列空");
        }else{
            for (int i : arr) {
                System.out.println(i);
            }
        }
    }
}