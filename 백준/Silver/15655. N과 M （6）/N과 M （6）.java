import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int n;
    static int m;
    static int[] numbers;
    static boolean[] check;
    static int[] output;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] nm = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        n = nm[0];
        m = nm[1];
        numbers = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .sorted()
                .toArray();

        check = new boolean[n];
        output = new int[n];
        dfs(0, 0, new int[m]);
    }

    public static void dfs(int depth, int start, int[] output) {
        // base case
        if (depth == m) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < output.length; i++) {
                sb.append(output[i]).append(" ");
            }
            System.out.println(sb);
            return;
        }

        // [1, 7, 8, 9]
        for (int i = start; i < n; i++) {
            if (check[i]) {
                continue;
            }

            check[i] = true;
            output[depth] = numbers[i];
            dfs(depth + 1, i + 1, output);
            check[i] = false;
        }
    }
}
