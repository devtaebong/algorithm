
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[][] matrix;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        matrix = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }

        int min = Integer.MAX_VALUE;
        do {
            if (arr[0] != 1) break;
            int x = getCost(arr);
            if (min > x) {
                min = x;
            }
        } while (nextPermutation(arr));

        System.out.println(min);
    }

    private static int getCost(int[] arr) {
        if (matrix[arr[n-1]-1][arr[0]-1] == 0) return Integer.MAX_VALUE;
        int res = matrix[arr[n-1]-1][arr[0]-1];
        for(int i = 0; i < n-1; i++) {

            int cityA = arr[i];
            int cityB = arr[i+1];

            if (matrix[cityA-1][cityB-1] == 0) return Integer.MAX_VALUE;
            res += matrix[cityA-1][cityB-1];
        }
        return res;
    }

    private static boolean nextPermutation(int[] arr) {
        int i = arr.length-1;
        while (i > 0 && arr[i-1] >= arr[i]) {
            i--;
        }

        if (i == 0) return false;

        int j = arr.length-1;
        while (arr[i-1] >= arr[j]) {
            j--;
        }

        int temp = arr[i-1];
        arr[i-1] = arr[j];
        arr[j] = temp;

        j = arr.length-1;
        while (i < j) {
            temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
        return true;
    }
}
