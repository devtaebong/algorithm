import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
1 ~ m 까지 n개의 수 고른다
이전에 고른 수보다 2배 이상 수만 고를 수 있음
 */
public class Main {
    private static int n;
    private static int m;
    private static long[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int[] nm = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            n = nm[0];
            m = nm[1];

            // row: 고른 수의 갯수, col: 마지막 값
            dp = new long[n + 1][m + 1];
            for (int i = 0; i < n + 1; i++) {
                Arrays.fill(dp[i], -1);
            }

            long res = dfs(n, m);
            System.out.println(res);
        }
    }

    private static long dfs(int i, int last) {
        if (i == 1) {
            return last;
        }

        if (last <= 0) {
            return 0;
        }

        if (dp[i][last] == -1) {
            dp[i][last] = dfs(i - 1, last / 2) + dfs(i, last - 1);
        }

        return dp[i][last];
    }
}
