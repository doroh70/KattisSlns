package week1;

import java.util.*;

public class guessthedatastructure {

    //while not EOF
        //read test cases
        //initialize ds
        //loop n times
            //perform ds operations
        //clear ds
        //print what ds it is

    static Queue<Integer> queue = new LinkedList<>();
    static Stack<Integer> stack = new Stack<>();
    static PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        while(input.hasNextLine()){
            boolean isQueue = true;
            boolean isPQ = true;
            boolean isStack = true;

            int testCases = Integer.parseInt(input.nextLine());

            for(int i = 0; i < testCases; i++) {
                //read input
                int operation = input.nextInt();
                int value = input.nextInt();
                if(operation == 1){
                    addToStructure(value);
                }
                else if (operation == 2){
                    try {
                        //try each operation, if false set bool
                        isQueue = popFromQueue(value) && isQueue;
                        isPQ = popFromPQ(value) && isPQ;
                        isStack = popFromStack(value) && isStack;
                    } catch(NullPointerException e){
                        System.out.println("impossible");
                        return;
                    }
                }

                //go to next line
                input.nextLine();
            }

            //print answer
            var sum = (isPQ? 1: 0)  + (isQueue? 1:0) + (isStack? 1:0);
            if(sum > 1){
                System.out.println("not sure");
            }
            else if(isQueue){
                System.out.println("queue");
            }
            else if(isPQ){
                System.out.println("priority queue");
            }
            else if(isStack){
                System.out.println("stack");
            }
            else{
                System.out.println("impossible");
            }

            //clear ds
            queue.clear();
            stack.clear();
            pq.clear();
        }
    }

    public static void addToStructure(int x){
        queue.add(x);
        pq.add(x);
        stack.add(x);
    }
    public static boolean popFromStack(int x){
        if(x == stack.pop()){
            return true;
        }
        else{
            return false;
        }
    }
    public static boolean popFromQueue(int x){
        if(x == queue.poll()){
            return true;
        }
        else{
            return false;
        }
    }
    public static boolean popFromPQ(int x){
        if(x == pq.poll()){
            return true;
        }
        else{
            return false;
        }
    }


    public int sum(int n){
        int sum = 0;

        for(int i = 1; i <= n; i++){
            sum = sum + 1;
        }
        return sum;
    }



    //perform ds operations
        //1 add to structure ~ all
        //2 pop from structure ~ all
}
