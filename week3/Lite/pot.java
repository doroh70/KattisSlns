package week3.Lite;

import java.util.Scanner;

public class pot {

    public static void main(String[] args) {

        //read # of input N
        //declare double sum
        //loop N times
            //calculate double for each line

        Scanner input = new Scanner(System.in);

        int N = Integer.parseInt(input.nextLine());

        long sum = 0;

        for(int i = 0; i < N; i++){
            int number = Integer.parseInt(input.nextLine());

            int base = number/ 10;
            int pow = number % 10;

            double result = Math.pow(base, pow);
            sum += result;
        }

        System.out.println(sum);
    }

}
