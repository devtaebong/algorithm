import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static int n;
    public static int m;
    public static int[][] matrix;
    public static int[][] visit;
    public static int[] dr = {-1, 1, 0, 0};
    public static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] input = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        n = input[0];
        m = input[1];

        // 입력
        matrix = new int[n + 1][m + 1];
        visit = new int[n + 1][m + 1];
        for (int i = 1; i < n + 1; i++) {
            String str = br.readLine();
            for (int j = 1; j < m + 1; j++) {
                int x = str.charAt(j - 1) - '0';
                matrix[i][j] = x;
            }
        }

        bfs(1, 1);
    }

    public static void bfs(int r, int c) {
        visit[r][c] = 1;
        Queue<D_2178> q = new LinkedList<>();
        q.add(new D_2178(r, c));

        while (!q.isEmpty()) {
            D_2178 current = q.poll();
            for (int k = 0; k < 4; k++) {
                int nr = current.row + dr[k];
                int nc = current.col + dc[k];

                if (0 > nr || nr > n || 0 > nc || nc > m) continue;

                if (matrix[nr][nc] == 1 && visit[nr][nc] == 0) {
                    q.add(new D_2178(nr, nc));
                    visit[nr][nc] = visit[current.row][current.col] + 1;
                }
            }
        }

        System.out.println(visit[n][m]);
    }
}

class D_2178 {
    int row;
    int col;

    public D_2178(int row, int col) {
        this.row = row;
        this.col = col;
    }
}