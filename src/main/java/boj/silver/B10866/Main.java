package boj.silver.B10866;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        Deque<Integer> q = new LinkedList<>();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            String command = br.readLine();
            String[] split = command.split(" ");
            String[] split1 = split[0].split("_");
            if (split.length == 2) {
                String pushCommand = split1[1];
                if (pushCommand.equals("back")) {
                    q.addLast(Integer.parseInt(split[1]));
                } else {
                    q.addFirst(Integer.parseInt(split[1]));
                }
            } else {
                if(split1.length == 2) {
                    String popCommand = split1[1];
                    Integer poll;
                    if(popCommand.equals("front")) {
                        poll = q.pollFirst();
                    } else {
                        poll = q.pollLast();
                    }
                    if(poll == null) {
                        sb.append(-1).append("\n");
                    } else {
                        sb.append(poll).append("\n");
                    }
                } else {
                    int m = 0;
                    if(split1[0].equals("front")) {
                        m = q.size() == 0 ? -1 : q.element();
                    } else if(split1[0].equals("back")) {
                        m = q.size() == 0 ? -1 : q.peekLast();
                    } else if(split1[0].equals("size")) {
                        m = q.size();
                    } else if(split1[0].equals("empty")) {
                        m = q.size() == 0 ? 1 : 0;
                    }
                    sb.append(m).append("\n");
                }
            }
        }
        System.out.println(sb);

    }


}
