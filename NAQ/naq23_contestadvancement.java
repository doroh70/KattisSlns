package NAQ;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class naq23_contestadvancement {

    /**
     *Map of qualifiedTeams that are going( team - school)
     * Map of reserveTeams ( team - school)
     * Map of schoolCount (school - # of teams)
     */

    public static void main(String[] args) {

        //Initialize Scanner class
        Scanner input = new Scanner(System.in);

        int n = input.nextInt(); //Get Number of teams n
        int k = input.nextInt(); //Get number of teams that can qualify k
        int c = input.nextInt(); //Get school team limit c

        Map<Integer, Integer> qualifiedTeams = new HashMap<>();
        ArrayList<Integer> qualifiedTeamsList = new ArrayList<>(k);
        Map<Integer, Integer> reserveTeams = new HashMap<>();
        ArrayList<Integer> reserveTeamsList = new ArrayList<>();
        Map<Integer, Integer> schoolCount = new HashMap<>();
        ArrayList<Integer> indexes = new ArrayList<>();


        //input.nextLine(); // go to next line

        //one by one fill up teams that are going
        //if that teams school already has c members, add to reserves
        //else add to main team
        //if we haven't yet filled up K, remaining teams would be filled by teams over the limit

        int l = 0;
        for(int i = 0; i < n; i++) {
            //read team
            int t = input.nextInt();
            int s = input.nextInt();

            //if school count is null
            if((schoolCount.get(s) == null) && (qualifiedTeamsList.size() != k)){
                qualifiedTeams.put(t, s);
                qualifiedTeamsList.add(t);
                schoolCount.put(s, 1);
            }
            //if that teams school already has c members, add to reserves
            else if(schoolCount.get(s) >= c){
                //add to reserves
                reserveTeams.put(t, s);
                reserveTeamsList.add(t);
                indexes.add(qualifiedTeamsList.size() + l++);
            }
            //else add to map of qualified teams
            else if (qualifiedTeamsList.size() != k) {
                qualifiedTeams.put(t, s);
                qualifiedTeamsList.add(t);
                //add 1 to school count
                int temp = schoolCount.get(s);
                schoolCount.put(s, ++temp);
            }
        }

        //if qualified teams is not equals to k, add teams heirarchically from reserves until qualified == k
        int z = 0;
        while(qualifiedTeamsList.size() != k){
            //add to qualified teams from reserves
            //pop from reserves
            int term = reserveTeamsList.remove(z);
            int index = indexes.get(z);
            qualifiedTeamsList.add(index, term);
            z++;
        }


        for( int i : qualifiedTeamsList){
            System.out.println(i);
        }

    }


}