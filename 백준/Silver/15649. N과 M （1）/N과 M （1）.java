import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int M;
    static int[] selected;
    static boolean[] check;

    public static void main(String[] args) throws IOException {
        input();

        // N까지 자연수 중 중복없이 M개의 수를 고른다.
        recursive(1);

        System.out.println(sb);
    }

    // k ~ N 까지 조합을 선택한다.
    public static void recursive(int k) {
        // 조건을 만족하는 경우
        if (k == M + 1) {
            for (int i = 1; i < selected.length; i++) {
                sb.append(selected[i]).append(' ');
            }
            sb.append("\n");
        }

        // 조건에 해당하는 경우를 찾지 못한경우
        else {
            for (int candidate = 1; candidate <= N; candidate++) {
                if (check[candidate]) {
                    continue;
                }

                check[candidate] = true;
                selected[k] = candidate;
                recursive(k + 1);
                check[candidate] = false;
                selected[k] = 0;
            }
        }
    }

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] nm = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        N = nm[0];
        M = nm[1];

        selected = new int[M + 1];
        check = new boolean[N + 1];
    }
}
