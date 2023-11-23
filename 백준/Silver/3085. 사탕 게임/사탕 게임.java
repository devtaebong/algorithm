import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    /*
        1. 아이디어
        - 색이 다른 인접한 두 칸을 골라 교환한다.
            - 아래, 오른쪽만 교환하면 됨
            - 위, 왼쪽은 이전 단계에서 이미 교환해서 확인함
        - 칸을 교환하면 사탕을 먹을수 있는 최대 개수를 확인한다

        2. 시간복잡도
        - 교환 -> O(N^2)
        - 사탕개수 확인 -> O(N)
        = O(N+N^2) => O(N^2)

        3. 자료구조
        char[][] -> 사탕을 담는 배열
         */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        int n = Integer.parseInt(br.readLine());
        char[][] matrix = new char[n][n];
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < n; j++) {
                matrix[i][j] = input.charAt(j);
            }
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // 오른쪽 교환
                if (j+1 < n && matrix[i][j] != matrix[i][j+1]) {
                    swapCandy(matrix, i, j, i, j + 1);
                    int maxRowCount = findMaxRow(matrix);
                    int maxColCount = findMaxColumn(matrix);
                    ans = Math.max(ans, Math.max(maxRowCount, maxColCount));
                    swapCandy(matrix, i, j, i, j + 1);
                }

                if (i+1 < n && matrix[i][j] != matrix[i+1][j]) {
                    swapCandy(matrix, i, j, i+1, j);
                    int maxRowCount = findMaxRow(matrix);
                    int maxColCount = findMaxColumn(matrix);
                    ans = Math.max(ans, Math.max(maxRowCount, maxColCount));
                    swapCandy(matrix, i, j, i+1, j);
                }
            }
        }

        System.out.println(ans);
    }

    public static void swapCandy(char[][] matrix, int r1, int c1, int r2, int c2) {
        char temp = matrix[r1][c1];
        matrix[r1][c1] = matrix[r2][c2];
        matrix[r2][c2] = temp;
    }

    public static int findMaxColumn(char[][] matrix) {
        int n = matrix.length;
        int maxCol = 0;

        for (int c = 0; c < n; c++) {
            int len = 1;
            for (int r = 1; r < n; r++) {
                if (matrix[r][c] == matrix[r-1][c]) len++;
                else {
                    maxCol = Math.max(maxCol, len);
                    len = 1;
                }
            }
            maxCol = Math.max(maxCol, len);
        }
        return maxCol;
    }

    public static int findMaxRow(char[][] matrix) {
        int n = matrix.length;
        int maxRow = 0;

        for (int r = 0; r < n; r++) {
            int len = 1;
            for (int c = 1; c < n; c++) {
                if (matrix[r][c] == matrix[r][c-1]) len++;
                else {
                    maxRow = Math.max(maxRow, len);
                    len = 1;
                }
            }
            maxRow = Math.max(maxRow, len);
        }
        return maxRow;
    }
}
