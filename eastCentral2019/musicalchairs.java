package eastCentral2019;

import java.util.ArrayList;
import java.util.Scanner;

public class musicalchairs {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n;

        n = input.nextInt();

        //create and populate facList
        ArrayList<Integer> facList = new ArrayList<>(n);
        for(int i = 0; i <n; i++){
            facList.add(i+1);
        }

        //populate opus list
        ArrayList<Integer> opus = new ArrayList<>(n);
        for(int i = 0; i <n; i++){
            int opu = input.nextInt();
            opus.add(opu);
        }

        int curr = 0;
        while(facList.size() > 1) {
            n = facList.size();
            int ultim = opus.get(curr);


            if(ultim < n) {
                curr = ((ultim -1) + curr)%n;
                facList.remove(curr);
                opus.remove(curr);
            }
            else if(ultim % n == 0) {
                curr = ((n -1) + curr) % n;
                facList.remove(curr);
                opus.remove(curr);
                //curr = 0; //first
            }
            else {
                curr = (((ultim %n) -1)+ curr)%n;
                facList.remove(curr);
                opus.remove(curr);
            }

            if(curr >= facList.size()) {
                curr = 0;
            }
        }

        System.out.println(facList.get(0));
    }
}
