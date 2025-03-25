package dynamic_programming.go_down;


public class Main {
  
  public static void main(String[] args) throws Exception {

    int T = read();
    int[][] arr = new int[T][3];
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < 3; j++) {
        arr[i][j] = read();
      }
    }
    int[][] DP_MAX = new int[T][3];
    int[][] DP_MIN = new int[T][3];
    DP_MAX[0][0] = arr[0][0]; DP_MIN[0][0] = arr[0][0];
    DP_MAX[0][1] = arr[0][1]; DP_MIN[0][1] = arr[0][1];
    DP_MAX[0][2] = arr[0][2]; DP_MIN[0][2] = arr[0][2];

    for (int i = 1; i < DP_MAX.length; i++) {            
        DP_MAX[i][0] =  Math.max(DP_MAX[i-1][0],DP_MAX[i-1][1]) + arr[i][0];
        DP_MAX[i][1] =  Math.max(DP_MAX[i-1][0],Math.max(DP_MAX[i-1][1],DP_MAX[i-1][2])) + arr[i][1];
        DP_MAX[i][2] =  Math.max(DP_MAX[i-1][1],DP_MAX[i-1][2]) + arr[i][2];
        DP_MIN[i][0] =  Math.min(DP_MIN[i-1][0],DP_MIN[i-1][1]) + arr[i][0];
        DP_MIN[i][1] =  Math.min(DP_MIN[i-1][0],Math.min(DP_MIN[i-1][1],DP_MIN[i-1][2])) + arr[i][1];
        DP_MIN[i][2] =  Math.min(DP_MIN[i-1][1],DP_MIN[i-1][2]) + arr[i][2];
    }
    StringBuilder sb = new StringBuilder();
    sb.append(Math.max(DP_MAX[T-1][0], Math.max( DP_MAX[T-1][1],DP_MAX[T-1][2] ))).append(" ").append(Math.min(DP_MIN[T-1][0], Math.min( DP_MIN[T-1][1],DP_MIN[T-1][2] ) ));
    System.out.println(sb.toString());
  }
  private static int read() throws Exception {
    int c, n = System.in.read() & 15;
    while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
    return n;
}
}