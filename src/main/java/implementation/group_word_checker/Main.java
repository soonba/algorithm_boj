package implementation.group_word_checker;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        scanner.nextLine();
        int count = 0;
        for (int i = 0; i < T; i++) {
            boolean[] alphabet = new boolean[26];
            String s = scanner.nextLine();
            int length = s.length();
            if (length == 1) {
                count++;
                continue;
            }

            for (int j = 0; j < length; j++) {
                int target = s.charAt(j);
                int arrayNum = target - 97;

                if (j == length - 1) {
                    if(!alphabet[arrayNum]) {
                        count ++;
                    }
                    continue;
                }

                int nextTarget = s.charAt(j + 1);
                if(target == nextTarget) {
                    continue;
                }

                if(alphabet[arrayNum]) {
                    break;
                }
                alphabet[arrayNum] = true;
            }
        }
        System.out.println(count);
    }
}

