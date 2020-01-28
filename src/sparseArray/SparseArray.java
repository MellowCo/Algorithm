package sparseArray;

/**
 * @Description: 稀疏数组
 * @Author: li
 * @Create: 2020-01-28 19:41
 */
public class SparseArray {

    public static void main(String[] args) {
        //原始数组
        int arr[][] = new int[11][11];
        //默认为0
        arr[1][2] = 1;
        arr[2][3] = 2;
        arr[3][5] =1;

        //打印原始数组
        System.out.println("原始数组");
        for (int[] row : arr) {
            for (int i : row) {
                System.out.printf("%d\t", i);
            }
            System.out.println("");
        }


        /*
         * 遍历arr
         * sum 记录原始数组中的有效数据
         */
        int sum = 0;
        for (int[] row : arr) {
            for (int i : row) {
                if (i != 0) {
                    sum++;
                }
            }
        }

        //创建稀疏数组
        int sparseArr[][] = new int[sum + 1][3];
        System.out.printf("有效数据有%d个\n", sum);
        /*
         * 第一行
         * arr的行数
         * arr的列数
         * 有效数据
         */
        sparseArr[0][0] = 11;
        sparseArr[0][1] = 11;
        sparseArr[0][2] = 2;
        /*
         * 将有效数据 写入 稀疏数组
         */
        int count = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (arr[i][j] != 0) {
                      count++;
                      sparseArr[count][0]=i;
                      sparseArr[count][1]=j;
                      sparseArr[count][2]=arr[i][j];
                }
            }
        }

        //打印稀疏数组
        System.out.println("稀疏数组");
        for (int[] row : sparseArr) {
            for (int i : row) {
                System.out.printf("%d\t", i);
            }
            System.out.println("");
        }

          /*
          * 将稀疏数组转化成原始数组
          * 1 获取第一行的值 创建对应大小的原始数组
          * 2 获取下几行的值 填入到对应坐标的位置
          */
        int arr2[][] = new int[sparseArr[0][0]][sparseArr[0][1]];
        for (int i = 1; i < sparseArr.length; i++) {
            arr2[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }

        //打印新的原始数组
        System.out.println("新的原始数组");
        for (int[] row : arr2) {
            for (int i : row) {
                System.out.printf("%d\t", i);
            }
            System.out.println("");
        }


    }
}
