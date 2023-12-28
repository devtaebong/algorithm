import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int[][] matrix;
    static boolean[] check;
    static Queue<Integer> q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int n = input[0];
        int m = input[1];
        int v = input[2];

        matrix = new int[n + 1][n + 1];

        for (int i = 0; i < m; i++) {
            int[] x = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            int a = x[0];
            int b = x[1];
            matrix[a][b] = 1;
            matrix[b][a] = 1;
        }

        check = new boolean[n + 1];
        dfs(v);
        System.out.println();

        check = new boolean[n + 1];
        bfs(v);
        System.out.println();
    }

    public static void bfs(int node) {
        q = new LinkedList<>();
        q.add(node);
        check[node] = true;

        while (!q.isEmpty()) {
            int now = q.poll();
            System.out.print(now + " ");

            for (int i = 0; i < matrix[node].length; i++) {
                if (!check[i] && matrix[now][i] == 1) {
                    check[i] = true;
                    q.add(i);
                }
            }
        }
    }

    public static void dfs(int node) {
        check[node] = true;
        System.out.print(node + " ");

        for (int i = 1; i < matrix[node].length; i++) {
            if (matrix[node][i] == 1 && !check[i]) {
                dfs(i);
            }
        }
    }
}
