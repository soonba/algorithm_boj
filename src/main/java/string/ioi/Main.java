package string.ioi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        String S = br.readLine();
        int now = 0;
        List<Integer> ioiList = new ArrayList<>();

        while(now != M) {
            char c = S.charAt(now);
            if(c=='I') {
                int result = ioi(now,M,S);
                now += result;
                ioiList.add(result);
            } else {
                now ++;
            }
        }

        int count = 0;

        for (Integer integer : ioiList) {
            int num = integer % 2 == 1 ? (integer / 2) - (N - 1) : (integer / 2) - N;
            if(num >= 0) count += num;
        }

        System.out.println(count);
    }

    private static int ioi(int now, int M, String S) {
        int count = 1;
        for (int i = now; i < M; i++) {
            if(i == M-1) break;
            char nowChar = S.charAt(i);
            char nextChar = S.charAt(i+1);
            if(nowChar != nextChar) {
                count ++;
            } else {
                break;
            }
        }
        return count;
    }
}
