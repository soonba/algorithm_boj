package boj.gold;

// 1. 물건을 쪼갤 수 없음 -> 0-1 배낭 문제
// 2. 점화식을 찾는다.
// 2-1. 무게나 값에 상관없이 물건들을 순회하며(i) k 크기 가방의 최대 값어치인 DP[i][k] 값을 업데이트한다.
// 2-2. DP[i][k]는 기본적으로 DP[i-1][k] 이상이다. (같은 크기에서 순회할수록 값이 더 커지기만 할 것이기 때문)
// 2-3. 그리고 DP[i][k] 는 W[i] 만큼 무게를 뺀 것의 가치합인 DP[i-1][k-W[i]] 의 값과, 해당 무게의 가치 V[i]를 더한 값일 수 있다.
// 2-4. 만약... 8번째(8무게 가방)에서 8무게를 i=3 번째에서 만난다면... DP[3-1][8-8] => DP[2][0] 이 되므로... 무조건 0 리턴
// 2-4-1. 이는 결국 8무게에 8담는 것. 따라서 안 나누는 경우도 존재. (제일 처음 해당 무게를 담을 수 있을 때 수행됨)
// 2-4. DP[i-1][k-W[i]] 에서 DP[i-1] 까지인 이유는... 바로 직전까지의 최대 가치를 가져오고 싶기 때문..
// 2-5 따라서 점화식은 i번째 물건, 최대 배낭무게 k에 대해 DP[i][k] = Math.max(DP[i-1][k], DP[i-1][k-W[i]] + V[i]) 가 됨
// 3. DP[0][?] DP[?][0]들은 모두 0으로 초기화하여 인덱스 관련 예외 제거..(i는 2개이상 뛰어넘지 않으므로, for문을 1부터 시작하면 에러 안 남)
// 4. n^2 순회...

public class B12865 {
    public static void main(String[] args) throws Exception {
        int N = read(); //물품
        int K = read(); //버티는 무게

        int[] W = new int[N+1]; //무게
        int[] V = new int[N+1]; //가치
        for (int i = 1; i <= N; i++) {
            W[i] = read();
            V[i] = read();
        }
        //N행 K+1열 2차원 DP 테이블 초기화
        int[][] DP = new int[N+1][K+1];

        for (int k = 1; k <= K; k++) {
            for (int i = 1; i <= N; i++) {
                if(k-W[i] < 0) {
                    int i1 = DP[i - 1][k];
                    DP[i][k] = i1;
                } else {
                    DP[i][k] = Math.max(DP[i - 1][k], DP[i - 1][k - W[i]] + V[i]);
                }
            }
        }

        System.out.println(DP[N][K]);
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}
