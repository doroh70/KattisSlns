package week3.Lite;

import java.util.Arrays;
import java.util.Scanner;

public class permutedarithmeticsequence {
    //read n
    //loop n times
        //read m
            //read m longs
            //store in vector
            //sort vector
            //check if arithmetic sequence

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int n = Integer.parseInt(input.nextLine());

        for(int i = 0; i < n; i++){
            String[] line = input.nextLine().split(" ");
            int m = Integer.parseInt(line[0]);
            long[] unsorted = new long[m];
            for(int j = 1; j<m+1; j++ ){
                unsorted[j-1] = Integer.parseInt(line[j]);
            }

            if(checkArithmeticSequence(unsorted)){
                System.out.println("arithmetic");
                continue;
            }
            Arrays.sort(unsorted);
            if(checkArithmeticSequence(unsorted)){
                System.out.println("permuted arithmetic");
                continue;
            }
            System.out.println("non-arithmetic");

        }
    }

    public static boolean checkArithmeticSequence(long[] A){
        boolean arithSeq = true;

        long diff = A[1] - A[0];

        for(int i = 0; i < A.length-1; i++){
            if(diff != A[i+1] - A[i]){
                arithSeq = false;
                return arithSeq;
            }
        }
        return arithSeq;
    }


}
