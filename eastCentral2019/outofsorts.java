package eastCentral2019;

import java.util.Arrays;
import java.util.Scanner;

public class outofsorts {
    public static void main(String[] args) {
        int n;
        long m, a, c, x0;

        Scanner input = new Scanner(System.in);

        n = input.nextInt();
        m = input.nextLong();
        a = input.nextLong();
        c = input.nextLong();
        x0 = input.nextLong();

        //Create list of unsorted values
        long[] uns = new long[n];

        long xPast = x0;
        for(int i = 0; i < n; i++) {
            long x = ((a * xPast) + c) % m;
            uns[i] = x;
            xPast = x;
        }


        int occur = 0;
        long[] found = new long[n];
        for(int i = 0; i < n; i++) {
            int yah = Arrays.binarySearch(uns, uns[i]);
            if (yah >= 0){
                occur++;
            }
        }

        System.out.println(occur);
    }
}
