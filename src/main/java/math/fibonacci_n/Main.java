package math.fibonacci_n;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception{
        List<Integer> fb = new ArrayList<>();

        fb.add(0);
        fb.add(1);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int s = Integer.parseInt(br.readLine());
        for (int i = 2; i < s+1; i++) {
            fb.add(fb.get(i-2)+fb.get(i-1));
        }
        System.out.println(fb.get(s));
    }
}
