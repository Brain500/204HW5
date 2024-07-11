package ui;

import divideandconquer.*;
import greedy.*;
import utils.Timer;

import java.util.Scanner;
import java.util.List;

public class ConsoleUI {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Timer timer = new Timer();
        int choice;

        do {
            System.out.println("Select an algorithm to test:");
            System.out.println("1. QuickSort");
            System.out.println("2. MergeSort");
            System.out.println("3. Closest Pair Problem");
            System.out.println("4. Strassen’s Matrix Multiplication");
            System.out.println("5. Quickhull");
            System.out.println("6. Prim’s MST");
            System.out.println("7. Traveling Salesman Problem (TSP)");
            System.out.println("8. Kruskal’s MST");
            System.out.println("9. Dijkstra’s Shortest Path");
            System.out.println("10. Huffman Codes");
            System.out.println("11. Exit");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter the number of elements in the array:");
                    int n1 = scanner.nextInt();
                    int[] arr1 = new int[n1];
                    System.out.println("Enter the elements of the array:");
                    for (int i = 0; i < n1; i++) {
                        arr1[i] = scanner.nextInt();
                    }
                    QuickSort quickSort = new QuickSort();
                    timer.start();
                    quickSort.sort(arr1);
                    timer.stop();
                    System.out.println("Sorted array:");
                    for (int i : arr1) {
                        System.out.print(i + " ");
                    }
                    System.out.println("\nTime taken: " + timer.getElapsedTime() + " ms");
                    break;

                case 2:
                    System.out.println("Enter the number of elements in the array:");
                    int n2 = scanner.nextInt();
                    int[] arr2 = new int[n2];
                    System.out.println("Enter the elements of the array:");
                    for (int i = 0; i < n2; i++) {
                        arr2[i] = scanner.nextInt();
                    }
                    MergeSort mergeSort = new MergeSort();
                    timer.start();
                    mergeSort.sort(arr2);
                    timer.stop();
                    System.out.println("Sorted array:");
                    for (int i : arr2) {
                        System.out.print(i + " ");
                    }
                    System.out.println("\nTime taken: " + timer.getElapsedTime() + " ms");
                    break;

                case 3:
                    System.out.println("Enter the number of points:");
                    int n3 = scanner.nextInt();
                    ClosestPair.Point[] points = new ClosestPair.Point[n3];
                    System.out.println("Enter the points (x y):");
                    for (int i = 0; i < n3; i++) {
                        double x = scanner.nextDouble();
                        double y = scanner.nextDouble();
                        points[i] = new ClosestPair().new Point(x, y);
                    }
                    ClosestPair closestPair = new ClosestPair();
                    timer.start();
                    double minDist = closestPair.closestPair(points);
                    timer.stop();
                    System.out.println("Minimum distance: " + minDist);
                    System.out.println("Time taken: " + timer.getElapsedTime() + " ms");
                    break;

                case 4:
                    System.out.println("Enter the dimension of the matrices (n for nxn):");
                    int n4 = scanner.nextInt();
                    int[][] A = new int[n4][n4];
                    int[][] B = new int[n4][n4];
                    System.out.println("Enter the elements of matrix A:");
                    for (int i = 0; i < n4; i++) {
                        for (int j = 0; j < n4; j++) {
                            A[i][j] = scanner.nextInt();
                        }
                    }
                    System.out.println("Enter the elements of matrix B:");
                    for (int i = 0; i < n4; i++) {
                        for (int j = 0; j < n4; j++) {
                            B[i][j] = scanner.nextInt();
                        }
                    }
                    StrassenMatrixMultiplication strassen = new StrassenMatrixMultiplication();
                    timer.start();
                    int[][] C = strassen.multiply(A, B);
                    timer.stop();
                    System.out.println("Resultant matrix:");
                    for (int i = 0; i < n4; i++) {
                        for (int j = 0; j < n4; j++) {
                            System.out.print(C[i][j] + " ");
                        }
                        System.out.println();
                    }
                    System.out.println("Time taken: " + timer.getElapsedTime() + " ms");
                    break;

                case 5:
                    System.out.println("Enter the number of points:");
                    int n5 = scanner.nextInt();
                    Quickhull.Point[] pointsQH = new Quickhull.Point[n5];
                    System.out.println("Enter the points (x y):");
                    for (int i = 0; i < n5; i++) {
                        double x = scanner.nextDouble();
                        double y = scanner.nextDouble();
                        pointsQH[i] = new Quickhull().new Point(x, y);
                    }
                    Quickhull quickhull = new Quickhull();
                    timer.start();
                    List<Quickhull.Point> hull = quickhull.quickHull(pointsQH);
                    timer.stop();
                    System.out.println("Convex hull points:");
                    for (Quickhull.Point p : hull) {
                        System.out.println("(" + p.x + ", " + p.y + ")");
                    }
                    System.out.println("Time taken: " + timer.getElapsedTime() + " ms");
                    break;

                case 6:
                    System.out.println("Enter the number of vertices:");
                    int V6 = scanner.nextInt();
                    int[][] graph6 = new int[V6][V6];
                    System.out.println("Enter the adjacency matrix of the graph:");
                    for (int i = 0; i < V6; i++) {
                        for (int j = 0; j < V6; j++) {
                            graph6[i][j] = scanner.nextInt();
                        }
                    }
                    PrimMST primMST = new PrimMST();
                    timer.start();
                    primMST.primMST(graph6);
                    timer.stop();
                    System.out.println("Time taken: " + timer.getElapsedTime() + " ms");
                    break;

                case 7:
                    System.out.println("Enter the number of vertices:");
                    int V7 = scanner.nextInt();
                    int[][] graph7 = new int[V7][V7];
                    System.out.println("Enter the adjacency matrix of the graph:");
                    for (int i = 0; i < V7; i++) {
                        for (int j = 0; j < V7; j++) {
                            graph7[i][j] = scanner.nextInt();
                        }
                    }
                    TSP tsp = new TSP();
                    timer.start();
                    int minCost = tsp.tsp(graph7, 0);
                    timer.stop();
                    System.out.println("Minimum cost of TSP: " + minCost);
                    System.out.println("Time taken: " + timer.getElapsedTime() + " ms");
                    break;

                case 8:
                    System.out.println("Enter the number of vertices and edges:");
                    int V8 = scanner.nextInt();
                    int E8 = scanner.nextInt();
                    KruskalMST kruskalMST = new KruskalMST(V8, E8);
                    System.out.println("Enter the edges (src dest weight):");
                    for (int i = 0; i < E8; i++) {
                        kruskalMST.edge[i].src = scanner.nextInt();
                        kruskalMST.edge[i].dest = scanner.nextInt();
                        kruskalMST.edge[i].weight = scanner.nextInt();
                    }
                    timer.start();
                    kruskalMST.kruskalMST();
                    timer.stop();
                    System.out.println("Time taken: " + timer.getElapsedTime() + " ms");
                    break;

                case 9:
                    System.out.println("Enter the number of vertices:");
                    int V9 = scanner.nextInt();
                    int[][] graph9 = new int[V9][V9];
                    System.out.println("Enter the adjacency matrix of the graph:");
                    for (int i = 0; i < V9; i++) {
                        for (int j = 0; j < V9; j++) {
                            graph9[i][j] = scanner.nextInt();
                        }
                    }
                    Dijkstra dijkstra = new Dijkstra();
                    timer.start();
                    dijkstra.dijkstra(graph9, 0);
                    timer.stop();
                    System.out.println("Time taken: " + timer.getElapsedTime() + " ms");
                    break;

                case 10:
                    System.out.println("Enter the number of characters:");
                    int n10 = scanner.nextInt();
                    char[] charArray = new char[n10];
                    int[] charFreq = new int[n10];
                    System.out.println("Enter the characters and their frequencies:");
                    for (int i = 0; i < n10; i++) {
                        charArray[i] = scanner.next().charAt(0);
                        charFreq[i] = scanner.nextInt();
                    }
                    Huffman huffman = new Huffman();
                    timer.start();
                    huffman.huffman(charArray, charFreq);
                    timer.stop();
                    System.out.println("Time taken: " + timer.getElapsedTime() + " ms");
                    break;

                case 11:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice. Please select a valid algorithm.");
            }
        } while (choice != 11);

        scanner.close();
    }
}
