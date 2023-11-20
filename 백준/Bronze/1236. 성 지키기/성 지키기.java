import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    /*
    1. 아이디어
    - 경비원이 없는 row와 col 구하기
    - row와 col -> 최소값 출력

    2. 시간복잡도
    입력: O(NM)
    알고리즘: O(NM)
    => O(NM)
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        // 입력
        char[][] matrix = new char[n][m];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                char ch = s.charAt(j);
                matrix[i][j] = ch;
            }
        }

        int row = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 'X') {
                    row++;
                    break;
                }
            }
        }

        // n = 5, m = 8
        int col = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[j][i] == 'X') {
                    col++;
                    break;
                }
            }
        }

        int needRow = n - row;
        int needCol = m - col;
        System.out.println(Math.max(needRow, needCol));
    }
}
