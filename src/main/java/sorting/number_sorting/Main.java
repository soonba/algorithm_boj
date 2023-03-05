package sorting.number_sorting;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//2751
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[] wholeNumberChecker = new boolean[2000001];
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int a = Integer.parseInt(br.readLine());
            wholeNumberChecker[a+1000000] = true;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 2000001; i++) {
            if(wholeNumberChecker[i]) {
                sb.append(i-1000000).append("\n");
            }
        }
        System.out.println(sb);
    }
}
