import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
2 x n 직사각형을 1x2, 2x1, 2x2 도형으로 채우는 방법의 수

dp[i] = 가로 길이가 i인 직사각형을 채울 수 있는 경우의 수
dp[1] = 1
dp[2] = 3
dp[3]
    - 2 x 1인 도형을 놓는 경우 => d[2]
    - 1 x 2 도형을 두개 놓는 경우 => d[1]
    - 2 x 2 도형을 놓는 경우 => d[1]
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        if (n == 1) {
            System.out.println(1);
            return;
        }

        if (n == 2) {
            System.out.println(3);
            return;
        }

        long[] dp = new long[n + 1];
        dp[1] = 1;
        dp[2] = 3;

        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + (dp[i - 2] * 2)) % 10007;
        }

        System.out.println(dp[n]);
    }
}
