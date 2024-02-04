package week6;

import java.util.Scanner;

public class flowshop {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt(); // number of swathers
        int M = scanner.nextInt(); // number of stages

        int[][] times = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                times[i][j] = scanner.nextInt();
            }
        }

        int[] results = flowShopSchedule(N, M, times);
        for (int i = 0; i < N; i++) {
            System.out.print(results[i] + " ");
        }
    }

    public static int[] flowShopSchedule(int N, int M, int[][] times) {
        int[] end_time_stages = new int[M];
        int[] end_time_swathers = new int[N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (j == 0) {
                    end_time_stages[j] += times[i][j];
                } else {
                    end_time_stages[j] = Math.max(end_time_stages[j], end_time_stages[j - 1]) + times[i][j];
                }
                end_time_swathers[i] = end_time_stages[j];
            }
        }

        return end_time_swathers;
    }
}

