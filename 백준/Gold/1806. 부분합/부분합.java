import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int n = input[0];
        int s = input[1];

        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        // 투포인터 => O(N)
        // 5 1 3 5 10 7 4 9 2 8 => 15이상 되는 수 중 가장 짧은 것의 길이
        // 5 1 3 5 10
        // 1 3 5 10

        int res = Integer.MAX_VALUE;
        int currentSum = arr[0];
        int r = 0;
        for (int l = 0; l < n; l++) {
            // 현재합이 s보다 작으면
                // r 인덱스 한 칸 이동, count++
            while (r < n - 1 && currentSum < s) {
                r++;
                currentSum += arr[r];
            }

            if (currentSum >= s) {
                res = Math.min(res, r - l + 1);
            }

            currentSum -= arr[l];
        }

        if (res == Integer.MAX_VALUE) {
            res = 0;
        }
        System.out.println(res);
    }
}
