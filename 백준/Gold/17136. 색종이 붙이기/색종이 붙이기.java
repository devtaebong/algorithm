import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main {
    static int[][] matrix;
    static int[] paper;
    static int nr;
    static int nc;
    static int res = 26;

    public static void main(String[] args) throws IOException {
        input();
        solution(0,0,0);
        System.out.println(res == 26 ? -1 : res);
    }

    public static void solution(int r, int c, int count) {
        next(r);
        // base case
        if (nr == -1 && nc == -1) {
            res = Math.min(res, count);
        } else {
            // recursive case
            int row = nr;
            int col = nc;
            for (int size = 1; size <= 5; size++) {
                if (!(isValid(row, col, size))) continue;
                if (paper[size] <= 0) continue;
                fill(row, col, size, 0);
                paper[size]--;
                solution(row, col, count + 1);
                fill(row, col, size, 1);
                paper[size]++;
            }
        }
    }

    public static boolean isValid(int r, int c, int size) {
        if (r + size > 10 || c + size > 10) {
            return false;
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (matrix[i + r][j + c] == 0) return false;
            }
        }
        return true;
    }

    public static void fill(int r, int c, int size, int color) {
        for (int i = r; i < r + size; i++) {
            for (int j = c; j < c + size; j++) {
                matrix[i][j] = color;
            }
        }
    }

    public static void next(int r) {
        for (int i = r; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (matrix[i][j] == 1) {
                    nr = i;
                    nc = j;
                    return;
                }
            }
        }
        nr = -1;
        nc = -1;
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        matrix = new int[10][10];

        for (int i = 0; i < 10; i++) {
            int[] temp = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            for (int j = 0; j < 10; j++) {
                matrix[i][j] = temp[j];
            }
        }

        paper = new int[6];
        Arrays.fill(paper, 5);
        paper[0] = 0;
    }
}
