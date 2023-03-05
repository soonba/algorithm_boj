package data_structure.age_sorting;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        Queue<Person> queue = new PriorityQueue<>((a,b) -> {
            if(a.age == b.age) {
                return a.idx - b.idx;
            }
            return a.age-b.age;
        });
        for (int i = 0; i < T; i++) {
            String[] s = br.readLine().split(" ");
            queue.add(new Person(Integer.parseInt(s[0]),s[1],i+1));
        }
        StringBuilder sb = new StringBuilder();
        while(!queue.isEmpty()) {
            Person poll = queue.poll();
            sb.append(poll.age).append(" ").append(poll.name).append("\n");
        }
        System.out.println(sb);
    }

}

class Person {
    int age;
    String name;
    int idx;

    public Person(int age, String name, int idx) {
        this.age = age;
        this.name = name;
        this.idx = idx;
    }
}
