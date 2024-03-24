package March22nd2024;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class birthdaycandles {
    public static void main(String[] args) {
        int N, H, C;

        Scanner input = new Scanner(System.in);

        String[] params = input.nextLine().split(" ");

        N = Integer.parseInt(params[0]);
        H = Integer.parseInt(params[1]);
        C = Integer.parseInt(params[2]);

        ArrayList<ArrayList<Integer>> guestCandles = new ArrayList<>();

        for (int i = 0; i < N; i++){
            String[] lineInput = input.nextLine().split(" ");
            ArrayList<Integer> sortedLine = new ArrayList<>();
            for(String inputt : lineInput) {
                sortedLine.add(Integer.parseInt(inputt));
            }
            Collections.sort(sortedLine);
            guestCandles.add(sortedLine);
        }

        //blow candles one at a time from each set

        //get minimum first candle from all arrayLists and blow first


    }
}
