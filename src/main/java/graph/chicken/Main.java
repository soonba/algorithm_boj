package graph.chicken;

import java.util.ArrayList;
import java.util.List;

class Location {
    private final int r;
    private final int c;

    private int score; //치킨집 한정

    public Location(int r, int c) {
        this.r = r;
        this.c = c;
    }

    public void addChickenDistance(Location location) {
        score += Math.abs(r-location.r) + Math.abs(c-location.c);
    }

    public int getScore() {
        return score;
    }
}

public class Main {

    static List<Location> houseList = new ArrayList<>();
    static List<Location> chickenList = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        int N = read(); // n x n 크기
        int M = read(); // M개 남김

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int now = read();
                if (now == 1) {
                    Location location = new Location(i, j);
                    addAllChickenScore(location);
                    houseList.add(location);
                } else if (now == 2) {
                    Location location = new Location(i, j);
                    chickenList.add(initChickenScore(location));
                }
            }

        }

        chickenList.sort((a,b) -> b.getScore() - a.getScore());
        int total = 0;
        for (int i = 0; i < M; i++) {
            total += chickenList.get(i).getScore();
        }
        System.out.println(total);
    }

    private static Location initChickenScore(Location location) {
        //치킨집의 시작 점수 초기화
        houseList.forEach(location::addChickenDistance);
        return location;
    }

    private static void addAllChickenScore(Location location) {
        // 집이 나오면 기존의 모든 치킨집에 스코어를 반영한다.
        chickenList.forEach(chicken -> chicken.addChickenDistance(location));
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}
