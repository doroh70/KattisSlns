package March22nd2024;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class pencilcrayons {
    public static void main(String[] args){
        //read N, read K

        //initialize toBeRemoved

        //loop N times
            //read line
            //when a repeat is found in a line ++tobeRemoved

        Scanner input = new Scanner(System.in);

        int N; int K;

        String[] params = input.nextLine().split(" ");

        N = Integer.parseInt(params[0]);
        K = Integer.parseInt(params[1]);

        int toBeRemoved = 0;


        for(int i = 0; i < N; i++) {
            String[] lineColors = input.nextLine().split(" ");
            HashSet<String> unique = new HashSet<>(Arrays.asList(lineColors));

            toBeRemoved = toBeRemoved + (lineColors.length - unique.size());
        }

        System.out.println(toBeRemoved);
    }
}
