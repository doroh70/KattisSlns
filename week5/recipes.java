package week5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class recipes {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(input.readLine());

        StringBuilder output = new StringBuilder();

        for(int i = 0; i < T; i++){
            String[] RPD = input.readLine().split(" ");
            int R = Integer.parseInt(RPD[0]);
            int P = Integer.parseInt(RPD[1]);
            int D = Integer.parseInt(RPD[2]);
            double scale = (D+0.0)/P;

            //Declare arrays to hold ingredient values
            String[] names = new String[R];
            double[] weight = new double[R];
            double[] percent = new double[R];
            double[] newWeight = new double[R];

            int hunnidIndex = 0;

            //load up arrays
            for(int j = 0; j < R; j++){
                String[] NWP = input.readLine().split(" ");
                names[j] = NWP[0];
                weight[j] = Double.parseDouble(NWP[1]);
                percent[j] = Double.parseDouble(NWP[2]);
                if(percent[j] == 100.0){
                    hunnidIndex = j;
                }
            }

            newWeight[hunnidIndex] = scale * weight[hunnidIndex];
            double mainNewWeight = newWeight[hunnidIndex];
            weight[hunnidIndex] = -1;

            for(int j = 0; j < R; j++){
                if(j != hunnidIndex){
                    newWeight[j] = percent[j]/100 * mainNewWeight;
                }
            }

            output.append("Recipe # ").append(i+1).append("\n");

            for(int j = 0; j < R; j++){
                output.append(names[j]).append(" ").append(String.format("%.1f\n", newWeight[j]));
            }

            for(int j = 0; j < 40; j++) {
                output.append('-');
            }
            output.append("\n");
        }

        System.out.print(output.toString());
    }
}

