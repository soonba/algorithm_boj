package dfs.subsequence;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1182
 * Level: Silver 2
 * Algorithm: Back tracking
 */

/*
수열을 배열로 초기화한다.
모든 크기에 대해 모든 수열의 경우의 수를 dfs로 다 더하여 목표값과 같다면 count를 더해준다.
 */

public class Main {
    static int T;
    static int target;
    static int total = 0;

    static int[] sequenceNum;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] S = br.readLine().split(" ");
        T = Integer.parseInt(S[0]);
        target = Integer.parseInt(S[1]);
        sequenceNum = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        dfs(0,0);

        int result = target == 0 ? total-1 : total;
        System.out.println(result);
    }

    static void dfs(int count, int temp) {
        if(count == T) {
            if(temp == target) total++;
            return;
        }
        dfs(count+1, temp+sequenceNum[count]);
        dfs(count+1, temp);

    }
}
