package programmers.two_queue;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;
//https://school.programmers.co.kr/learn/courses/30/lessons/118667
// queue1 뒤에 안붙여준 <반례1>
// q1 = [1,1,1,8,10,9], q2 = [1,1,1,1,1,1]
//sum1,sum2 int <반례2> (TC 19,20 23~27)
// **주의: 언어에 따라 합 계산 과정 중 산술 오버플로우 발생 가능성이 있으므로 long type 고려가 필요합니다.**
public class Solution {

    public int solution(int[] queue1, int[] queue2) {
        long sum1 = Arrays.stream(queue1).sum();
        long sum2 = Arrays.stream(queue2).sum();
        //각 queue 를 이어붙인 긴 배열을 생성 <반례1>에 의해 뒤에 queue1을 한 번 더 붙여줌
        int[] concatArray = Stream.of(queue1, queue2, queue1).flatMapToInt(IntStream::of).toArray();

        long total = sum1 + sum2;
        //홀수라면 -1
        if (isOdd(total)) return -1;
        long target = total / 2;
        int p1 = 0, p2 = queue1.length, counter = 0;

        //p1, p2 두 포인터 중 하나라도 끝까지 갔다면 탈출
        while (p1 < concatArray.length && p2 < concatArray.length) {
            if (sum1 == target) break;
            // 첫번째 큐로만 비교
            // target 보다 크면 왼->오 로 옮김, 작으면 반대. 인덱스 ++
            sum1 = sum1 > target ? sum1 - concatArray[p1++] : sum1 + concatArray[p2++];
            counter++;
        }
        if (sum1 != target) return -1;
        return counter;
    }

    private boolean isOdd(long total) {
        return total % 2 == 1;
    }
}