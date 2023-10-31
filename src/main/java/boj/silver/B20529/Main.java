package boj.silver.B20529;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//3
//3
//ENTJ INTP ESFJ
//4
//ESFP ESFP ESFP ESFP
//5
//INFP INFP ESTP ESTJ ISTJ
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            int P = Integer.parseInt(br.readLine());
            String MBTIs = br.readLine();
            if (P >= 33) {
                sb.append(0).append("\n");
                continue;
            }
            int min = 12;
            String[] MBTIArray = MBTIs.split(" ");
            loop:
            for (int j = 0; j < P - 2; j++) {
                String js = MBTIArray[j];
                for (int k = j + 1; k < P - 1; k++) {
                    String ks = MBTIArray[k];
                    int m = calc(js, ks);
                    for (int l = k + 1; l < P; l++) {
                        String ls = MBTIArray[l];
                        min = Math.min(min, m + calc(ks, ls) + calc(ls, js));
                        if (min == 0) break loop;
                    }
                }
            }
            sb.append(min).append("\n");
        }
        System.out.println(sb);
    }

    private static int calc(String a, String b) {
        int count = 0;
        for (int i = 0; i < 4; i++) {
            if (a.charAt(i) != b.charAt(i)) count++;
        }
        return count;
    }

}
