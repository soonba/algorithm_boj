package implementation.custom_set;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class Main {

    private static final List<String> OVERRIDE_KEYWORD = List.of("empty","all");
    private static final List<String> UPDATE_KEYWORD = List.of("add","remove","toggle");
    private static final String PRINT_KEYWORD = "check";
    private static int[] customSet = new int[21];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            String[] S = br.readLine().split(" ");
            String act = S[0];
            if(OVERRIDE_KEYWORD.contains(act)) {
                override(act);
                continue;
            }
            int number = Integer.parseInt(S[1]);
            if(UPDATE_KEYWORD.contains(act)) {
                update(act,number);
            }
            if(PRINT_KEYWORD.equals(act)) {
                sb.append(customSet[number]).append("\n");
            }
        }
        System.out.println(sb);
    }

    private static void update(String act, int number) {
        if(act.equals("add")) customSet[number] = 1;
        if(act.equals("remove")) customSet[number] = 0;
        if(act.equals("toggle")) customSet[number] = customSet[number] == 1 ? 0 : 1;
    }

    private static void override(String act) {
        if(act.equals("empty")) {
            customSet = new int[21];
        }
        if(act.equals("all")) {
            Arrays.fill(customSet,1);
        }
    }

}
