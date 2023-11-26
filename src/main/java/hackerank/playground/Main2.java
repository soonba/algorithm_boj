package hackerank.playground;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main2 {
    public static void main(String[] args) throws Exception {

        String fn = "abcd.txt";
        String property = System.getProperty("user.dir");
        BufferedReader bufferedReader = new BufferedReader(
                new FileReader(property + "/" + fn)
        );
        String text;
        SortedSet<String> fileSet = new TreeSet<>();
//        SortedSet<String> fileSet = new HashSet<>();

        while ((text = bufferedReader.readLine()) != null) {
            String[] split = text.split(" ");
            String substring = split[split.length-2];
            System.out.println(substring);
            Pattern pattern = Pattern.compile("[^/]+\\.(?i)gif");
            Matcher matcher = pattern.matcher(text);
            if(substring.equals("200")) {
                while(matcher.find()) {
                    String fileName = matcher.group();
                    fileSet.add(fileName);
                }
            }
        }

        fileSet.forEach(System.out::println);



    }
    public static List<List<String>> getStatForRequests2(int m, List<String> database, List<String> requests) {
        List<List<String>> result = new ArrayList<>();
        int[] users = new int[m];
        Map<String, Integer> shortUrlAndUserMap = new HashMap<>();
        Map<String, String> shortUrlAndActualUrlMap = new HashMap<>();
        for (int i = 0; i < database.size(); i++) {
            String now = database.get(i);
            String[] split = now.split(" ");
            int userId = Integer.parseInt(split[0]);
            shortUrlAndUserMap.put(split[1], userId);
            shortUrlAndActualUrlMap.put(split[1], split[2]);
        }

        for (int i = 0; i < requests.size(); i++) {
            List<String> aResult = new ArrayList<>();
            String aRequest = requests.get(i);
            Integer userId = shortUrlAndUserMap.get(aRequest);
            aResult.add(shortUrlAndActualUrlMap.get(aRequest));
            aResult.add(String.valueOf(++users[userId]));
            result.add(aResult);
        }
        return result;
    }
}
