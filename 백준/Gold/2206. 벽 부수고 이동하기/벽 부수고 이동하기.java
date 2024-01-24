import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int n = input[0];
        int m = input[1];
        int[][] matrix = new int[n + 1][m + 1];
        for (int i = 1; i < n + 1; i++) {
            String s = br.readLine();
            for (int j = 1; j < m + 1; j++) {
                matrix[i][j] = s.charAt(j - 1) - '0';
            }
        }
        int[][][] visited = new int[n + 1][m + 1][2];

        Queue<Point> q = new LinkedList<>();
        visited[1][1][0] = 1;
        q.add(new Point(1, 1, 0));

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        while (!q.isEmpty()) {
            Point now = q.poll();
            if (now.r == n && now.c == m) {
                System.out.println(visited[now.r][now.c][now.isBroken]);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nr = now.r + dr[i];
                int nc = now.c + dc[i];
                if (nr <= 0 || nr > n || nc <= 0 || nc > m) {
                    continue;
                }

                if (visited[nr][nc][now.isBroken] == 0) {
                    if (matrix[nr][nc] == 0) {
                        visited[nr][nc][now.isBroken] = visited[now.r][now.c][now.isBroken] + 1;
                        q.add(new Point(nr, nc, now.isBroken));
                    }
                    else if (matrix[nr][nc] == 1 && now.isBroken == 0) {
                        visited[nr][nc][1] = visited[now.r][now.c][0] + 1;
                        q.add(new Point(nr, nc, 1));
                    }
                }
            }
        }
        System.out.println(-1);
    }
}

class Point {
    int r;
    int c;
    int isBroken;

    public Point(int r, int c, int isBroken) {
        this.r = r;
        this.c = c;
        this.isBroken = isBroken;
    }
}