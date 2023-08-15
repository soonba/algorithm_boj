package hackerank.playground;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws Exception {
        List<List<String>> statForRequests = getStatForRequests2(3, List.of("0 a www", "1 b goo", "0 c gle"), List.of("a", "b", "c"));
        for (int i = 0; i < statForRequests.size(); i++) {
            List<String> strings = statForRequests.get(i);
            for (int j = 0; j < strings.size(); j++) {
                System.out.print(strings.get(j));
                System.out.print(" ");
            }
            System.out.println("");
        }
    }

    public static List<List<String>> getStatForRequests(int m, List<String> database, List<String> requests) {
        List<List<String>> result = new ArrayList<>();
        int[] users = new int[m];
        Map<String,Integer> shortUrlAndUserMap = new HashMap<>();
        Map<String, String> shortUrlAndActualUrlMap = new HashMap<>();
        for (int i = 0; i < database.size(); i++) {
            String now = database.get(i);
            String[] split = now.split(" ");
            int userId = Integer.parseInt(split[0]);
            shortUrlAndUserMap.put(split[1],userId);
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

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}
