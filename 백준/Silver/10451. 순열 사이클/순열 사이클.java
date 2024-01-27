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
                if (!check[i]) {
                    dfs(i);
                    count++;
                }
            }
            System.out.println(count);
        }
    }

    public static void dfs(int node) {
        check[node] = true;

        int nextNode = arr[node];
        if (!check[nextNode]) {
            dfs(nextNode);
        }
    }
}
