package dynamic_programming.sequence;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] NK = br.readLine().split(" ");    
    int k = Integer.parseInt(NK[1]);
    String[] strs = br.readLine().split(" ");
    int[] nums = Arrays.stream(strs).mapToInt(el -> Integer.parseInt(el)).toArray();    
    int maxValue = 0;
    for (int i = 0; i < k; i++) {
      maxValue += nums[i];
    }
    int left = 0;
    int nowValue = maxValue;
    for (int right = k; right < nums.length; right++) {
      nowValue = nowValue - nums[left++] + nums[right];
      maxValue = Math.max( maxValue, nowValue );
    }
    System.out.println(maxValue);
  }
}
