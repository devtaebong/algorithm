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

        boolean[] protectedRow = new boolean[n];
        boolean[] protectedCol = new boolean[m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j].equals("X")) {
                    protectedRow[i] = true;
                    protectedCol[j] = true;
                }
            }
        }

        int needRow = n;
        int needCol = m;

        for (int i = 0; i < n; i++) {
            if (protectedRow[i]) needRow--;
        }
        for (int i = 0; i < m; i++) {
            if (protectedCol[i]) needCol--;
        }

        System.out.println(Math.max(needRow, needCol));
    }
}