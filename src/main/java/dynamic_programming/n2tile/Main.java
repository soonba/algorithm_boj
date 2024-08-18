package dynamic_programming.n2tile;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int[] arr = new int[1001];
    public static void main(String[] args) throws Exception {
        init();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        System.out.println(arr[T-1]);
    }

    static void init() {
        arr[0] = 1;
        arr[1] = 3;
        for (int i = 2; i < arr.length; i++) {
            arr[i] = (arr[i-1] + 2 * arr[i-2]) % 10007;
        }
    }
}

