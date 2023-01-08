package math.fly_me_to_the_alpha_centauri;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();

        for (int i = 0; i < T; i++) {
            double x = in.nextDouble();
            double y = in.nextDouble();

            double target = y - x;
            double sqrt = Math.sqrt(target);
            int floor = (int) Math.floor(sqrt);
            int count = floor * 2;
            if (target == floor * floor) {
                count--;
            }
            if (target > (floor * (floor + 1))) {
                count++;
            }
            System.out.println(count);
        }
    }
}

