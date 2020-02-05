package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description: 图
 * @Author: li
 * @Create: 2020-02-05 15:05
 */
public class Graph {
    //保存节点值
    List<String> vertexList;
    //节点矩阵
    int[][] edges;

    //n 节点的个数
    public Graph(int n) {
        edges = new int[n][n];
        vertexList = new ArrayList<>();
    }

    public void add(String vertex){
        vertexList.add(vertex);
    }

    /**
     * 添加边的节点矩阵
     * @param x
     * @param y
     * @param weight 权值  1 表示能够直接连 0 表示不能直接连接
     * @Return void
     */
    public void insertEdge(int x, int y, int weight) {
        edges[x][y] = weight;
    }

    public void showEdge() {
        for (int[] edge : edges) {
            System.out.println(Arrays.toString(edge));
        }
    }

    public static void main(String[] args) {
        //结点的个数
        int n = 5;
        String vertexs[] = {"A", "B", "C", "D", "E"};
        Graph graph = new Graph(n);

        for (String vertex : vertexs) {
            graph.add(vertex);
        }

        //添加边
        //A-B A-C B-C B-D B-E
		graph.insertEdge(0, 1, 1); // A-B
		graph.insertEdge(0, 2, 1); //
		graph.insertEdge(1, 0, 1); //
		graph.insertEdge(1, 0, 1); //
		graph.insertEdge(1, 2, 1); //
		graph.insertEdge(1, 3, 1); //
		graph.insertEdge(1, 4, 1); //
		graph.insertEdge(2, 0, 1); //
		graph.insertEdge(2, 1, 1); //
		graph.insertEdge(3, 1, 1); //
		graph.insertEdge(4, 1, 1); //

        graph.showEdge();


    }

}
