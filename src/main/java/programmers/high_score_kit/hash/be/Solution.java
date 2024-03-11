package programmers.high_score_kit.hash.be;

import java.util.*;

public class Solution {
    static List<Integer> answerList = new ArrayList<>();
    public int[] solution(String[] genres, int[] plays) {
        Map<String, GenreInfo> map = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            String nowGenre = genres[i];
            int nowScore = plays[i];
            GenreInfo orDefault = map.getOrDefault(nowGenre, new GenreInfo());
            orDefault.add(new Album(i, nowScore));
            map.put(nowGenre,orDefault);
        }

        Queue<GenreInfo> gQ = new PriorityQueue<>((g1,g2) -> g2.total - g1.total);
        for (String key: map.keySet()) {
            gQ.add(map.get(key));
        }
        while(!gQ.isEmpty()){
            GenreInfo poll = gQ.poll();
            poll.addTop2();
        }
        return answerList.stream().mapToInt(i -> i).toArray();
    }

    static class GenreInfo {
        private int total = 0;
        private final PriorityQueue<Album> el = new PriorityQueue<>((a1,a2) -> a2.score - a1.score);
        public GenreInfo() {}

        void add(Album album) {
            total+= album.score;
            el.add(album);
        }

        void addTop2() {
            if(!el.isEmpty()) answerList.add(el.poll().index);
            if(!el.isEmpty()) answerList.add(el.poll().index);
        }

    }

    static class Album {
        private final int index;
        private final int score;

        public Album(int index, int score) {
            this.index = index;
            this.score = score;
        }
    }
}

