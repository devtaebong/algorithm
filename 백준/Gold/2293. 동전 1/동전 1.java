import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
dp[k] = 동전을 조합해서 k원을 만들 수 있는 경우의 수
- dp[k - 1]의 결과를 알고 있다고 가정


    0  1  2  3  4  5  6  7  8  9  10
1 | 1  1  1  1  1  1  1  1  1  1  1
2 | 1  1  2  2  3



coin = [1, 2, 5]

d[1] = 1
d[2] = 1+1, 2
d[3] = 1+1+1, 1+2
d[4] = 1+1+1+1, 1+1+2, 2+2 => d[4 - 1] + d[4 - 2]

d[j] = d[j] + d[j - coin]

0  1  2  3  4  5  6  7  8  9  10
1  1  1  1  1  1  1  1  1  1  1

-- 1원짜리 동전을 사용하는 경우 --
d[1] = d[1] + d[1 - 1]
d[2] = d[2] + d[2 - 1]
...
d[10] = d[10] + d[10 - 1]

-- 2원짜리 동전을 사용하는 경우 --
d[1] = d[1] + d[1 - 2]
d[2] = d[2] + d[2 - 2] // 1+1, 2
d[3] = d[3] + d[3 - 2] // d[1]의 경우의 수에서 2원을 추가로 사용하는 경우 (1 + 2)
d[4] = d[4] + d[4 - 2] // 1+1+1+1, 1+1+2, 2+2

d[2][4] = d[1][4] + d[2][2]
d[i][j] = d[i - 1][j] + d[i][j - coin]
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] input = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int n = input[0];
        int k = input[1];

        int[] coin = new int[n];
        for (int i = 0; i < n; i++) {
            coin[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[k + 1];
        dp[0] = 1;

        for (int i = 1; i < n + 1; i++) {
            int coinValue = coin[i - 1]; // 주어진 동전 각각의 가치

            for (int j = 1; j < k + 1; j++) {
                if (j - coinValue < 0) {
                    continue;
                }

                dp[j] = dp[j] + dp[j - coinValue];
            }
        }

        System.out.println(dp[k]);
    }
}
