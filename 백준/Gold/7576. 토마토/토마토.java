import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*
0: 아직 익지 않은 토마토
1: 잘익은 토마토
-1: 토마토가 들어있지 않은 칸

하루가 지나면
- 익은 토마토의 인접한 칸의 익지 않은 토마토가 익음
- 인접: 상, 하, 좌, 우 (4가지)
- 며칠이 지나면 모든 토마토가 익는지? -> 최소일수

1. 아이디어
bfs
- 익은 토마토가 있는 칸 구하기 => 여러개 있는 경우 O(N)
- 익은 토마토가 있는 위치 -> visit[x][y] = 1
- bfs 탐색 수행

- 출력:
    - visit[x][y]에 0이 있다면
        - return -1
    - 없다면
        - visit[x][y]의 (최댓값 - 1)

2. 시간복잡도
- 익은 토마토 위치 찾기: O(N)
- bfs 탐색 -> O(NM)
- 정답 출력 -> O(NM)
= O(N + NM)

3. 자료구조
int[][] => 토마토
int[][] => 방문여부 체크
class Point => 토마토 위치
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] input = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        // 입력
        int n = input[1]; // row
        int m = input[0]; // col

        int[][] matrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            int[] x = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            for (int j = 0; j < m; j++) {
                matrix[i][j] = x[j];
            }
        }

        System.out.println(bfs(matrix));
    }

    public static int bfs(int[][] matrix) {
        Queue<Point_7576> q = new LinkedList<>();
        int n = matrix.length;
        int m = matrix[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 1) {
                    q.add(new Point_7576(i, j));
                }
            }
        }

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        while (!q.isEmpty()) {
            Point_7576 now = q.poll();
            for (int i = 0; i < 4; i++) {
                int nr = now.row + dr[i];
                int nc = now.col + dc[i];
                if (!isRange(nr, nc, n, m)) continue;

                if (matrix[nr][nc] == 0) {
                    matrix[nr][nc] = matrix[now.row][now.col] + 1;
                    q.add(new Point_7576(nr, nc));
                }
            }
        }

        int max = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    return -1;
                }

                max = Math.max(max, matrix[i][j]);
            }
        }

        return max - 1;
    }

    public static boolean isRange(int row, int col, int n, int m) {
        return 0 <= row && row < n && 0 <= col && col < m;
    }
}

class Point_7576 {
    int row;
    int col;

    public Point_7576(int row, int col) {
        this.row = row;
        this.col = col;
    }

    @Override
    public String toString() {
        return "Point{" +
                "row=" + row +
                ", col=" + col +
                '}';
    }
}
