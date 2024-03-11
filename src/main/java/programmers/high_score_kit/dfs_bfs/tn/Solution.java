package programmers.high_score_kit.dfs_bfs.tn;

public class Solution {
    static int count = 0;
    static int goal;
    static int maxDepth;
    static int[] numberArr;
    public int solution(int[] numbers, int target) {
        numberArr = numbers;
        maxDepth = numbers.length - 1;
        goal = target;
        dfs(0,0,1);
        dfs(0,0,-1);
        return count;
    }

    private void dfs(int depth, int tempSum, int operator) {
        tempSum += numberArr[depth] * operator;
        if(depth == maxDepth) {
            if(tempSum == goal) count++;
            return;
        }
        dfs(depth+1,tempSum,1);
        dfs(depth+1,tempSum,-1);
    }
}
