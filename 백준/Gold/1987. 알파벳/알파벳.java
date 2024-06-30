import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int R;
    static int C;
    static char[][] matrix;
    static boolean[] visit; // 특정 알파벳 방문 여부를 체트 ex) visit[0] = A, visit[1] = B;
    static int res = Integer.MIN_VALUE;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        input();
        solution(1 , 1, 1);
        System.out.println(res);
    }

    public static void solution(int r, int c, int depth) {
        res = Math.max(depth, res);

        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if (!(1 <= nr && nr <= R && 1 <= nc && nc <= C)) {
                continue;
            }

            char next = matrix[nr][nc];
            if (!visit[next - 65]) {
                visit[next - 65] = true;
                solution(nr, nc, depth + 1);
                visit[next - 65] = false;
            }
        }
    }

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] rc = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        R = rc[0];
        C = rc[1];

        matrix = new char[R + 1][C + 1];

        for (int i = 0; i < R; i++) {
            String s = br.readLine();
            for (int j = 0; j < s.length(); j++) {
                matrix[i + 1][j + 1] = s.charAt(j);
            }
        }

        visit = new boolean[26];
        visit[matrix[1][1] - 65] = true;
    }
}
