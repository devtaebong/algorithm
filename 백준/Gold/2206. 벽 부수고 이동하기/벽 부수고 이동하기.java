import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
1. 아이디어
- (1,1) => (n,m)으로 이동할 수 있는 최단거리 => BFS
    - 이동 중에 벽을 하나 부실 수 있다. (안부숴도 됨)
- 벽을 부수지 않고 탐색하는 경우
- 벽을 부수고 탐색하는 경우

2. 시간복잡도
- O(NM)

3. 자료구조
class Point => int row, int col, int isBroken
int[][][] visited => 방문 체크 배열
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int n = input[0];
        int m = input[1];

        int[][] matrix = new int[n + 1][m + 1];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                char c = str.charAt(j);
                matrix[i + 1][j + 1] = c - '0';
            }
        }
        int[][][] visited = new int[n + 1][m + 1][2];

        Queue<Point> q = new LinkedList<>();
        q.add(new Point(1, 1, 0));
        visited[1][1][0] = 1;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while (!q.isEmpty()) {
            Point now = q.poll();
            if (now.row == n && now.col == m) {
                System.out.println(visited[now.row][now.col][now.isBroken]);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nr = dr[i] + now.row;
                int nc = dc[i] + now.col;
                // 탐색 범위 체크
                if (nr < 1 || nr > n || nc < 1 || nc > m) {
                    continue;
                }

                // 방문하지 않은 경우
                if (visited[nr][nc][now.isBroken] == 0) {
                    // 다음 좌표의 벽을 부수지 않은 경우
                    if (matrix[nr][nc] == 0) {
                        visited[nr][nc][now.isBroken] = visited[now.row][now.col][now.isBroken] + 1;
                        q.add(new Point(nr, nc, now.isBroken));
                    }

                    // 다음 좌표의 벽을 부수는 경우
                    else if (matrix[nr][nc] == 1 && now.isBroken == 0) {
                        visited[nr][nc][1] = visited[now.row][now.col][now.isBroken] + 1;
                        q.add(new Point(nr, nc, 1));
                    }
                }
            }
        }
        System.out.println(-1);
    }
}

class Point {
    int row;
    int col;
    int isBroken;

    public Point(int row, int col, int isBroken) {
        this.row = row;
        this.col = col;
        this.isBroken = isBroken;
    }
}