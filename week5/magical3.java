package week5;

import java.util.Scanner;

public class magical3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while(input.hasNextLong()) {
            boolean found = false;
            long in = input.nextLong();
            if(in == 0) {
                break;
            }
            if(in < 3){
                System.out.println("No such base");
                continue;
            }
            if(in == 3){
                System.out.println(4);
                continue;
            }

            long cValue = in - 3;
            long smallestBase = getSmallestBase(cValue);

            if (smallestBase == -1) {
                System.out.println("No such base");
                continue;
            }
            System.out.println(smallestBase);
            
        }
    }

    public static Long getSmallestBase(long n) {
        long base = -1;
        for(long i = 1; i <= Math.sqrt(n); i++){
            if((n%i == 0) && ((n+3)%i == 3)){ //last digit is 3
                if((base == -1) || (base > i)){
                    base = i;
                }
            }
            if((i != n/i) && ((n+3)%(n/i) == 3)){ //last digit is 3
                if((base == -1) || (base > n/i)){
                    base = n/i;
                }
            }
        }
        return base;
    }
}