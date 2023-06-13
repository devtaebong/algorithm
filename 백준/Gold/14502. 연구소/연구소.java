
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static int[][] matrix;
    static int[][] copyMatrix;
    static int answer = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        matrix = new int[n][m];
        copyMatrix = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int x = Integer.parseInt(st.nextToken());
                matrix[i][j] = x;
            }
        }

//        for (int i = 0; i < n; i++) {
//            System.out.println(Arrays.toString(matrix[i]));
//        }

        buildWalls(0);
        System.out.println(answer);

    }

    private static void buildWalls(int count) {

        if (count == 3) {
            copyMatrix = copyMatrix();

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (copyMatrix[i][j] == 2) {
                        spreadVirus(i,j);
                    }
                }
            }
            answer = Math.max(answer, getSafetyArea());
            return;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][j] = 1;
                    buildWalls(count+1);
                    matrix[i][j] = 0;
                }
            }
        }
    }

    // 벽이 세워진 메트릭스 복사
    private static int[][] copyMatrix() {
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = matrix[i][j];
            }
        }
        return arr;
    }

    private static void spreadVirus(int row, int col) {
        int[][] directions = {
                {-1,0}, {1,0}, {0,-1}, {0,1}
        };

        for(int[] direction : directions) {
            int newRow = row + direction[0];
            int newCol = col + direction[1];

            if (newRow>=0 && newRow<n && newCol>=0 && newCol<m){
                if (copyMatrix[newRow][newCol] == 0) {
                    copyMatrix[newRow][newCol] = 2;
                    spreadVirus(newRow, newCol);
                }
            }
        }
    }

    private static int getSafetyArea() {
        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(copyMatrix[i][j] == 0) {
                    result++;
                }
            }
        }
        return result;
    }
}
