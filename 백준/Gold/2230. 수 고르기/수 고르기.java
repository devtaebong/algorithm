import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int n;
    static int m;
    static int[] arr;
    static int min;
    static int res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] nm = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        n = nm[0];
        m = nm[1];

        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        min = Integer.MAX_VALUE;

        solve();
        System.out.println(min);
    }

    public static void solve() {
        int r = 1;

        for (int l = 0; l < n; l++) {
            while (r < n - 1 && arr[r] - arr[l] < m) {
                r++;
            }

            if (arr[r] - arr[l] >= m) {
                min = Math.min(min, arr[r] - arr[l]);
            }
        }
    }
}
