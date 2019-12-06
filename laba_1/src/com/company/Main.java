package com.company;


import java.util.Random;

//Сформировать матрицу, состоящую из нулей и единиц, причем количество единиц строго равно количеству строк.

public class Main {

    public static void main(String[] args) {
	// write your code here
        Random random = new Random();

        int n = random.nextInt(25 + 1) + 1;
        int m = random.nextInt(25 + 1) + 1;

        System.out.println("Matrix:");

        int[][] matrix = new int[n][m];

        System.out.print(" ");

        for (int i = 0; i < n; i++) {
            System.out.print("[");

            int randome_one = random.nextInt(m);

            for (int j = 0; j < m; j++) {
                if (j == randome_one) {
                    matrix[i][j] = 1;
                }
                else {
                    matrix[i][j] = 0;
                }
                System.out.print(matrix[i][j]);
                if (j != m - 1) {
                    System.out.print(", ");
                }
            }

            System.out.print("]\n ");
        }
    }
}
