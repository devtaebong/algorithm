import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/*
d[n]: n잔 까지 마실수 있는 포도주의 최대량

- 연속해서 3잔의 포도주를 선택할 수 없다.
    - case1: n번을 선택하지 않은 경우
    - case2: n-1을 선택하고 n번을 선택한 경우
    - case3: n-1을 선택하지 않고 n번을 선택한 경우
    - n-2, n-1, n을 모두 선택할 수 없다.
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int[][] dp = new int[3][n];
        dp[0][0] = 0;
        dp[1][0] = arr[0];
        dp[2][0] = arr[0];

        // case1: n번을 선택하지 않은 경우 => dp[0][n]
        // max(dp[0][n-1], dp[1][n-1], dp[2][n-2]) => n번을 선택하지 않기 때문에

        // case2: n-1을 선택하지 않고 n번을 선택한 경우 => dp[1][n]
        // dp[0][n-1] + arr[n]

        // case3: n-1을 선택하고 n번을 선택한 경우 => dp[2][n]
        // dp[1][n-1] + arr[n]
        for (int i = 1; i < n; i++) {
            // case1: n번을 선택하지 않은 경우 => 이전값 중 max값 선택
            dp[0][i] = Math.max(dp[0][i - 1], Math.max(dp[1][i - 1], dp[2][i - 1]));

            // case2: n-1을 선택하지 않고 n을 선택하는 경우 => dp[0][i-1]
            dp[1][i] = dp[0][i - 1] + arr[i];

            // case3: n-1을 선택하고 n을 선택하는 경우 => dp[1][i] + arr[i]
            dp[2][i] = dp[1][i - 1] + arr[i];
        }

        // 정답: max(dp[0][n], dp[1][n], dp[2][n])
        System.out.println(Math.max(dp[0][n - 1], Math.max(dp[1][n - 1], dp[2][n - 1])));
    }
}
