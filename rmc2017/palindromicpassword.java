package rmc2017;

import java.util.*;

public class palindromicpassword {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int N = input.nextInt();

        for(int i = 0; i < N; i++) {
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            Map<Integer, ArrayList<Integer>> diffMap = new HashMap<>();

            int x = input.nextInt();

            //regular palindrome
            int first = x/1000;
            String firstString = Integer.toString(first);
            String lastString = new StringBuilder(firstString).reverse().toString();
            int last = Integer.parseInt(lastString);
            int pal = (first*1000) + last;
            pq.add(Math.abs(pal - x));
            ArrayList<Integer> list = new ArrayList<>();
            list.add(pal);
            diffMap.put(Math.abs(pal - x), list);

            //plus 1 palindrome
            int firstPlus1 = first + 1;
            String firstStringPlus1 = Integer.toString(firstPlus1);
            String lastStringPlus1 = new StringBuilder(firstStringPlus1).reverse().toString();
            int lastPlus1 = Integer.parseInt(lastStringPlus1);
            int palPlus = (firstPlus1*1000) + lastPlus1;
            if(firstPlus1 < 1000){
                if(!pq.contains(Math.abs(palPlus-x))){
                    pq.add(Math.abs(palPlus-x));
                }
                if(diffMap.containsKey((Math.abs(palPlus-x)))){
                    diffMap.get((Math.abs(palPlus-x))).add(palPlus);
                }
                else{
                    ArrayList<Integer> list2 = new ArrayList<>();
                    list2.add(palPlus);
                    diffMap.put(Math.abs(palPlus-x), list2);
                }
            }

            //minus 1 palindrome
            int firstMinus1 = first -1;
            String firstStringMinus1 = Integer.toString(firstMinus1);
            String lastStringMinus1 = new StringBuilder(firstStringMinus1).reverse().toString();
            int lastMinus1 = Integer.parseInt(lastStringMinus1);
            int palMinus = (firstMinus1*1000) + lastMinus1;
            if(firstMinus1 >= 100){
                if(!pq.contains(Math.abs(palMinus-x))){
                    pq.add(Math.abs(palMinus-x));
                }
                if(diffMap.containsKey((Math.abs(palMinus-x)))){
                    diffMap.get((Math.abs(palMinus-x))).add(palMinus);
                }
                else{
                    ArrayList<Integer> list3 = new ArrayList<>();
                    list3.add(palMinus);
                    diffMap.put(Math.abs(palMinus-x), list3);
                }
            }


            int firstOption = pq.poll();

            int result;
            Collections.sort(diffMap.get(firstOption));
            result = diffMap.get(firstOption).get(0);
            System.out.println(result);
        }
    }
}
