package rmc2018;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class hindex {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int papers = input.nextInt();
        ArrayList<Integer> citations = new ArrayList<>(papers);

        for (int i = 0; i < papers; i++) {
            citations.add(input.nextInt());
        }

        Collections.sort(citations);

        int hIndex = 0;
        //loop through citations
        while(!citations.isEmpty()) {
            //get first element el
            //there are size - el elements left, rest
            //if el <= rest
                //if el is greater than hIndex, update
            //pop el/ first element

            int el = citations.get(0);
            int rest = citations.size() - el;
            if(el <= rest && el > hIndex){
                hIndex = el;
            }

            citations.remove(0);
        }

        System.out.println(hIndex);
    }
}

