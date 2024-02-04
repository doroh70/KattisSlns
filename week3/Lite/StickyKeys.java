package week3.Lite;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StickyKeys {

    /**
     * What to do?
     * Remove duplicates of characters from a string
     *
     * Input?
     * The input consists of a string S where 1 <= |S| <= 1000.
     *  There may be multiple space-separated words in the message,
     *  so the entire string including spaces should be considered
     *  part of the message.
     *
     *  The string S is guaranteed to only include upper and lower-case
     *  characters, digits, and spaces. Thankfully, the coffee did not reach
     *  Bob’s spacebar so there will never be multiple spaces in a row.
     *
     *  Output?
     *  Output the message with repeated consecutive characters trimmed
     *  to a single character.
     */

    //Replace all multiple occurences of Upper and Lowercase characters in  a row
    //Replace all multiple occurences of digits in a row

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        //read input string
        //loop through input string

        String S = input.nextLine();

        Pattern expression = Pattern.compile("(.)\\1+");

        Matcher matcher = expression.matcher(S);

        while(matcher.find()){
            S = S.replaceFirst(matcher.group(), String.valueOf(matcher.group().charAt(0)));
        }

        System.out.println(S);
    }

}
