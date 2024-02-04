package week6;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class password {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int N = Integer.parseInt(input.nextLine());

        //loop N times ~ i
            //get password and prob
            //mult prob by 10000
            //store in PQ

        PriorityQueue<Double> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for(int i = 0; i < N; i++) {
            String[] textInput = input.nextLine().split(" ");

            double prob = Double.parseDouble(textInput[1]);
            //System.out.println(prob);
            pq.add(prob);
        }

        //initialize totalTry variable
        //loop N times ~ i
            //multiply top by i
            //add to totaltry

        //divide total try by 10000

        double totalTry = 0;
        for(int i = 1; i <= N; i++) {
            totalTry = totalTry + (pq.poll()*i);
        }

        double output = totalTry;

        System.out.println(output);

    }
}
