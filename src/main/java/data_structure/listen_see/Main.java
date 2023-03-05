package data_structure.listen_see;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int listen = Integer.parseInt(s[0]);
        int see = Integer.parseInt(s[1]);
        Map<String,Integer> myMap = new HashMap<>();
        for (int i = 0; i < listen; i++) {
            String listenName = br.readLine();
            myMap.put(listenName,1);
        }
        for (int i = 0; i < see; i++) {
            String seeName = br.readLine();
            myMap.put(seeName,myMap.getOrDefault(seeName,0)+1);
        }
        StringBuilder sb = new StringBuilder();
        Set<Map.Entry<String, Integer>> entries = myMap.entrySet();
        List<String> listenSeeList = new ArrayList<>();
        for(Map.Entry<String,Integer> entry: entries) {
            if(entry.getValue().equals(2)) {
                listenSeeList.add(entry.getKey());
            }
        }
        Collections.sort(listenSeeList);
        sb.append(listenSeeList.size()).append("\n");
        for (String value : listenSeeList) {
            sb.append(value).append("\n");
        }
        System.out.println(sb);
    }
}
