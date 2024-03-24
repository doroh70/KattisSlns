package March22nd2024;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class keysphonewallet {
    public static void main(String[] args) {
        //read N

        //initialize an array list of kpw {keys, phone, wallet}

        //loop N times
            //read line
            //if line is in kpw, remove it


        //print kpw in alphabetical order

        Scanner input = new Scanner(System.in);

        int N = Integer.parseInt(input.nextLine());


        List<String> kpw = new ArrayList<>(List.of("keys", "phone", "wallet"));

        for(int i = 0; i < N; i++) {
            String lineInput = input.nextLine();

            if(kpw.contains(lineInput)){
                kpw.remove(lineInput);
            }
        }

        for(String forgot: kpw){
            System.out.println(forgot);
        }

        if (kpw.size() == 0){
            System.out.println("ready");
        }

    }
}
