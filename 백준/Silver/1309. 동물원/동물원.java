import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*

dp[k] = k번째 열까지 사자를 배치하는 경우의 수

dp[r][i] = dp[l][i - 1] + dp[none][i - 1]
dp[l][i] = dp[r][i - 1] + dp[none][i - 1]
dp[none][i] = dp[l][i - 1] + dp[r][i - 1] + dp[none][i - 1]

        1   2   3
LEFT    1   2
RIGHT   1   2
NONE    1   3

    LEFT   RIGHT   NONE
1   1       1       1
2
3
 */

public class Main {
    public static void main(String[] args) throws IOException {
        int RIGHT = 0;
        int LEFT = 1;
        int NONE = 2;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[n + 1][3];
        dp[1][RIGHT] = 1;
        dp[1][LEFT] = 1;
        dp[1][NONE] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i][RIGHT] = (dp[i - 1][LEFT] + dp[i - 1][NONE]) % 9901;
            dp[i][LEFT] = (dp[i - 1][RIGHT] + dp[i - 1][NONE]) % 9901;
            dp[i][NONE] = (dp[i - 1][LEFT]+ dp[i - 1][RIGHT] + dp[i - 1][NONE]) % 9901;
        }

        int answer = 0;
        for (int i = 0; i < 3; i++) {
            answer = (answer + dp[n][i]) % 9901;
        }
        System.out.println(answer);
    }
}
