package rmc2017;

import java.util.Scanner;

public class heartrate {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int N = input.nextInt();

        for(int i = 0; i < N; i++){
            int b = input.nextInt();
            double p = input.nextDouble();

            double beats = (60*b)/ p;

            double deviance = 60/p;

            System.out.printf("%6.4f %6.4f %6.4f %n", beats-deviance, beats, beats+deviance);
        }
    }
}
