import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*
테스트케이스 문제
l: 한 변의 길이 matrix[l][l]
나이트좌표
나이트가 이동하려는 좌표
나이트가 몇번 이동하여 목적지로 이동할 수 있는지? (최소)

1. 아이디어
- DFS
- 나이트의 이동 범위 8가지 (-2, -1) (-2, 1) (2, -1) (2, 1) (1, -2) (1, 2) (-1, -2) (-1, 2)
    - range 체크 필요
- visit 배열에 나이트가 이동한 횟수 저장

2. 시간복잡도
- O(L^2)

3. 자료구조
int[][] => 체스판
int[][] => 방문배열

 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int l = Integer.parseInt(br.readLine()); // 체스판 크기
            int[][] matrix = new int[l][l];

            // 나이트 좌표
            int[] night = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            // 목적지 좌표
            int[] target = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            System.out.println(solution(matrix, night, target));
        }
    }

    // 나이트의 이동 범위 8가지 (-2, -1) (-2, 1) (2, -1) (2, 1) (1, -2) (1, 2) (-1, -2) (-1, 2)
    public static int solution(int[][] matrix, int[] night, int[] target) {
        int l = matrix.length;
        int[][] visit = new int[l][l];
        visit[night[0]][night[1]] = 1;

        Queue<Night> q = new LinkedList<>();
        q.add(new Night(night[0], night[1]));

        int[] dr = {-2, -2, 2, 2, 1, 1, -1, -1};
        int[] dc = {-1, 1, -1, 1, -2, 2, -2, 2};

        while (!q.isEmpty()) {
            Night now = q.poll();
            if (now.row == target[0] && now.col == target[1]) break;

            for (int i = 0; i < 8; i++) {
                int nr = now.row + dr[i];
                int nc = now.col + dc[i];
                if (!isRange(nr, nc, l)) continue;

                if (visit[nr][nc] == 0) {
                    visit[nr][nc] = visit[now.row][now.col] + 1;
                    q.add(new Night(nr, nc));
                }
            }
        }

        return visit[target[0]][target[1]] - 1;
    }

    public static boolean isRange(int r, int c, int l) {
        return 0 <= r && r < l && 0 <= c && c < l;
    }
}

class Night {
    int row;
    int col;

    public Night(int row, int col) {
        this.row = row;
        this.col = col;
    }
}