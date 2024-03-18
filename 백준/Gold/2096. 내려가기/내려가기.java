import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
N줄에 0 ~ 9 숫자가 세개씩 적혀있음
첫줄에서 시작 마지막 줄에서 끝남
첫줄의 숫자를 골라 바로 아래수로 이동하거나 바로 아래수와 붙어있는 수로 이동 가능

dp[i][j] = max(dp[i - 1][nc] + matrix[i][j], dp[i][j])
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] matrix = new int[n][3];
        for (int i = 0; i < n; i++) {
            matrix[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        int[][] dpMax = new int[n][3];
        int[][] dpMin = new int[n][3];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dpMin[i], Integer.MAX_VALUE);
        }
        dpMax[0] = matrix[0];
        dpMin[0] = matrix[0];

        int[] dc = {-1, 0, 1};
        for (int i = 1 ; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    int nc = dc[k] + j;
                    if (nc >= 3 || nc < 0) {
                        continue;
                    }

                    dpMax[i][j] = Math.max(dpMax[i - 1][nc] + matrix[i][j], dpMax[i][j]);
                    dpMin[i][j] = Math.min(dpMin[i - 1][nc] + matrix[i][j], dpMin[i][j]);
                }
            }
        }

        int max = Math.max(dpMax[n - 1][0], Math.max(dpMax[n - 1][1], dpMax[n - 1][2]));
        int min = Math.min(dpMin[n - 1][0], Math.min(dpMin[n - 1][1], dpMin[n - 1][2]));

        System.out.println(max + " " + min);
    }
}
