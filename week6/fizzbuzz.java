package week6;

import java.util.Scanner;

public class fizzbuzz {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int X, Y, N;
        X = input.nextInt();
        Y = input.nextInt();
        N = input.nextInt();

        //loop from 1 to N
        //if divisible by X and Y, print FizzBuzz
        //else if divisible by X with Fizz
        //else if divisible by Y with Buzz
        //else print i

        for(int i = 1; i <= N; i++) {
            if((i%X) == 0 && (i%Y) == 0 ){
                System.out.println("FizzBuzz");
            }
            else if ((i%X) == 0 ){
                System.out.println("Fizz");
            }
            else if ((i%Y) == 0 ){
                System.out.println("Buzz");
            }
            else{
                System.out.println(i);
            }
        }
    }
}