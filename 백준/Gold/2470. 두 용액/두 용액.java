import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int n;
    static int min;
    static int[] res;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] nm = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        n = nm[0];
        min = Integer.MAX_VALUE;
        res = new int[2];

        arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .sorted()
                .toArray();

        solve();
        System.out.println(res[0] + " " + res[1]);
    }

    public static void solve() {
        int r = n - 1;
        for (int l = 0; l < n; l++) {
            while (l < r) {
                int currentSum = arr[l] + arr[r];
                int currentSumAbs = Math.abs(currentSum);

                if (currentSumAbs < min) {
                    min = currentSumAbs;
                    res[0] = arr[l];
                    res[1] = arr[r];
                }

                if (currentSum > 0) {
                    r--;
                } else {
                    break;
                }
            }
        }
    }
}
