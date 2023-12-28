import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int[][] graph;
    static boolean[] check;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); // 컴퓨터의 대수
        int m = Integer.parseInt(br.readLine()); // 간선 개수
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

        dfs(1);
        System.out.println(count);
    }

    // 1번 노드와 연결된 노드 개수 구하기
    public static void dfs(int node) {
        check[node] = true;

        for (int i = 1; i < graph[node].length; i++) {
            if (graph[node][i] == 1 && !check[i]) {
                count++;
                dfs(i);
            }
        }
    }

}
