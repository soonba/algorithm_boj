package hackerank.encryption;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'encryption' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String encryption(String s) {
        String replaced = s.replaceAll(" ", "");
        int length = replaced.length();
        int r = ((int) Math.sqrt(length)) % 10;
        int c = r * r == length ? r : r+1;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < c; i++) {
            for (int j = i; j < length; j = j + c) {
                sb.append(replaced.charAt(j));
            }
            sb.append(" ");
        }
        return sb.toString();
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        String s = bufferedReader.readLine();

        String s = "";
        String result = Result.encryption(s);

//        bufferedWriter.write(result);
//        bufferedWriter.newLine();
//
//        bufferedReader.close();
//        bufferedWriter.close();
    }
}

