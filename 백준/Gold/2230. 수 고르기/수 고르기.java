import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] input = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int n = input[0];
        int m = input[1];

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        // 두 수를 골랐을 때 차이가 가장 작은수
        // 두 수의 차이가 m 이상인 수들 중 가장 작은 r
        Arrays.sort(arr);
        // 1 3 5

        int r = 0;
        int res = Integer.MAX_VALUE;

        // arr[r] - arr[l]
        // r이 커질수록 차이가 커진다
        // 두 수의 차가 m보다 작으면 r 한 칸 이동
        // 두 수의 차가 m보다 크면 l 한 칸 이동
        for (int l = 0; l < n; l++) {
            while (r < n - 1 && arr[r] - arr[l] < m) {
                r++;
            }

            int gap = arr[r] - arr[l];

            if (gap >= m) {
                res = Math.min(res, gap);
            }
        }
        System.out.println(res);
    }
}
