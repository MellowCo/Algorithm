package queue;

import java.util.Scanner;

/**
 * @Description: 循环数组队列
 * @Author: li
 * @Create: 2020-01-29 13:28
 */
public class CircularArrayQueueDemo {
    public static void main(String[] args) {
        //创建一个3的队列
        CircularArrayQueue queue = new CircularArrayQueue(5);

        Scanner scanner = new Scanner(System.in);
        //接收用户输入
        char key = ' ';
        boolean flag = true;

        while (flag) {
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

class CircularArrayQueue {

    private int maxSize; //最大容量
    private int front; //队列头
    private int rear; //队列尾
    private int[] arr;

    public CircularArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        front = rear = 0; //初始化，front，rear为0
        //rear 变量的含义做一个调整：rear 指向队列的最后一个元素的后一个位置. 因为希望空出一个空间做为约定.
        //front 变量的含义做一个调整： front 就指向队列的第一个元素, 也就是说 arr[front] 就是队列的第一个元素
        arr = new int[maxSize];
    }

    //判断队满
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    //判断队空
    public boolean isEmpty() {
        return rear == front;
    }

    //添加
    public void addQueue(int data) {
        if (isFull()) {
            System.out.println("队列满了");
        } else {
            //rear 后移一位，添加数据
            arr[rear] = data;
            rear = (rear + 1) % maxSize;
        }
    }

    //出队
    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        } else {
            //先保存数据，front后移一位
            int data = arr[front];
            front = (front + 1) % maxSize;
            return data;
        }
    }

    //有效数据的个数
    public int dataSize() {
        return (rear - front + maxSize) % maxSize;
    }

    //遍历有效数据
    public void show() {
        if (isEmpty()) {
            System.out.println("队列为空");
        } else {
            for (int i = front; i != rear; i = (i + 1) % maxSize) {
                System.out.println(arr[i]);
            }
        }
    }

    //显示队列头数据
    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        } else {
            return arr[front];
        }
    }


}
