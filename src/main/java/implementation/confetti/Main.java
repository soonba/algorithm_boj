package implementation.confetti;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        boolean[][] field = new boolean[101][101];
        int area = 0;
        for (int i = 0; i < T; i++) {
            String[] s = br.readLine().split(" ");
            int x = Integer.parseInt(s[0]);
            int y = Integer.parseInt(s[1]);
            for (int j = x; j < x+10; j++) {
                for (int k = y; k < y+10; k++) {
                    if(!field[j][k]) {
                        field[j][k] = true;
                        area++;
                    }
                }
            }
        }
        System.out.println(area);
    }
}
