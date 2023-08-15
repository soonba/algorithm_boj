package hackerank.tuto;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class Result {

    /*
     * Complete the 'diagonalDifference' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY arr as parameter.
     */

    public static void plusMinus(List<Integer> arr) {
        int size = arr.size();
        int zero = 0;
        int positive = 0;
        int negative = 0;
        for (int i = 0; i < arr.size(); i++) {
            int el = arr.get(i);
            if (el == 0) zero++;
            if (el > 0) positive++;
            if (el < 0) negative++;
        }
        System.out.printf("%.4f\n", (double) positive / size);
        System.out.printf("%.4f\n", zero / size);
        System.out.printf("%.4f\n", negative / size);
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        int n = Integer.parseInt(bufferedReader.readLine().trim());
//
//        List<List<Integer>> arr = new ArrayList<>();
//
//        IntStream.range(0, n).forEach(i -> {
//            try {
//                arr.add(
//                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
//                                .map(Integer::parseInt)
//                                .collect(toList())
//                );
//            } catch (IOException ex) {
//                throw new RuntimeException(ex);
//            }
//        });
        List<List<Integer>> arr = new ArrayList<>();
        arr.add(List.of(11, 2, 4));
        arr.add(List.of(4, 5, 6));
        arr.add(List.of(10, 8, -12));
//        3
//        11 2 4
//        4 5 6
//        10 8 -12
//        int result = Result.diagonalDifference(arr);
//        System.out.println(result);
//
//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedReader.close();
//        bufferedWriter.close();
    }
}
