package NAQ;

import java.util.Arrays;
import java.util.Scanner;

public class naq23_linesperhour {

    public static void main(String[] args) {
        //read # of candidate problems n
        //read max lines of code per hour lph

        //max loc = 5 * lph

        //loop through n times and store values in Array
        //sort array ascending
        //while index - loc >0
            //subtract

        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int lph = input.nextInt();

        input.nextLine();

        int max = 5 * lph;

        int[] problems = new int[n];

        for(int i = 0; i < n; i++){
            int temp = Integer.parseInt(input.nextLine());
            problems[i] = temp;
        }
        //array is sorted
        Arrays.sort(problems);

        int total = 0;
        for(int j = 0; j < n; j++){
            max -= problems[j];
            if(max >= 0){
                total++;
            }
        }
        System.out.println(total);

    }
}
