import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
1 ~ N 까지 정수 N개로 이루어진 순열

 */
public class Main {
    static boolean[] check;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] input = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            arr = new int[n + 1];
            for (int i = 1; i < n + 1; i++) {
                arr[i] = input[i - 1];
            }
            check = new boolean[arr.length];

            int count = 0;
            for (int i = 1; i < n + 1; i++) {
                count += dfs(i, i);
            }
            System.out.println(count);
        }
    }

    public static int dfs(int startNum, int index) {
        // 1 -> 3(arr[1]) -> 7(arr[3]) -> 5(arr[7]) -> 1(arr[5])
        /*
        1, 2, 3, 4, 5, 6, 7, 8
        3, 2, 7, 8, 1, 4, 5, 6
         */

        check[index] = true;

        int nextNum = arr[index];
        if (startNum == nextNum) {
            return 1;
        }

        if (check[nextNum]) {
            return 0;
        }

        return dfs(startNum, nextNum);
    }
}
