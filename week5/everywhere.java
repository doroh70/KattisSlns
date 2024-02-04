package week5;

import java.util.ArrayList;
import java.util.Scanner;

public class everywhere {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        int T = Integer.parseInt(input.nextLine());

        for(int i = 0; i < T; i++){
            int n = Integer.parseInt(input.nextLine());
            ArrayList<String> places = new ArrayList<>(100);
            for(int j = 0; j < n; j++){
                String city = input.nextLine();
                if (!places.contains(city)){
                    places.add(city);
                }
            }
            System.out.println(places.size());
        }
    }
}
