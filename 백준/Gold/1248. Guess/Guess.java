import java.io.*;
import java.util.*;

public class Main {
    private static int n;
    public static int[][] matrix;
    public static int[] res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        matrix = new int[n][n];
        res = new int[n];

        String s = br.readLine();
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                char c = s.charAt(cnt);
                if (c == '0') {
                    matrix[i][j] = 0;
                }
                if (c == '+') {
                    matrix[i][j] = 1;
                }
                if (c == '-') {
                    matrix[i][j] = -1;
                }
                cnt++;
            }
        }
        go(0);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(res[i]). append(" ");
        }
        System.out.println(sb);
    }

    private static boolean go(int idx) {
        if (idx == n) {
            // 정답을 찾은 경우
            return true;
        }

        if (matrix[idx][idx] == 0) {
            res[idx] = 0;
            if (check(idx) && go(idx + 1)) return true;
        }

        for (int i = 1; i <= 10; i++) {
            res[idx] = matrix[idx][idx] * i;
            if (check(idx) && go(idx + 1)) return true;
        }

        return false;
    }

    private static boolean check(int idx) {
        int sum = 0;
        for (int i = idx; i >= 0; i--) {
            sum += res[i];
            if (matrix[i][idx] == 0) {
                if(sum != 0) return false;
            }
            if (matrix[i][idx] > 0) {
                if (sum <= 0) return false;
            }
            if (matrix[i][idx] < 0) {
                if (sum >= 0) return false;
            }
        }
        return true;
    }
}
