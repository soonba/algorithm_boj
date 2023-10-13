package boj.gold.B9935;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String T = br.readLine();
        String boom = br.readLine();
        char startChar = boom.charAt(0);
        boolean[] isEliminated = new boolean[T.length()];

        int stackIndex = -1;
        List<Item> stack = new ArrayList<>();
        int boomLength = boom.length();
        for (int i = 0; i < T.length(); i++) {
            if (T.charAt(i) == startChar) {
                if(boomLength == 1) {
                    isEliminated[i] = true;
                } else {
                    stack.add(new Item(i, new int[boomLength]));
                    stackIndex++;
                }
                continue;
            }
            if (stackIndex == -1) continue;
            Item item = stack.get(stackIndex);
            int pointer = item.getPointer();
            if (boom.charAt(pointer) == T.charAt(i)) {
                item.record(i);
                if (item.isClear()) {
                    int[] compile = item.getCompile();
                    for (int c : compile) {
                        isEliminated[c] = true;
                    }
                    stack.remove(stackIndex--);
                }
            } else {
                stack.clear();
                stackIndex = -1;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < isEliminated.length; i++) {
            if (!isEliminated[i]) {
                sb.append(T.charAt(i));
            }
        }

        if (sb.length() == 0) {
            System.out.println("FRULA");
        } else {
            System.out.println(sb);
        }
    }

}

class Item {
    private int pointer;
    private final int[] compile;

    public Item(int startIndex, int[] compile) {
        this.pointer = 1;
        this.compile = compile;
        this.compile[0] = startIndex;
    }

    public int getPointer() {
        return pointer;
    }

    public int[] getCompile() {
        return compile;
    }

    public void record(int compileIndex) {
        compile[pointer++] = compileIndex;
    }

    public boolean isClear() {
        return pointer == compile.length;
    }
}