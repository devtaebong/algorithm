import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int n;
    static int s;
    static int[] arr;
    static int min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] nm = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        n = nm[0];
        s = nm[1];

        arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        min = Integer.MAX_VALUE;

        solve();

        int res = min == Integer.MAX_VALUE ? 0 : min;
        System.out.println(res);
    }

    public static void solve() {
        int currentSum = arr[0];
        int r = 0;

        for (int l = 0; l < n; l++) {
            while (currentSum < s) {
                r++;
                if (r > n - 1) {
                    break;
                }

                currentSum += arr[r];
            }

            if (currentSum >= s) {
                int len = r - l + 1;
                min = Math.min(len, min);
            }

            currentSum -= arr[l];
        }
    }
}
