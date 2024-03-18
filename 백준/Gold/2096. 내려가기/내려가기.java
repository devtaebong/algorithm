import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
N줄에 0 ~ 9 숫자가 세개씩 적혀있음
첫줄에서 시작 마지막 줄에서 끝남
첫줄의 숫자를 골라 바로 아래수로 이동하거나 바로 아래수와 붙어있는 수로 이동 가능

dp[i][j] = max(dp[i - 1][nc] + matrix[i][j], dp[i][j])

300000 x 4
1200 kb
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] dpMax = new int[5];
        int[] tempMax = new int[5];
        int[] dpMin = new int[5];
        int[] tempMin = new int[5];

        dpMin[0] = 1000001;
        dpMin[4] = 1000001;

        /*
        temp[x] = max(d[x - 1] + arr[x], d[x] + arr[x], d[x + 1] + arr[x])
        d[x] = temp[x]

        6 8 9
         */

        for (int i = 0; i < n; i++) {
            // 12 Byte
            int[] arr = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            for (int j = 1; j <= 3; j++) {
                tempMax[j] = arr[j - 1] + Math.max(dpMax[j - 1], Math.max(dpMax[j], dpMax[j + 1]));
                tempMin[j] = arr[j - 1] + Math.min(dpMin[j - 1], Math.min(dpMin[j], dpMin[j + 1]));
            }

            for (int j = 1; j <= 3; j++) {
                dpMax[j] = tempMax[j];
                dpMin[j] = tempMin[j];
            }

        }

        int max = Math.max(dpMax[1], Math.max(dpMax[2], dpMax[3]));
        int min = Math.min(dpMin[1], Math.min(dpMin[2], dpMin[3]));

        System.out.println(max + " " + min);
    }
}
