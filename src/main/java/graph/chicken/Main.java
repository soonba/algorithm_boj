package graph.chicken;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Position {
    private final int row;
    private final int col;

    public Position(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public int calculate(Position position) {
        return Math.abs(row - position.getRow()) + Math.abs(col - position.getCol());
    }
}

class Chicken {
    private final Position position;

    public Chicken(Position position) {
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }
}

class House {
    private final Position position;

    public House(Position position) {
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }
}

//치킨집, 집을 리스트에 담는다. n^2
//모든 집을 순회하며 가까운 치킨집 순의 리스트를 담는다.
//치킨집 조합 배열을 순회하고 그 안에서 집을 순회하며 각 집별 가장 가까운 치킨집 include 의 거리 값을 계산한다.
//거리값의 합의 최소를 출력한다.

public class Main {
    static final List<List<Integer>> combinationList = new ArrayList<>();
    static List<Chicken> chickenList = new ArrayList<>();
    static List<House> houseList = new ArrayList<>();

    static void addCombination(List<Integer> arr, boolean[] visited, int n) {
        ArrayList<Integer> aCombination = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                aCombination.add(arr.get(i));
            }
        }
        combinationList.add(aCombination);
    }

    static void combination(List<Integer> arr, boolean[] visited, int start, int n, int r) {
        if (r == 0) {
            addCombination(arr, visited, n);
            return;
        }

        for (int i = start; i < n; i++) {
            visited[i] = true;
            combination(arr, visited, i + 1, n, r - 1);
            visited[i] = false;
        }
    }

    public static void main(String[] args) throws Exception {
        int N = read(); // n x n
        int M = read(); // 최대 개수

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int now = read();
                if (now == 1) {
                    houseList.add(new House(new Position(i, j)));
                }

                if (now == 2) {
                    chickenList.add(new Chicken(new Position(i, j)));
                }
            }
        }

        //치킨집의 크기만큼의 int 리스트 생성
        List<Integer> combinationTarget = IntStream.range(0, chickenList.size())
                .boxed()
                .collect(Collectors.toList());
        combination(combinationTarget, new boolean[combinationTarget.size()], 0, combinationTarget.size(), M);

        //각 조합을 돌며 최소값 갱신
        int minScore = Integer.MAX_VALUE;
        for (List<Integer> aCombination : combinationList) {
            int tempCount = 0;
            for (House house : houseList) {
                tempCount += aCombination.stream().map(m -> {
                    Chicken chicken = chickenList.get(m);
                    return house.getPosition().calculate(chicken.getPosition());
                }).min(Comparator.comparingInt(a -> a)).get();
            }
            minScore = Math.min(minScore, tempCount);
        }

        System.out.println(minScore);
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}