import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int n;
    static int m;
    static int res;
    static char[] arr;
    static int[] required;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] nm = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        n = nm[0];
        m = nm[1];
        res = 0;
        arr = br.readLine().toCharArray();
        required = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        solve();
        System.out.println(res);
    }

    public static void solve() {
        int r = 0;

        int[] check = new int[4];
        check[toInt(arr[0])]++;

        for (int l = 0; l < n; l++) {
            while (r - l + 1 != m && r < n - 1) {
                r++;
                int rIndex = toInt(arr[r]);
                check[rIndex]++;
            }

            if (isRequired(check) && r - l + 1 == m) {
                res++;
            }

            int index = toInt(arr[l]);
            if (check[index] > 0) {
                check[index]--;
            } else {
                check[index] = 0;
            }
        }
    }

    public static int toInt(char c) {
        if (c == 'A') return 0;
        if (c == 'C') return 1;
        if (c == 'G') return 2;
        if (c == 'T') return 3;
        return -1;
    }

    public static boolean isRequired(int[] check) {
        for (int i = 0; i < 4; i++) {
            if (required[i] > check[i]) {
                return false;
            }
        }
        return true;
    }
}
