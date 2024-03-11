package sorting.coordinate_compression;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] numbers = new int[N];
        SortedSet<Integer> ss = new TreeSet<>();
        String[] split = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            int next = Integer.parseInt(split[i]);
            numbers[i] = next;
            ss.add(next);
        }

        HashMap<Integer,Integer> hashMap = new HashMap<>();
        int count = 0;
        while(!ss.isEmpty()) {
            Integer first = ss.first();
            hashMap.put(first,count);
            count++;
            ss.remove(first);
        }

        StringBuilder sb = new StringBuilder();
        for (int number : numbers) {
            sb.append(hashMap.get(number)).append(" ");
        }

        System.out.println(sb);;

    }

}
