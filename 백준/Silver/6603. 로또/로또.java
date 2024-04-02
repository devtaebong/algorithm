import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
1 ~ 49 중 k개 선택
k개 중 6개를 선택할 수 있는 경우의 수

 */
public class Main {
    static int k;
    static int[] s;
    static boolean[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            int[] input = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            k = input[0];
            if (k == 0) break;
            s = new int[k];
            for (int i = 0; i < k; i++) {
                s[i] = input[i + 1];
            }
            check = new boolean[k];

            dfs(0, 0, "");
            System.out.println();
        }
    }

    private static void dfs(int depth, int start, String res) {
        if (depth == 6) {
            System.out.println(res);
            return;
        }

        for (int i = start; i < k; i++) {
            if (check[i]) {
                continue;
            }

            check[i] = true;
            dfs(depth + 1, i + 1, res + s[i] + " ");
            check[i] = false;
        }
    }
}
