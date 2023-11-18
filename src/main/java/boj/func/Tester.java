package boj.func;

import java.util.ArrayList;
import java.util.function.BiFunction;

public class Tester {
    public static void main(String[] args) throws Exception {
        ArrayList<String> G = new ArrayList<>();
        ArrayList<String> P = new ArrayList<>();
        G.add("999999");
        G.add("121211");
        P.add("99");
        P.add("11");
//        String process = process(ResultTest::gridSearch, G, P);
    }

    private static <T, U, V> V process(BiFunction<T, U, V> function, T a1, U a2) {
        return function.apply(a1, a2);
    }
}
