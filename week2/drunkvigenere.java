import java.util.Scanner;

public class drunkvigenere {

    public static void main(String[] args){
        String C, K;
        Scanner input = new Scanner(System.in);

        //read encrypted input C and K
        C = input.nextLine();
        String[] encryptedChar = C.split("");
        K = input.nextLine();
        String[] decryptedChar = K.split("");

        //loop through each char of encrypted input
        for(int i = 0; i < encryptedChar.length; i++){

            String decrypted;

            if(i%2 != 0){
                decrypted = shiftStringForward(encryptedChar[i].charAt(0), decryptedChar[i].charAt(0));
            }
            else{
            //when odd shift backwards by K[n]
                decrypted = shiftStringBackwards(encryptedChar[i].charAt(0), decryptedChar[i].charAt(0));
            }
            System.out.print(decrypted);
        }
        System.out.println("");
    }

    //A is 65, Z is 90
    public static String shiftStringForward(char c, char k){
        //if we go above, 90
            //add rest starting from 65
        int shift = k-'A';
        int shiftedPos = (c - 'A' + shift)%26 + 'A';

        return Character.toString(shiftedPos);
    }

    public static String shiftStringBackwards(char c, char k){
        int shift = k-'A';
        int shiftedPos = (c - 'A' - shift)%26 + 'A';
        if (shiftedPos < 'A'){
            shiftedPos += 26;
        }

        return Character.toString(shiftedPos);
    }

}