import java.util.Scanner;

public class beekeeper {
    public static void main(String[] args){
        String[] doubleVowels = {"aa", "ee", "ii", "oo", "uu", "yy"};
        Scanner scanner = new Scanner(System.in);
        //loop through # of input n, while it's not equals to 0
            //go through n words and print best
        for(int i = 0; i < 10; i++){
            int words = Integer.parseInt(scanner.nextLine());
            if(words == 0){
                return;
            }
            else{
                //make original array of words
                //make new array with all dVowels removed from words
                    //while you go through each reduced, keep track of highest diff and replace accordingly

                String[] originalWords = new String[words];
                String[] reducedWords = new String[words];
                int[] diff = new int[words];
                //populate original words
                for(int x = 0; x < words; x++){
                    originalWords[x] = scanner.nextLine();
                }
                //populate reducedWords
                for(int x = 0; x < words; x++){
                    String origin = originalWords[x];
                    for( String vowel : doubleVowels){
                        reducedWords[x] = origin.replaceAll(vowel, "");
                        origin = reducedWords[x];
                    }
                }
                //create list of diff
                for(int x = 0;x < words; x++ ){
                    diff[x] = originalWords[x].length() - reducedWords[x].length();
                }
                int maxAt = 0;
                for(int x = 0; x < words; x++) {
                    maxAt = diff[x] > diff[maxAt] ? x : maxAt;
                }
                System.out.println(originalWords[maxAt]);
            }
        }
    }
}
