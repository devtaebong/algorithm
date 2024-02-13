import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
d[i] = i원을 만드는데 필요한 동전의 최소 개수
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] input = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int n = input[0];
        int k = input[1];

        int[] coins = new int[n];
        int[] d = new int[k + 1];
        Arrays.fill(d, 100001);
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
            if (coins[i] <= k) {
                d[coins[i]] = 1;
            }
        }

        // d[i]를 만드는데 필요한 동전의 개수를 알고 있는 경우
        // d[i + coin] = min((d[i] + 1), d[i + coin))
        for (int coin : coins) {
            for (int i = 1; i < k + 1; i++) {
                if (i + coin < k + 1) {
                    d[i + coin] = Math.min(d[i + coin], d[i] + 1);
                }
            }
        }

        if (d[k] == 100001) {
            System.out.println(-1);
        } else {
            System.out.println(d[k]);
        }
    }
}
