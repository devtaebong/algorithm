import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        final int INF = 100 * 100 * 10;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] mn = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int m = mn[0];
        int n = mn[1];

        int[][] matrix = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                int x = s.charAt(j) - '0';
                matrix[i][j + 1] = x;
            }
        }

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, 1, -1};

        // dp[i][j] = (i, j)까지 이동하는데 부순 벽의 최소 개수
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(dp[i], INF);
        }
        dp[1][1] = 0;

        PriorityQueue<Edge> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
        pq.offer(new Edge(1, 1, 0));

        while (!pq.isEmpty()) {
            Edge now = pq.poll();

            for (int i = 0; i < 4; i++) {
                int nr = now.r + dr[i];
                int nc = now.c + dc[i];

                if (0 >= nr || nr > n || 0 >= nc || nc > m) {
                    continue;
                }

                if (dp[nr][nc] != INF) {
                    continue;
                }

                // 벽이 없는 경우
                if (matrix[nr][nc] == 0) {
                    dp[nr][nc] = dp[now.r][now.c];
                    pq.offer(new Edge(nr, nc, dp[nr][nc]));
                }
                else {
                    dp[nr][nc] = dp[now.r][now.c] + 1;
                    pq.offer(new Edge(nr, nc, dp[nr][nc]));
                }
            }
        }

        System.out.println(dp[n][m]);
    }
}

class Edge {
    int r;
    int c;
    int cost;

    public Edge(int r, int c, int cost) {
        this.r = r;
        this.c = c;
        this.cost = cost;
    }
}
