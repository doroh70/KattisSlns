package rmc2017;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class froshweek {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        int m = input.nextInt();
        Integer[] tasks = new Integer[n];
        Integer[] intervals = new Integer[m];

        //load tasks
        for(int i = 0; i < n; i++) {
            tasks[i] = input.nextInt();
        }
        //sort tasks ascending(default sort)
        Arrays.sort(tasks, Comparator.reverseOrder());


        //load intervals
        for(int i = 0; i < m; i++) {
            intervals[i] = input.nextInt();
        }
        //sort intervals descending
        Arrays.sort(intervals, Comparator.reverseOrder());

        int maxTasks = 0;
        int x = 0; // task pointer
        for (int i = 0; i < intervals.length && x < tasks.length; i++) {
            while ((x < tasks.length) && tasks[x] > intervals[i]) {
                x++; // move to the next task
            }
            if(x>=tasks.length){
                break;
            }
            if (tasks[x] <= intervals[i]) {
                maxTasks++;
                x++; // move to the next task
            }
        }
        System.out.println(maxTasks);
    }
}
