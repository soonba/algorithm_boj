package dynamic_programming.hide_and_seek;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int start = Integer.parseInt(s[0]);
        int end = Integer.parseInt(s[1]);
        int[] DP = new int[100002];
        Arrays.fill(DP, 100000);

        int max;
        DP[start] = 0;
        if (start <= end) {
            for (int i = 1; i < start; i++) {
                DP[i] = start-i;
            }
            max = Math.min(100001, end * 2);
            for (int i = start - 1; i < max; i++) {
                if (i <= 0) continue;
                if (i % 2 == 0) {
                    DP[i] = Math.min(DP[i], DP[i / 2] + 1);
                    DP[i-1] = Math.min(DP[i-1], DP[i] + 1);
                    DP[i+1] = Math.min(DP[i+1], DP[i] + 1);
                }
                DP[i] = Math.min(DP[i], DP[i - 1] + 1);
                DP[i] = Math.min(DP[i], DP[i + 1] + 1);
            }
            System.out.println(DP[end]);
        } else {
            System.out.println(start - end);


        }
    }
}

//100 0 # 100
//6 16 # 3
//8 20 # 3
//15964 89498 # 4781
//3 43 # 6
//4 27 # 5
//5 35 # 5
//6 43 # 5
//7 43 # 6
//100 1 # 99
//10 19 # 2
//5 19 # 3
//1 20 # 5
//100000 100000 # 0
//0 100000 # 22
//100000 0 # 100000
//0 1 # 1
//3482 45592 # 637
//2 4 # 1
//9 5 # 4
//5 5 # 0
//5 17 # 4