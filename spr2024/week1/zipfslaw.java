package spr2024.week1;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class zipfslaw {
    public static void main(String[] args) {
        /*
        You are to find all the words occurring n
        times in an English text. A word is a sequence of letters. Words are separated by non-letters.
        Capitalization should be ignored. A word can be of any length that an English word can be.
         */
        //find words occurring n times
        //word can be 1 to infinity length of chars
        //words are separated by non letters
        //ignore capitalization

        //while there is a next line
        //read line, n
        //count how many n words exactly appear until EndOfText
        //if there is a line after EndOfText, do top 3 again

        boolean shouldPrint = false;
        Scanner input = new Scanner(System.in);
        while(input.hasNextLine()){
            //Declare wordMap
            Map<String, Integer> wordMap = new HashMap<>();
            if(shouldPrint){
                System.out.println();
            }
            //read n
            int n = Integer.parseInt(input.nextLine());
            //read words until we encounter "EndOfText", each time we see a word increase its counter in word map by 1
            while(input.hasNextLine()) {
                String line = input.nextLine();
                if (line.equals("EndOfText")) {
                    shouldPrint = true;
                    //print words that occur n times
                    Set<String> keys = wordMap.keySet();
                    List<String> keyList = new ArrayList<>(keys);
                    Collections.sort(keyList);
                    int howMany  = 0;
                    for (String key : keyList) {
                        if (wordMap.get(key) == n) {
                            howMany++;
                            System.out.println(key);
                        }
                    }

                    if(howMany == 0) {
                        System.out.println("There is no such word.");
                    }
                    break;
                }
                //else split the line, read each word and adjust wordMap appropriately
                else {
                    Pattern pattern = Pattern.compile("[a-zA-Z]+"); // Regex for any single letter
                    Matcher matcher = pattern.matcher(line);

                    while (matcher.find()) {
                        if (wordMap.containsKey(matcher.group().toLowerCase())) {
                            int matchVal = wordMap.get(matcher.group().toLowerCase());
                            wordMap.put(matcher.group().toLowerCase(), ++matchVal);
                        } else {
                            wordMap.put(matcher.group().toLowerCase(), 1);
                        }
                    }
                }
            }

        }
    }
}