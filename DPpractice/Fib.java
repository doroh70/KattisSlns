package DPpractice;

import java.util.Arrays;
import java.util.Scanner;

public class Fib {

    //Memoization approach
    //Fib(n) = Fib(n-1) + Fib(n-2);


    //FibJustRecurse
    static int Fib(int n) {
        if(n == 0) {
            return 0;
        }
        if(n == 1) {
            return 1;
        }
        return Fib(n-1) + Fib(n-2);

    }

    //FibMemoized
    static int[] A = new int[1000];
    static {
        A[0] = 0;
        A[1] = 1;
        Arrays.fill(A, 2, 1000, -1);
    }
    static int FibMemoized(int n) {
        if(A[n] >= 0) {
            return A[n];
        }
        A[n] = FibMemoized(n-1) + FibMemoized(n-2);
        return A[n];
    }

    //FibTabulation
    static int[] B = new int[1000];
    static {
        B[0] = 0;
        B[1] = 1;
    }
    static int FibTabulated(int n){
        for(int i = 2; i <= n; i++){
            B[i] = B[i-1] + B[i-2];
        }
        return B[n];
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int number = input.nextInt();

        System.out.println(Fib(number));
        System.out.println(FibMemoized(number));
        System.out.println(FibTabulated(number));
    }

}
