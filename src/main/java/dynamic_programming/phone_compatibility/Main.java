package dynamic_programming.phone_compatibility;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] a = br.readLine().split("");
        String[] b = br.readLine().split("");

        Integer[] sequence = new Integer[a.length+b.length];
        for (int i = 0; i < a.length; i ++) {
            sequence[2*i] = Integer.parseInt(a[i]);
            sequence[(2*i)+1] = Integer.parseInt(b[i]);
        }

        while(sequence.length > 2) {
            Integer[] newSequence = new Integer[sequence.length-1];
            for (int i = 0; i < newSequence.length; i++) {
                newSequence[i] = (sequence[i] + sequence[i+1]) % 10;
            }
            sequence = newSequence;
        }
        System.out.println(sequence[0].toString() + sequence[1].toString());

    }
}
