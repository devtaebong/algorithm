import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] input = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int n = input[0];
        int m = input[1];

        // 빙산 입력
        int[][] matrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            matrix[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        // 바다는 그래프탐색 범위에서 제외
        // 빙산은 List로 관리
        boolean[][] visited = new boolean[n][m];
        List<Ice> iceList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] > 0) {
                    iceList.add(new Ice(i, j, matrix[i][j]));
                }
                visited[i][j] = true;
            }
        }

        System.out.println(getYear(matrix, visited, iceList));
    }

    public static int getYear(int[][] matrix, boolean[][] visited, List<Ice> iceList) {
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, 1, -1};

        for (int year = 1; !iceList.isEmpty(); year++) {
            // iceList를 돌면서 matrix 바다 면적에 따라 빙산 높이를 조정
            for (Ice ice : iceList) {
                for (int i = 0; i < 4; i++) {
                    int nr = dr[i] + ice.row;
                    int nc = dc[i] + ice.col;

                    if (matrix[nr][nc] == 0) ice.height--;
                }
            }

            // matrix의 빙산을 녹인다 -> 루프를 따로 돌아야함
            for (int i = 0; i < iceList.size(); i++) {
                Ice ice = iceList.get(i);
                if (ice.height <= 0) {
                    matrix[ice.row][ice.col] = 0;
                    iceList.set(i, iceList.get(iceList.size() - 1));
                    iceList.remove(iceList.size() - 1);
                    i--;
                }
                else {
                    matrix[ice.row][ice.col] = ice.height;
                    visited[ice.row][ice.col] = false;
                }
            }

            if (iceList.size() > 0 && dfs(matrix, visited, iceList.get(0).row, iceList.get(0).col) != iceList.size()) {
                return year;
            }
        }

        return 0;
    }

    public static int dfs(int[][] matrix, boolean[][] visited, int r, int c) {
        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};
        visited[r][c] = true;

        int count = 1;
        for (int k = 0; k < 4; k++) {
            int nr = r + dr[k];
            int nc = c + dc[k];

            if (!visited[nr][nc] && matrix[nr][nc] > 0) {
                count += dfs(matrix, visited, nr, nc);
            }
        }

        return count;
    }
}

class Ice {
    int row;
    int col;
    int height;

    public Ice(int row, int col, int height) {
        this.row = row;
        this.col = col;
        this.height = height;
    }

    @Override
    public String toString() {
        return "Ice{" +
                "row=" + row +
                ", col=" + col +
                ", height=" + height +
                '}';
    }
}