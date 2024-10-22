import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int n;
    static int m;
    static String[][] matrix;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] NM = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        n = NM[0];
        m = NM[1];
        matrix = new String[n][m];
        for (int i = 0; i < n; i++) {
            String[] arr = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                matrix[i][j] = arr[j];
            }
        }

        // 보호가 필요한 row의 개수를 구한다
        int protectedRow = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j].equals("X")) {
                    protectedRow++;
                    break;
                }
            }
        }

        // 보호가 필요한 col의 개수를 구한다
        int protectedCol = 0;
        for (int c = 0; c < m; c++) {
            for (int r = 0; r < n; r++) {
                if (matrix[r][c].equals("X")) {
                    protectedCol++;
                    break;
                }
            }
        }

        int needRow = n - protectedRow;
        int needCol = m - protectedCol;

        System.out.println(Math.max(needRow, needCol));
    }
}