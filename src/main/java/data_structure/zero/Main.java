package data_structure.zero;

/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 10773
 * Level: Silver IV
 * Algorithm: Data structure
 */

/*
sum 용 변수, 스택 변수 생성하여 0일경우 스택의 pop 을 빼주고
아닐경우 더해준다. 0이 나왔을 때 스택이 비어있지 않다는 보장이 있으므로 따로 체크 없이 Pop 이 가능
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        Stack<Integer> numStack = new Stack<>();
        int sum = 0;
        for (int i = 0; i < T; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num == 0) {
                sum -= numStack.pop();
            } else {
                sum += numStack.push(num);
            }
        }
        System.out.println(sum);
    }
}
