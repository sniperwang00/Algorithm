package com.luke.algorithm.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Graph {

    private ArrayList<String> vertexList; //存储顶点的集合

    private int[][] edges; // 邻接矩阵

    private int numOfEdges; // 边的个数

    private boolean[] isVisited;

    public static void main(String[] args) {
        int n = 5;
        String vertexes[] = {"A", "B", "C", "D", "E"};

        Graph graph = new Graph(n);
        for (String vertex : vertexes) {
            graph.insertVertex(vertex);
        }

        graph.insertEdge(0, 1, 1);
        graph.insertEdge(0, 2, 1);
        graph.insertEdge(1, 2, 1);
        graph.insertEdge(1, 3, 1);
        graph.insertEdge(1, 4, 1);

        graph.showGraph();
//        graph.dfsSearch();
        graph.bfsSearch();
    }

    public Graph(int n) {
        edges = new int[n][n];
        vertexList = new ArrayList<>(n);
        numOfEdges = 0;
        isVisited = new boolean[n];
    }

    /**
     * 插入结点
     * @param vertex
     */
    public void insertVertex(String vertex) {
        vertexList.add(vertex);
    }

    /**
     * 插入边
     * @param v1 第一个结点
     * @param v2 第二个结点
     * @param weight 边的权值
     */
    public void insertEdge(int v1, int v2, int weight) {
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        numOfEdges+=1;
    }

    //返回顶点数目
    public int getNumOfVertex() {
        return vertexList.size();
    }

    //返回边的数目
    public int getNumOfEdges() {
        return numOfEdges;
    }

    //返回结点
    public String getValueByIndex(int i) {
        return vertexList.get(i);
    }

    //返回边的权值
    public int getWeight(int v1, int v2) {
        return edges[v1][v2];
    }

    //打印矩阵
    public void showGraph() {
        for (int[] edge : edges) {
            System.out.println(Arrays.toString(edge));
        }
    }

    //返回结点v的第一个邻接结点
    public int getFirstNeighbor(int index) {
        for (int j = 0; j < vertexList.size(); j++) {
            if (edges[index][j] > 0) {
                return j;
            }
        }
        return -1;
    }

    //返回前一个邻接结点的下一个邻接结点
    public int getNextNeighbor(int index, int v2) {
        for (int j = v2; j < vertexList.size(); j++) {
            if (edges[index][j] > 1) {
                return j;
            }
        }
        return -1;
    }

    //递归
    public void dfsSearch(boolean[] isVisited, int i) {
        System.out.print(getValueByIndex(i) + "->");
        isVisited[i] = true;

        int w = getFirstNeighbor(i);
        while (w != -1) {
            if (isVisited[w] == false) {
                dfsSearch(isVisited, w);
            }
            w = getNextNeighbor(i, w);
        }
    }

    //回溯
    public void dfsSearch() {
        for (int i = 0; i < getNumOfVertex(); i++) {
            if (!isVisited[i]) {
                dfsSearch(isVisited, i);
            }
        }
    }

    public void bfsSearch(boolean[] isVisited, int i) {
        int u;
        int w;
        System.out.print(getValueByIndex(i) + "->");
        isVisited[i] = true;
        LinkedList queue = new LinkedList();
        queue.addLast(i);
        while (!queue.isEmpty()) {
            u = (int) queue.removeFirst();
            w = getFirstNeighbor(u);
            if (w != -1) {
                if (isVisited[w] == false) {
                    System.out.print(getValueByIndex(w) + "->");
                    queue.addLast(w);
                    isVisited[w] = true;
                }
                w = getNextNeighbor(u, w);
            }
        }
    }

    public void bfsSearch() {
        for (int i = 0; i < getNumOfVertex(); i++) {
            if(!isVisited[i]){
                bfsSearch(isVisited, i);
            }
        }
    }
}

