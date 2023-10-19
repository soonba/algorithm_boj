package boj.gold.B5430;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            sb.append(process(br)).append("\n");
        }
        System.out.println(sb.substring(0,sb.length()-1));
    }

    private static String process(BufferedReader br) throws Exception {
        String s = br.readLine();
        char[] commands = s.toCharArray();
        int l = Integer.parseInt(br.readLine());
        String s1 = br.readLine();
        String removeBrackets = s1.substring(1, s1.length() - 1);
        String[] split = removeBrackets.split(",");

        int[] graph = new int[l];
        for (int i = 0; i < l; i++) {
            graph[i] = Integer.parseInt(split[i]);
        }

        boolean reverse = false;
        int sp = 0;
        int ep = l-1;

        for (int i = 0; i < commands.length; i++) {
            if(commands[i] == 'R') {
                reverse = !reverse;
            } else {
                if(reverse) {
                    ep--;
                } else {
                    sp++;
                }
            }
            if(sp > ep+1) break;
        }
        if(sp>ep+1) return "error";
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        if(reverse) {
            for (int i = ep; i >= sp; i--) {
                sb.append(graph[i]).append(',');
            }
        } else {
            for (int i = sp; i <= ep; i++) {
                sb.append(graph[i]).append(',');
            }
        }
        if(sb.length()!=1) sb.deleteCharAt(sb.length()-1);
        return sb.append(']').toString();
    }

}

