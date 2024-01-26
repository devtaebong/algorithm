import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*
1. 아이디어
- (1,1) -> (n,m)으로 이동할 수 있는 최단거리 => (BFS)
- 다음 탐색 위치에 벽이 없는 경우
    - 그냥 BFS 탐색
- 다음 탐색 위치에 벽이 있는 경우
    - 벽을 부순 횟수가 K번 미만이라면 벽을 부순다
    - 벽을 부순 횟수가 K번보다 크다면 탐색할 수 없다

2. 시간복잡도
- O(NM)

3. 자료구조
- int[][][] => 방문 체크 배열
- class Point => nr, nc, isBroken
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] input = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int n = input[0];
        int m = input[1];
        int k = input[2];

        int[][] matrix = new int[n + 1][m + 1];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                char c = str.charAt(j);
                matrix[i + 1][j + 1] = c -'0';
            }
        }
        int[][][] visited = new int[n + 1][m + 1][k + 1];

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

                if (nr < 1 || nr > n || nc < 1 || nc > m) {
                    continue;
                }

                // 방문한 기록이 없는 경우
                if (visited[nr][nc][now.isBroken] == 0) {
                    // 다음 탐색 위치에 벽이 없는 경우
                    if (matrix[nr][nc] == 0) {
                        visited[nr][nc][now.isBroken] = visited[now.row][now.col][now.isBroken] + 1;
                        q.add(new Point(nr, nc, now.isBroken));
                    }

                    // 다음 탐색 위치에 벽이 있는 경우
                    // 벽을 부순 횟수가 k보다 적으면 벽을 부수고 탐색할 수 있다.
                    else if (matrix[nr][nc] == 1 && now.isBroken < k && visited[nr][nc][now.isBroken + 1] == 0) {
                        visited[nr][nc][now.isBroken + 1] = visited[now.row][now.col][now. isBroken] + 1;
                        q.add(new Point(nr, nc, now.isBroken + 1));
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