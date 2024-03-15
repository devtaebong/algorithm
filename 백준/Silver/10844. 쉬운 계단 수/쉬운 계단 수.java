import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
dp[i][j] = 길이가 i이고 마지막 숫자가 j인 경우

1  2  3  4  5  6  7  8  9
1  1  1  1  1  1  1  1  1


101

j == 0
21

   0  1  2  3  4  5  6  7  8  9
1     1  1  1  1  1  1  1  1  1
2  1  1
3

dp[i][j]
j == 0 : dp[i - 1][j + 1]
j == 9 : dp[i - 1][j - 1]
j == 1 ~ 8 : dp[i - 1][j + 1] + dp[i - 1][j - 1]
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int MOD = 1_000_000_000;
        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[n + 1][10];
        Arrays.fill(dp[1], 1);
        dp[1][0] = 0;

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j <= 9; j++) {
                // 마지막 숫자가 0인 경우
                if (j == 0) {
                    dp[i][j] = dp[i - 1][1] % MOD;
                }

                // 마지막 숫자가 9인 경우
                else if (j == 9) {
                    dp[i][j] = dp[i - 1][8] % MOD;
                }

                // 마지막 숫자가 1 ~ 8인 경우
                else {
                    dp[i][j] = (dp[i - 1][j + 1] + dp[i - 1][j - 1]) % MOD;
                }
            }
        }
        
        int answer = 0;
        for (int i = 0; i <=9; i++) {
            answer = (answer + dp[n][i]) % MOD;
        }

        System.out.println(answer);
    }
}
