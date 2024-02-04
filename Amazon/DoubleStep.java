package Amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class DoubleStep {
    public static void main(String[] args) {

        //initialize x and y variables to 0
        //create ArrayList of grid positions ~ steps
        //for each input
            //if it dont exist
                //place x and y variables in array
            //else print we already been here


        Scanner input = new Scanner(System.in);
        ArrayList<ArrayList<Integer>> steps = new ArrayList<>();
        ArrayList<Integer> firstElement = new ArrayList<>();
        firstElement.add(0);
        firstElement.add(0);
        steps.add(firstElement);

        String directions = input.nextLine();
        int x = 0, y = 0;
        ArrayList<String> directionList = new ArrayList<>(Arrays.asList(directions.split(" ")));
        for( String i : directionList) {
            switch(i) {
                case "N":
                    ++y;
                    break;
                case "S":
                    --y;
                    break;
                case "E":
                    ++x;
                    break;
                case "W":
                    --x;
                    break;
            }
            ArrayList<Integer> element = new ArrayList<>(Arrays.asList(x,y));
            if (steps.contains(element)){
                System.out.println("Repeated");
                return;
            }
            else{
                steps.add(element);
            }
        }
        System.out.println("No repeats");
    }
}
