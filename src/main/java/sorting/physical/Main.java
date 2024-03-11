package sorting.physical;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

//5
//55 185
//58 183
//88 186
//60 175
//46 155
public class Main {
    public static void main(String[] args) throws Exception {
        int N = read();
        int[][] arr = new int[N][2];
        for (int i = 0; i < N; i++) {
            arr[i][0] = read();
            arr[i][1] = read();
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int height = arr[i][0];
            int weight = arr[i][1];
            int up = 1;
            for (int j = 0; j < N; j++) {
                if(i==j) continue;
                int tHeight = arr[j][0];
                int tWeight = arr[j][1];
                if(height < tHeight && weight < tWeight) up ++;
            }
            sb.append(up).append(" ");
        }
        System.out.println(sb);
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
