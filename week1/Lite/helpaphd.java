import java.util.Scanner;

public class helpaphd {
    public static void main(String[] args){
        //read first line of input, n
        //loop n times
            //if input equals P=NP, skip
            //else add the 2 ints
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        for(int i = 0; i < n; i++){
            String input = scanner.nextLine();
            if (input.equals("P=NP")){
                //print skipped
                System.out.println("skipped");
            }
            else{
                //add the 2 ints and print their value
                //tokenize string with + delimeter
                String[] ab = input.split("\\+");
                int a = Integer.parseInt(ab[0]);
                int b = Integer.parseInt(ab[1]);
                System.out.println(a+b);
            }
        }
    }
}
