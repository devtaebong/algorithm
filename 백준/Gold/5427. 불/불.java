import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*
테스트케이스
w: 너비
h: 높이
".": 빈 공간
"#": 벽
"@": 시작 위치
"*": 불

빈 공간과 벽으로 이루어진 건물
매 초마다 불은 동서남북 인접한 빈공간 공간으로 퍼진다.
- 벽은 불이 퍼지지 않는다.
- 상근이는 벽을 통과할 수 없다.
- 불이 옮겨옮과 동시에 상근이는 이동할 수 있다.

1. 아이디어
- 탈출조건: 상근이의 위치가 matrix 범위에서 벗어나면 탈출
- "#" 이 아닌 공간에 불을 옮긴다.
- "." 인 공간에 상근이를 1초마다 이동시키면서 시간 기록 (불이 해당 위치를 덮을 수 있다.)
- 상근이의 위치가 matrix 범위에서 나간다면 탈출 성공 => return matrix[now.row][now.col]
    - return (이전 위치 - 1 + 1)

2. 시간복잡도
- T x H x W
- 100 x 1000 x 1000
- 100000000 => OK
 */
public class Main {
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int[] input = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            int n = input[1];
            int m = input[0];
            int[][] matrix = new int[n][m];
            int[][] fire = new int[n][m];

            for (int i = 0; i < n; i++) {
                String str = br.readLine();
                for (int j = 0; j < m; j++) {
                    char c = str.charAt(j);
                    if (c == '#') {
                        matrix[i][j] = -1;
                        fire[i][j] = -1;
                    }

                    else if (c == '@') {
                        matrix[i][j] = 1;
                    }

                    else if (c == '*') {
                        fire[i][j] = 1;
                    }
                }
            }

            String res = solution(matrix, fire);
            System.out.println(res);

        }
    }

    public static String solution(int[][] matrix, int[][] fire) {
        int n = matrix.length;
        int m = matrix[0].length;

        Queue<Point> q = new LinkedList<>();
        Queue<Point> fireQ = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (fire[i][j] == 1) {
                    fireQ.add(new Point(i ,j));
                }
                else if (matrix[i][j] == 1) {
                    q.add(new Point(i, j));
                }
            }
        }

        // 각 칸에 불이 옮겨 붙는 시간(depth) 구하기
        while (!fireQ.isEmpty()) {
            Point now = fireQ.poll();
            for (int i = 0; i < 4; i++) {
                int nr = dr[i] + now.row;
                int nc = dc[i] + now.col;
                if (!isRange(nr, nc, n, m)) continue;
                // 벽이 아닌 부분으로 옮겨 붙을 수 있다.
                if (fire[nr][nc] == 0) {
                    fire[nr][nc] = fire[now.row][now.col] + 1;
                    fireQ.add(new Point(nr, nc));
                }
            }
        }

        // 다음에 이동할 좌표 matrix[nr][nc]가
        // matrix[nr][nc] == 0 일때 이동 가능
        // fire[nr][nc] == 0 이거나
        // matrix[nr][nc] < fire[nr][nc] 이면 이동 가능
        while (!q.isEmpty()) {
            Point now = q.poll();

            if (isExit(now.row, now.col, n, m)) {
                return matrix[now.row][now.col] + "";
            }

            // range 체크 할 필요 없음
            for (int i = 0; i < 4; i++) {
                int nr = dr[i] + now.row;
                int nc = dc[i] + now.col;

                if (matrix[nr][nc] == 0) {
                    if (fire[nr][nc] > matrix[now.row][now.col] + 1 || fire[nr][nc] == 0) {
                        matrix[nr][nc] = matrix[now.row][now.col] + 1;
                        q.add(new Point(nr, nc));
                    }
                }
            }
        }

        return "IMPOSSIBLE";
    }

    public static boolean isExit(int r, int c, int n, int m) {
        return r == 0 || r == n - 1 || c == 0 || c == m -1;
    }

    public static boolean isRange(int r, int c, int n, int m) {
        return 0 <= r && r < n && 0 <= c && c < m;
    }
}

class Point {
    int row;
    int col;

    public Point(int row, int col) {
        this.row = row;
        this.col = col;
    }

    @Override
    public String toString() {
        return "{row = " + row + " col = " + col + "}";
    }
}
