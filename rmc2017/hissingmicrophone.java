package rmc2017;

import java.util.Scanner;

public class hissingmicrophone {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        String text = input.nextLine();

        if(text.contains("ss")){
            System.out.println("hiss");
        }
        else{
            System.out.println("no hiss");
        }
    }
}
