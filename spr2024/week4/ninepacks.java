package spr2024.week4;

/*
If it’s not possible to purchase an equal number of one or more hotdogs and buns,
just output “impossible”. Otherwise, output the smallest number of total packs
you can buy (counting both hotdog and bun packs) to get exactly the same number of hotdogs and buns.


Start with 1 dimensional problem
h1, h2, ...hn packages
h1 could have 10 dogs, h2 could have 20 dogs, h3 could have 5 dogs, etc.


Best way to buy exactly m hotdogs(NOT PACKS) using h1, ..., hn

we come up with some function f(m, n) where f finds optimal sln if it exists

f(m, n) where m is # of hotdogs we want to buy and n is the # of packs we have available


Base cases:
f(0, n) = 0. If m = 0, answer is 0, cause we can not use any packs to get 0 hotdogs
f(m, 0) = infinity/ impossible. If n is 0(we have no packs), therefore there is no way to get m hotdogs


but for any arbitrary m and n within bounds(m is not 0 and n is not 0)

f(m, n) = min(f(m, n-1), f(m-hn, n-1)+1)
 */

import java.util.Scanner;
import java.util.Arrays;

public class ninepacks {

    static final int MAX = 1000 * 100 + 1;
    static int[][] best_h = new int[MAX][101];
    static int[][] best_b = new int[MAX][101];

    static int solve(int target, int N, int[] A, int[][] best) {
        if (target == 0) return 0;
        if (target < 0 || N == 0) return MAX;
        if (best[target][N] != -1) return best[target][N];

        int ans1 = solve(target, N - 1, A, best);
        int ans2 = solve(target - A[N - 1], N - 1, A, best) + 1;
        best[target][N] = Math.min(ans1, ans2);
        return best[target][N];
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N;
        int[] H = new int[100];
        int[] B = new int[100];

        // Read hotdog pack sizes
        N = input.nextInt();
        for (int i = 0; i < N; i++) {
            H[i] = input.nextInt();
        }

        // Read bun pack sizes
        N = input.nextInt();
        for (int i = 0; i < N; i++) {
            B[i] = input.nextInt();
        }

        // Initialize the best arrays with -1
        for (int[] row : best_h)
            Arrays.fill(row, -1);
        for (int[] row : best_b)
            Arrays.fill(row, -1);

        int ans = MAX;
        for (int i = 1; i < MAX; i++) {
            int hotdog = solve(i, H.length, H, best_h);
            int bun = solve(i, B.length, B, best_b);
            if (hotdog < MAX && bun < MAX) {
                ans = Math.min(ans, hotdog + bun);
            }
        }

        if (ans == MAX) {
            System.out.println("impossible");
        } else {
            System.out.println(ans);
        }
    }
}
