import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
n가지의 동전을 사용해서 k원이 되도록
동전의 가치는 10만 이하

1원을 사용해서 10원을 만드는 경우
coin: [1, 2, 5]

    1  2  3  4  5  6  7  8  9  10
1   1  1  1  1  1  1  1  1  1  1
2   0  1  1  2
5

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
        int[] d = new int[k + 1];
        d[0] = 1;

        for (int i = 0; i < n; i++) {
            // 현재 동전의 가치가 만들어야 하는 금액보다 크면 연산 X
            if (coin[i] > k) {
                continue;
            }

            // 점화식: d[j] += d[j - coin[i]]
            for (int j = coin[i]; j < k + 1; j++) {
                d[j] += d[j - coin[i]];
            }
        }

        System.out.println(d[k]);
    }
}
