package March22nd2024;

import java.util.Scanner;

//Reworked sln from https://github.com/HowardChengUleth/Contest/blob/master/UAPC/2024/dinnertime.cc

public class dinnertime {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Long answer = 1L; // person 0 has both
        Long P = 0L, G = 0l;

        int N = Integer.parseInt(input.nextLine());

        for (int i = 0; i < N; i++) {
            String[] params = input.nextLine().split(" ");
            String type = params[0];
            long K = Long.parseLong(params[1]);

            if(type.equals("P")) {
                if (P < G && P+K >= G) {
                    // catch up to the gravy, he gets to pour gravy now
                    answer++;
                }
                P += K;
            }
            else {
                if (G < P+1) {
                    answer += Long.min(K, P-G);
                }
                G += K;
            }
        }

        System.out.println(answer);
    }
}