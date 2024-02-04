package practiceInnit;

import java.util.Arrays;

public class mergesort {
    public static void main(String[] args){
        int[] test = {3, 1, 2, 5, 4, -9, 100};

        mergeSort(test, 0, test.length);
        System.out.println(Arrays.toString(test));

    }

    public static void mergeSort(int[] A, int start, int end){ // 0 start end exclusive

        //if A has only one element it's sorted
        //else split down the middle
        //and recursively sort the arrays
        //merge the result
        if(end-start == 1){
            //a is already sorted
        }
        else{
            int middle = start + (end-start)/2; //right side will always be >= left side by 1
            mergeSort(A, start, middle);
            mergeSort(A, middle, end);
            merge(A, start, middle, end);
        }
    }

    public static void merge(int[] A, int start, int middle, int end) {
        //go on a loop ~ i
        //pick smallest from start-middle, middle-end
        int i = start;
        int j = middle;

        int Temp[] = new int[end-start];
        int x = 0;
        while((i < middle) && (j < end)) {
            if(A[i] < A[j]){
                Temp[x++] = A[i++];
            }
            else {
                Temp[x++] = A[j++];
            }
        }
        //copy leftover from start to middle range to Temp
        //Arrays.copy
        System.arraycopy(A,i, Temp, x, middle-i);
        //copy leftover from middle to end
        System.arraycopy(A, j, Temp, x+(middle-i), end-j);
        //copy Temp to A
        System.arraycopy(Temp, 0, A, start, end-start);
    }
}