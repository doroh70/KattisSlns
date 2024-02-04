import java.util.Scanner;

public class primaryarithmetic {

    public static void main(String[] args) {

        //Declare variables
        Scanner scanner = new Scanner(System.in);


        for(int i = 0; i < 50; i++){

            int num1 = scanner.nextInt();
            int num2 = scanner.nextInt();

            if(num1 == 0 && num2 == 0){
                return;
            }

            int carry = 0;
            int carryCount = 0;

            while( num1 > 0 || num2 > 0){

                int digit1 = num1%10;
                int digit2 = num2%10;

                if ( digit1 + digit2 + carry > 9){
                    carry = 1;
                    carryCount++;
                }
                else{
                    carry = 0;
                }
                num1 = num1/10;
                num2 = num2/10;
            }

            if (carryCount == 0) {
                System.out.println("No carry operation.");
            }
            else if(carryCount == 1) {
                System.out.println("1 carry operation.");
            }
            else{
                System.out.printf("%d%s%n", carryCount, " carry operations.");
            }
        }

    }
}
