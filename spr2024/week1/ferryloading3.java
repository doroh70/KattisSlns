package spr2024.week1;

/*Conceptually
Ferry starts at left bank
    Everytime Ferry notices a car is waiting at either bank:
        it goes there(if not already there time t)
        Empties it load(time 0) - *log this and how many were unloaded in a map
        Fills up load at bank(time 0)
        travels across bank and empties again(time t)



Everytime Ferry notices a car is waiting at either bank  HOW?

    we keep track of arrival times on left and right bank
    everytime we're at a bank we check time elapsed S,
        then check IF immediate bank to see if first car in queue came less than S(then lp) OR check other bank(then lp)
        else increase time by next iteration (keep track of time arrived)

 */

import java.util.ArrayList;
import java.util.Scanner;

public class ferryloading3 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int c = Integer.parseInt(input.nextLine());
        //Do this for each test case
        for(int x = 0; x < c; x++) {
            int n, t, m;

            String[] nmc = input.nextLine().split(" ");
            n = Integer.parseInt(nmc[0]);
            t = Integer.parseInt(nmc[1]);
            m = Integer.parseInt(nmc[2]);

            //get list of time arrived for each bank and store in arrayList leftBankArrivals and rightBankArrivals
            ArrayList<Integer> leftBankArrivals = new ArrayList<>();
            ArrayList<Integer> rightBankArrivals = new ArrayList<>();

            for (int p = 0; p < m; p++){
                String[] tp = input.nextLine().split(" ");
                if(tp[1] == "right"){
                    rightBankArrivals.add(Integer.parseInt(tp[0]));
                }
                else{
                    leftBankArrivals.add(Integer.parseInt(tp[0]));
                }
            }

            ArrayList<Integer> displayList = new ArrayList<>();
            boolean onLeftBank = true;
            int S = 0;
            while (!leftBankArrivals.isEmpty() || !rightBankArrivals.isEmpty()) {
                if (onLeftBank) {
                    int i = 0;
                    // Check if the list is not empty and the first car in queue arrived before or at time S
                    while (!leftBankArrivals.isEmpty() && leftBankArrivals.get(0) <= S && i < n) {
                        displayList.add(leftBankArrivals.get(0));
                        leftBankArrivals.remove(0); // Safe to remove because we checked it's not empty
                        i++;
                    }
                    // lp step
                    S = S + t;
                    onLeftBank = false;
                } else if (!onLeftBank) {
                    int i = 0;
                    // Check if the list is not empty and the first car in queue arrived before or at time S
                    while (!rightBankArrivals.isEmpty() && rightBankArrivals.get(0) <= S && i < n) {
                        displayList.add(rightBankArrivals.get(0));
                        rightBankArrivals.remove(0); // Safe to remove because we checked it's not empty
                        i++;
                    }
                    // lp step
                    S = S + t;
                    onLeftBank = true;
                } else {
                    // Check if both sides have arrivals
                    if (!leftBankArrivals.isEmpty() && !rightBankArrivals.isEmpty()) {
                        // Both sides have arrivals, take the smaller of the first arrivals
                        S += Math.min(leftBankArrivals.get(0), rightBankArrivals.get(0));
                    } else if (!leftBankArrivals.isEmpty()) {
                        // Only left bank has arrivals
                        S += leftBankArrivals.get(0);
                    } else {
                        // Only right bank has arrivals (since one side always has something)
                        S += rightBankArrivals.get(0);
                    }
                }
            }

            //print display
            for (int display : displayList) {
                System.out.println(display);
            }
        }

    }


}
