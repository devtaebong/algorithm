import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
3 15 => 3 (5,5,5)
3 16 => 4, (5, 5, 5, 1)
3 17 => 2, (5, 12)

k원을 만드는 동전의 최소 개수
d[k]: 동전의 최소 개수

- d[k-1]을 알고 있다고 가정
- d[k] = d[k - 1] + 1

- d[i] = 이미 만들어 놓은 금액
- d[i]에서 만들수 있는 금액을 만든다. => d[i] + 1
- 새롭게 만든 방법과 기존의 방법에서 최솟값 선택 => min(d[i] + 1, d[i + coin[x])


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
        for (int i = 1; i < k + 1; i++) {
            dp[i] = 10001;
        }

        for (int i = 0; i < n; i++) {
            if (coin[i] <= k) {
                dp[coin[i]] = 1;
            }
        }

        // d[i]: i원을 만들수 있는 동전의 최솟값
        for (int i = 1; i < k + 1; i++) {
            for (int x : coin) {
                // 방법1: {i}값의 동전 개수를 알고 있을때
//                if (i + x <= k) {
//                    dp[i + x] = Math.min(dp[i] + 1, dp[i + x]);
//                }

                // 방법2: {i}값을 만들고 싶을 때
                if (i - x >= 1) {
                    dp[i] = Math.min(dp[i - x] + 1, dp[i]);
                }
            }
        }

        if (dp[k] == 10001) {
            System.out.println(-1);
        } else {
            System.out.println(dp[k]);
        }
    }
}
