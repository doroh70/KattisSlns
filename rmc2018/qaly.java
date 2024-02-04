package rmc2018;

import java.util.Scanner;

public class qaly {
    public static void main(String[] args) {
        //read integer N
        //initialize sum to 0.0
        //loop N times
            //read q and y
            //multiply q and y
            //store multiplication in sum

        Scanner input = new Scanner(System.in);

        int N = Integer.parseInt(input.nextLine());
        double sum = 0.000;
        for(int i = 0; i < N; i++) {
            double q = input.nextDouble();
            double y = input.nextDouble();
            double result = q * y;
            sum += result;
        }

        System.out.println(sum);

    }
}
