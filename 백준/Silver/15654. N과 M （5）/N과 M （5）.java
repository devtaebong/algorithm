import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[] numbers;
    static int[] output;
    static boolean[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        check = new boolean[n];
        output = new int[m];

        String[] input = br.readLine().split(" ");
        numbers = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(numbers);

        recursive(0);
    }

    public static void recursive(int depth) {
        // base case
        if (depth == m) {
            // 출력
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < m; i++) {
                sb.append(output[i]).append(" ");
            }
            System.out.println(sb);
            return;
        }

        // recursive case
        for (int i = 0; i < n; i++) {
            if (!check[i]) {
                check[i] = true;
                output[depth] = numbers[i];
                recursive(depth + 1);
                check[i] = false;
            }
        }

    }
}
