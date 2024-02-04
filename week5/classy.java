package week5;

import java.util.*;

public class classy {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int T = Integer.parseInt(input.nextLine());

        for(int i = 0; i < T; i++) {

            int n = Integer.parseInt(input.nextLine());

            ArrayList<ArrayList<Integer>> mandemClass = new ArrayList<>();

            Map<Long, ArrayList<Integer> > magIndexMapping = new HashMap<>();

            ArrayList<Long> mag = new ArrayList<>();

            String[] names = new String[n];

            int bigL = 0;
            for (int j = 0; j < n; j++) {
                String textInput = input.nextLine();
                String[] splitTextInput = textInput.split(": ");
                names[j] = splitTextInput[0];
                String classList = splitTextInput[1].split(" class")[0];
                String[] classArray = classList.split("-");
                ArrayList<Integer> classListInt = new ArrayList<>();

                if(classArray.length > bigL){
                    bigL = classArray.length;
                }
                //convert to 1, 2, 3
                for(int k = 0; k < classArray.length; k++) {
                    if(classArray[k].equals("upper")){
                        classListInt.add(3);
                    }
                    else if (classArray[k].equals("middle")) {
                        classListInt.add(2);
                    }
                    else {
                        classListInt.add(1);
                    }
                }

                //reverse
                Collections.reverse(classListInt);

                //store in jth position mandemClass
                mandemClass.add(classListInt);
            }

            for(int j = 0; j < mandemClass.size(); j++) {
                if(mandemClass.get(j).size() < bigL){
                    //fill rest with 2

                    int rest = bigL - mandemClass.get(j).size();

                    for(int k = 0; k < rest; k++){
                        mandemClass.get(j).add(2);
                    }
                }
            }

            for(int j = 0; j < mandemClass.size(); j++) {
                long magnitude = 0;
                StringBuilder magN = new StringBuilder();
                for(int k = 0; k < mandemClass.get(j).size(); k++){
                    magN.append(mandemClass.get(j).get(k));
                }
                magnitude = Long.parseLong(magN.toString());

                if(!magIndexMapping.containsKey(magnitude)){
                    ArrayList<Integer> referenceList = new ArrayList<>();
                    magIndexMapping.put(magnitude, referenceList);
                    referenceList.add(j);
                    mag.add(magnitude);
                }
                else{
                    magIndexMapping.get(magnitude).add(j);

                    //sort list alphabetically
                    magIndexMapping.get(magnitude).sort(new Comparator<Integer>() {
                        @Override
                        public int compare(Integer o1, Integer o2) {
                            return names[o1].compareTo(names[o2]);
                        }
                    });

                }
            }

            //sort magnitude array
            Collections.sort(mag);

            Collections.reverse(mag);


            //print according to magnitude array
            for(int j = 0; j < mag.size(); j++){
                //mag[j];
                //magIndexMapping.get(mag[j]);
                ArrayList<Integer> finale = magIndexMapping.get(mag.get(j));
                for( int k : finale){
                    System.out.println(names[k]);
                }
                //System.out.println(names[magIndexMapping.get(mag.get(j))]);
            }

            StringBuilder sb = new StringBuilder();
            for(int j = 0 ; j < 30; j++) {
                sb.append("=");
            }

            System.out.println(sb.toString());

        }
    }
}
