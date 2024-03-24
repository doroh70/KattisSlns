package March22nd2024;

import java.util.*;

public class candystore {
    public static Map<String, List<String>> initialsName = new HashMap<>();

    public static void main(String[] args) {
        //read N, read Q

        //create map of Initials to full name ~ initialsName already done..

        // loop N times
            //call storeInitName(String FullName) on line input

        //loop Q times
            //read line initial
            //call queryCustomer(String initials) on line initials

        Scanner input = new Scanner(System.in);
        String[] params = input.nextLine().split(" ");

        int N = Integer.parseInt(params[0]);
        int Q = Integer.parseInt(params[1]);

        for(int i = 0; i < N; i++) {
            String lineInput = input.nextLine();
            storeInitName(lineInput);
        }

        for(int i = 0; i < Q; i++) {
            String lineInput = input.nextLine();
            String output = queryCustomer(lineInput);
            System.out.println(output);
        }


    }


    public static void storeInitName(String FullName) {
        String[] names = FullName.split(" ");
        String initials = "" + names[0].charAt(0) + names[1].charAt(0);

        if(initialsName.containsKey(initials)){
            initialsName.get(initials).add(FullName);
        }
        else{
            List<String> name = new ArrayList<>();
            name.add(FullName);
            initialsName.put(initials, name);
        }
    }

    public static String queryCustomer(String initials){
        if(!initialsName.containsKey(initials)){
            return "nobody";
        }

        else if (initialsName.get(initials).size() > 1){
            return "ambiguous";
        }

        else if (initialsName.get(initials).size() == 1){
            return initialsName.get(initials).get(0);
        }

        //Should never get here according to problem statement. On a real not when is it possible lol?
        return null;
    }
}