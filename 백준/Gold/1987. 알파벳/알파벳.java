import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
R: 세로
C: 가로
(1, 1)에는 말이 놓여이음
말은 상하좌우 이동 가능
새로 이동할 칸에 적힌 알파벳은 지금까지 지나온 모든 칸에 적혀있는 알파벳과 달라야함
-> 같은 알파벳을 두 번 지날 수 없음
말이 최대한 이동할 수 있는 칸은?
 */
public class Main {
    static int[][] matrix;
    static boolean[] check = new boolean[27];
    static int count = -1;
    static int r;
    static int c;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] rc = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        r = rc[0];
        c = rc[1];

        matrix = new int[r + 1][c + 1];
        for (int i = 0; i < r; i++) {
            String s = br.readLine();
            for (int j = 0; j < c; j++) {
                matrix[i + 1][j + 1] = s.charAt(j) - 'A' + 1;
            }
        }
        check[matrix[1][1]] = true;
        System.out.println(dfs(1, 1));

    }

    private static int dfs(int cr, int cc) {
        int result = 0;
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, 1, -1};

        for (int i = 0; i < 4; i++) {
            int nr = dr[i] + cr;
            int nc = dc[i] + cc;

            if (0 >= nr || nr > r || 0 >= nc || nc > c) {
                continue;
            }

            if (check[matrix[nr][nc]]) {
                continue;
            }

            check[matrix[nr][nc]] = true;
            result = Math.max(result, dfs(nr, nc));
            check[matrix[nr][nc]] = false;

        }
        return result + 1;
    }
}
