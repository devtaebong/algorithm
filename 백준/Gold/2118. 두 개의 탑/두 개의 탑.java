import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int n;
    static int[] arr;
    static int max;
    static int totalDistance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n * 2];
        for (int i = 0; i < n; i++) {
            int current = Integer.parseInt(br.readLine());
            arr[i] = current;
            arr[i + n] = current;
            totalDistance += current;
        }

        max = Integer.MIN_VALUE;

        solve();
        System.out.println(max);
    }

    public static void solve() {
        int r = 0;
        int clockWise = 0;
        int counterClockWise = totalDistance;
        for (int l = 0; l < n; l++) {
            while (counterClockWise > clockWise) {
                clockWise += arr[r];
                counterClockWise -= arr[r];
                r++;
            }
            max = Math.max(counterClockWise, max);
            clockWise -= arr[l];
            counterClockWise += arr[l];
        }
    }
}

//   1   2   3   4   5
// 1   2   3   4   5   1