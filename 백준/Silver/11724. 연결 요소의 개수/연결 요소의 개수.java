import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int[][] graph;
    static int count;
    static boolean[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int n = input[0];
        int m = input[1];

        graph = new int[n + 1][n + 1];
        check = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
            int[] x = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int a = x[0];
            int b = x[1];
            graph[a][b] = 1;
            graph[b][a] = 1;
        }

        for (int i = 1; i < n + 1; i++) {
            if (!check[i]) {
                count++;
                dfs(i);
            }
        }
        System.out.println(count);
    }

    public static void dfs(int node) {
        check[node] = true;

        for (int i = 1; i < graph[node].length; i++) {
            if (graph[node][i] == 1 && !check[i]) {
                dfs(i);
            }
        }
    }
}
