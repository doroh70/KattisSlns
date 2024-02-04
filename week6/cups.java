package week6;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;


public class cups {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int T = Integer.parseInt(input.nextLine());

        //Map of radius to color
        Map<Integer, String> radToColor = new HashMap<>();

        //PriorityQueue of Radius
        PriorityQueue<Integer> sortedCups = new PriorityQueue<>();

        for(int i = 0; i < T; i++) {
            String textInput = input.nextLine();
            String[] elements = textInput.split(" ");
            int radius;
            String color;
            if(elements[0].matches("[0-9]+")) {
                radius = Integer.parseInt(elements[0]);
                color = elements[1];
                radToColor.put(radius, color);
                sortedCups.add(radius);

            }
            else{
                radius = Integer.parseInt(elements[1]) * 2;
                color = elements[0];
                radToColor.put(radius, color);
                sortedCups.add(radius);
            }
        }

        while(!sortedCups.isEmpty()) {
            int radius = sortedCups.poll();

            System.out.println(radToColor.get(radius));
        }
    }
}
