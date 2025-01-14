package kep.t2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
    private static int[] intArr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int len = Integer.parseInt(input[0]);
        int cnt = Integer.parseInt(input[1]);

        String[] arr = br.readLine().split(" ");
        intArr = new int[len];
        int min = 100001;
        for(int i = 0; i < len; i++) {
            String now = arr[i];
            int intNow = Integer.parseInt(now);
            intArr[i] = intNow;
            min = Math.min(min, intNow);
        }

        for(int i = 0; i < len; i++) {
            int now = intArr[i];
            if(now == min) {

            }
        }

        System.out.println("Hello Goorm! Your input is " + input);
    }
}
