package week2;

import java.util.Scanner;


public class calories {

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        while(input.hasNextLine()){
            String line = input.nextLine();
            if(line != "-"){
                String fat, protein, sugar, starch, alcohol;
                String[] splitted = line.split(" ");





                for(int i = 0; i <5; i++){
                }
            }
        }
    }


    /*public static int[] convertCal(String[] foodItems){
        for(int i = 0; i <5; i++){
            if(foodItems[i].endsWith("%")){

            }
        }

    }*/

    public static int decodeCals(String input) {
        if(input.endsWith("C")){
            return Integer.parseInt(input.replace("C", ""));
        }
        if(input.endsWith("g")){
            return Integer.parseInt(input.replace("g", "")) * 9;
        }
        if(input.endsWith("%")){
            return -1;
        }
        else{
            return -1;
        }
    }
}
