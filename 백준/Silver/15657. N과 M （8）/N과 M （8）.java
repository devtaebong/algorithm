import java.io.*;
import java.util.*;

public class Main {
    static int n ,m;
    static int[] numbers;
    static boolean[] check;
    static int[] output;

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

        recursive(0, 0);
        System.out.println(sb);
    }

    static StringBuilder sb = new StringBuilder();
    public static void recursive(int depth, int start) {
        // base case
        if (depth == m) {
            // todo: 출력
            for (int i = 0; i < m; i++) {
                sb.append(output[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        // recursive case
        for (int i = start; i < n; i++) {
            output[depth] = numbers[i];
            recursive(depth + 1, i);
        }
    }
}
