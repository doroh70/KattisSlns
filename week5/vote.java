package week5;

import java.util.*;
import java.lang.*;

public class vote {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int T = input.nextInt();
        for(int i = 0; i < T; i++) {
            int C = input.nextInt();
            int sumVotes = 0;
            //load votes into arraylist
            ArrayList<Integer> votes = new ArrayList<>(C);
            for(int j = 0; j < C; j++){
                votes.add(input.nextInt());
                sumVotes += votes.get(j);
            }
            ArrayList<Integer> sortedVotes = new ArrayList<>(votes);
            //sort votes
            Collections.sort(sortedVotes);

            //if last 2 elements are the same draw, else print winner
            if(sortedVotes.get(C-1).equals(sortedVotes.get(C-2))){
                System.out.println("no winner");
            }
            else if (sortedVotes.get(C-1) > (sumVotes/2)){
                System.out.println("majority winner " + (votes.indexOf(sortedVotes.get(C-1)) + 1));
            }
            else{
                System.out.println("minority winner " + (votes.indexOf(sortedVotes.get(C-1))+1));
            }

        }
    }
}