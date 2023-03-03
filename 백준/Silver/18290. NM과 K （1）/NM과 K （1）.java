
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, m, k;
    static int[][] grid;
    static boolean[][] visited;
    static int answer = -2147483647;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        grid = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int x = Integer.parseInt(st.nextToken());
                grid[i][j] = x;
            }
        }

        go(0,0);
        System.out.println(answer);
    }

    public static void go(int count, int sum) {
        if (count == k) {
            if (answer < sum) {
                answer = sum;
            }
            return;
        }

        for (int x = 0; x < n; x++) {
            for (int y = 0; y < m; y++) {
                if (visited[x][y]) continue;
                boolean ok = true;

                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                        if (visited[nx][ny]) ok = false;
                    }
                }

                if (ok) {
                    visited[x][y] = true;
                    go(count + 1, sum + grid[x][y]);
                    visited[x][y] = false;
                }
            }
        }
    }
}
