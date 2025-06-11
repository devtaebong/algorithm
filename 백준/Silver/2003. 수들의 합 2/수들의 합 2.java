import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int n;
    static int m;
    static int res;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] nm = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        n = nm[0];
        m = nm[1];
        res = 0;

        arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        solve();
        System.out.println(res);
    }

    public static void solve() {
        int currentSum = arr[0];
        int arrLastIndex = n - 1;

        int r = 0;
        for (int l = 0; l < n; l++) {
            while (currentSum < m) {
                if (r == arrLastIndex) {
                    break;
                }
                currentSum += arr[++r];
            }

            if (currentSum == m) {
                res++;
            }
            currentSum -= arr[l];
        }
    }
}
