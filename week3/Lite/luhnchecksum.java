package week3.Lite;

import java.util.*;
import java.util.regex.*;

public class luhnchecksum {
    public static boolean checkSum(ArrayList<Integer> A) {
        for (int i = A.size() - 2; i > -1; i -= 2) {
            int temp = A.get(i) * 2;
            if (temp > 9) {
                A.set(i, temp / 10 + temp % 10);
            } else {
                A.set(i, temp);
            }
        }

        int sum = 0;
        for (int num : A) {
            sum += num;
        }

        return sum % 10 == 0;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int T = Integer.parseInt(input.nextLine());

        for (int i = 0; i < T; i++) {
            String textInput = input.nextLine();

            // Validate input to ensure it contains only numeric characters
            if (!textInput.matches("[0-9]+")) {
                System.out.println("INVALID");
                continue;
            }

            ArrayList<Integer> list = new ArrayList<>();
            for (int j = 0; j < textInput.length(); j++) {
                list.add(Integer.parseInt(String.valueOf(textInput.charAt(j))));
            }

            String result = checkSum(list) ? "PASS" : "FAIL";
            System.out.println(result);
        }
    }
}
