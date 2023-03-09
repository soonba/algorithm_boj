package greedy.meeting_room;

import java.util.*;

//https://www.acmicpc.net/problem/1931
public class Main {
    public static void main(String[] args) throws Exception {
        int T = read();
        List<Integer> sameMeetingIndex = new ArrayList<>();
        Queue<Meeting> queue = new PriorityQueue<>((a,b) -> {
            if(a.getEnd() == b.getEnd()) {
                return a.getTime() - b.getTime();
            }
            return a.getEnd() - b.getEnd();
        });
        int max = 0;
        for (int i = 0; i < T; i++) {
            int start = read();
            int end = read();
            max = Math.max(max, end);
            if(start == end) {
                sameMeetingIndex.add(start);
            }
            queue.add(new Meeting(start, end));
        }
        MeetingRoom meetingRoom = new MeetingRoom(new boolean[max+1],sameMeetingIndex);

        while(!queue.isEmpty()) {
            Meeting poll = queue.poll();
            meetingRoom.useIfNotUsed(poll);
        }

        System.out.println(meetingRoom.getSize());

    }


    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}
class MeetingRoom {
    private final boolean[] meetingRoomUsed;
    private int meetingCount = 0;
    private final List<Integer> sameMeetingList;
    public MeetingRoom(boolean[] meetingRoomUsed, List<Integer> sameMeetingList) {
        this.meetingRoomUsed = meetingRoomUsed;
        this.sameMeetingList = sameMeetingList;
    }

    public void useIfNotUsed(Meeting meeting) {
        int start = meeting.getStart();
        int end = meeting.getEnd();
        boolean anyUsed = false;
        if(start==end) {
            meetingCount++;
            return;
        }
        for (int i = start; i < end; i++) {
            if(meetingRoomUsed[i]) {
                anyUsed = true;
                break;
            }
        }
        for (Integer index : sameMeetingList) {
            if (start < index && index < end) {
                anyUsed = true;
                break;
            }
        }
        if(!anyUsed) {
            for (int i = start; i < end; i++) {
                meetingRoomUsed[i] = true;
            }
            meetingCount ++;
        }
    }
    public int getSize() {
        return meetingCount;
    }
}
class Meeting {
    private final int time;
    private final int start;
    private final int end;

    public Meeting(int start, int end) {
        this.time = end-start;
        this.start = start;
        this.end = end;
    }

    public int getTime() {
        return time;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }
}
