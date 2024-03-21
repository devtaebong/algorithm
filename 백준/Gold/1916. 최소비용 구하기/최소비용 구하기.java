import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
A번째 도시에서 B번째 도시까지 가는데 드는 최소 비용

5
8
1 2 2
1 3 3
1 4 1
1 5 10
2 4 2
3 4 1
3 5 1
4 5 3
1 5

 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final int INF = 1_000_000_001; // 프로그램에서 나올 수 있는 최댓값보다 큰 값
        int n = Integer.parseInt(br.readLine()); // 도시의 개수
        int m = Integer.parseInt(br.readLine()); // 한 도시에서 출발하여 다른 도시에 도착하는 버스의 개수

        // i -> j 이동시 드는 최소 비용
        int[][] matrix = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(matrix[i], INF);
        }

        for (int i = 0; i < m; i++) {
            int[] x = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int a = x[0];
            int b = x[1];
            int c = x[2];

            if (matrix[a][b] > c) {
                matrix[a][b] = c;
            }
        }

        int[] y = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int start = y[0];
        int end = y[1];

        boolean[] visited = new boolean[n + 1];
        int[] cost = new int[n + 1];
        Arrays.fill(cost, INF);
        cost[start] = 0;

        for (int i = 1; i <= n; i++) {
            int min = INF;
            int minIndex = -1;

            for (int j = 1; j <= n; j++) {
                if (cost[j] < min && !visited[j]) {
                    min = cost[j];
                    minIndex = j;
                }
            }

            if (minIndex == -1) {
                break;
            }

            // cost[]의 값이 가장 작은 노드와 연결된 정점 선택
            for (int j = 1; j <= n; j++) {
                if (cost[j] > cost[minIndex] + matrix[minIndex][j]) {
                    cost[j] = cost[minIndex] + matrix[minIndex][j];
                }
            }
            visited[minIndex] = true;
        }

        System.out.println(cost[end]); // 정답
    }
}
