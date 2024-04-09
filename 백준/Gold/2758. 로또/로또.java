import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int n;
    static int m;
    static long[][] memo;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            int[] nm = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            n = nm[0];
            m = nm[1];

            memo = new long[n + 1][m + 1];
            for (int i = 0; i <= n; i++) {
                Arrays.fill(memo[i], -1);
            }

            solution();
        }
    }

    // 1 ~ m 까지 숫자 중 n개 고르기
    private static void solution() {
        System.out.println(dfs(n, m));
    }


    /**
     *
     * @param i 현재 depth의 인덱스
     * @param now 현재 depth의 원소
     * @return last에서 고를 수 있는 로또 개수
     */
    private static long dfs(int i, int now) {
        if (now == 0) {
            return 0;
        }

        if (i == 1) {
            return now;
        }

        if (memo[i][now] == -1) {
            memo[i][now] = dfs(i - 1, now / 2) + dfs(i, now - 1);
        }

        return memo[i][now];
    }
}
