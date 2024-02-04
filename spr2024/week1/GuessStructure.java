package spr2024.week1;

import java.util.*;


public class GuessStructure {

    //1 throw in x
    // 2 take out element x is result


    /*could be stack, queue, PQ, impossible, not sure (>=2 of choices)*/
    //1<=n<=1000
    //x is positive and less than 100

    /*
    for each test case, read n
    initialize the 3 data structures ~ stack, queue, PQ
    initialize a 3 pos array(stack, queue, PQ) set all to true
    loop n times
    perform operations
        check if any ds op fails and update array pos to false
    at the end of n iterations if sum of array pos is >=2, print not sure
    if it is 1, print the appropriate ds
    if it is 0, print impossible
    */

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while(input.hasNextLine()){
            int n = Integer.parseInt(input.nextLine());
            Stack<Integer> stack = new Stack<>();
            Queue<Integer> queue = new LinkedList<Integer>();
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
            int[] whichDs = {1, 1, 1};
            for(int i = 0; i < n; i++){
                String text = input.nextLine();
                String[] textIn = text.split(" ");
                int op = Integer.parseInt(textIn[0]);
                int res = Integer.parseInt(textIn[1]);

                if(op == 1){
                    stack.push(res);
                    queue.add(res);
                    pq.add(res);
                }
                else{
                    if(stack.isEmpty()){
                        whichDs[0] = 0;
                        whichDs[1] = 0;
                        whichDs[2] = 0;
                        continue;
                    }
                    int inter = stack.pop();
                    if(inter != res) {
                        whichDs[0] = 0;
                    }
                    inter = queue.poll();
                    if(inter != res) {
                        whichDs[1] = 0;
                    }
                    inter = pq.poll();
                    if(inter != res) {
                        whichDs[2] = 0;
                    }
                }
            }

            //print result
            int sum = 0;
            for(int x = 0; x < whichDs.length; x++){
                sum += whichDs[x];
            }
            if(sum >= 2) {
                System.out.println("not sure");
            }
            else if(sum == 1) {
                if(whichDs[0] == 1){
                    System.out.println("stack");
                }
                if(whichDs[1] == 1){
                    System.out.println("queue");
                }
                if(whichDs[2] == 1){
                    System.out.println("priority queue");
                }
            }
            else{
                System.out.println("impossible");
            }
        }
    }

}
