import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] wine = new int[n];
        for (int i = 0; i < n; i++) {
            wine[i] = Integer.parseInt(br.readLine());
        }

        int[][] dp = new int[3][n];
        dp[0][0] = 0;
        dp[1][0] = wine[0];
        dp[2][0] = wine[0];

        for (int i = 1; i < n; i++) {
            // case1. {n}번째 포도주를 선택하지 않는 경우
            // max(dp[0][n-1], dp[1][n-1], dp[2][n-1])
            dp[0][i] = Math.max(dp[0][i - 1], Math.max(dp[1][i - 1], dp[2][i - 1]));

            // case2. {n - 1}번째 포도주를 선택하지 않고 {n} 번째 포도주를 선택하는 경우
            // dp[0][n - 1] + wine[n]
            dp[1][i] = dp[0][i - 1] + wine[i];

            // case3. {n - 1}번째 포도주를 선택하고 {n}번째 포도주를 선택하는 경우
            // dp[1][n-1] + wine[n]
            dp[2][i] = dp[1][i - 1] + wine[i];
        }

        System.out.println(Math.max(dp[0][n - 1], Math.max(dp[1][n - 1], dp[2][n - 1])));
    }
}
