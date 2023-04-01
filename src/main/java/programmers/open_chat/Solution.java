package programmers.open_chat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//programmers 42888 오픈채팅방
public class Solution {
    List<String[]> outputMessage = new ArrayList<>();
    Map<String,String> user = new HashMap<>();
    public String[] solution(String[] record) {
        for (String message : record) {
            String[] parseMessage = parse(message);
            String action = parseMessage[0];
            String userIdx = parseMessage[1];

            if(!action.equals("Leave")) {
                String userName = parseMessage[2];
                user.put(userIdx, userName);
            }
            recordOutputMessage(action, userIdx);
        }

        return outputMessage.stream().map(message -> {
            String finalName = user.get(message[1]);
            String finalMessage = message[0].equals("Enter") ? "님이 들어왔습니다." : "님이 나갔습니다.";
            return finalName+finalMessage;
        }).toArray(String[]::new);
    }

    private void recordOutputMessage(String action, String userIdx) {
        if(action.equals("Enter") || action.equals("Leave")) {
            outputMessage.add(new String[]{action,userIdx});
        }
    }

    private String[] parse(String message) {
        return message.split(" ");
    }
}

