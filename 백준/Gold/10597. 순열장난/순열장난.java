import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static String kriii;
    static int n;
    static int[] res;
    static boolean[] check;
    static StringBuilder sb = new StringBuilder();
    static boolean isFoundAnswer = false;

    public static void main(String[] args) throws IOException {
        input();
        solution(0, kriii);
        System.out.println(sb);
    }

    public static void solution(int depth, String str) {
        if (isFoundAnswer) return;
        // base case
        if (str.isEmpty()) {
            for (int i = 0; i < n; i++) {
                sb.append(res[i]).append(" ");
            }
            isFoundAnswer = true;
        }

        // recursive case
        else {
            for (int i = 1; i <= 2; i++) {
                if (str.length() < i) continue;

                int target = Integer.parseInt(str.substring(0, i));
                if (target > n) continue;
                if (!check[target]) {
                    check[target] = true;
                    res[depth] = target;
                    solution(depth + 1, str.substring(i));
                    check[target] = false;
                    res[depth] = 0;
                }
            }
        }
    }

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        kriii = br.readLine();

        if (kriii.length() < 10) {
            n = kriii.length();
        } else {
            n = (kriii.length() - 9) / 2 + 9;
        }

        res = new int[n + 1];
        check = new boolean[n + 1];
    }
}
