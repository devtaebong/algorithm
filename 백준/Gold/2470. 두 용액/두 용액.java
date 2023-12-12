import java.io.*;
import java.util.*;

public class Main {
    /*
    0. 입력
    - 산성 용액: 1 ~ 1_000_000_000 (10억)
    - 알칼리성 용액: -1 ~ -1_000_000_000 (-10억)
    - 주어진 용액 중 두 용액을 합하여 0에 가까운 숫자를 만든다.
    - n개의 용액이 주어진다 => n = 10만

    1. 아이디어
    - arr 정렬
    - arr[0]부터 arr[n-1] 까지 최적의 용액쌍을 찾는다. (A)
        - 이분탐색으로 검색 (B)
    - 각각의 A와 B의 쌍 중에서 0에 가까운 값을 찾는다.
        - 0에 가까운 값이 갱신되면 res1, res2도 함께 갱신

    2. 시간복잡도
    - O(NlogN)
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .sorted()
                .toArray();

        int temp = Integer.MAX_VALUE;
        int[] res = new int[2];
        // 첫 번째 용액에 대해 최적쌍이 되는 두 번째 용액을 찾는다.
        for (int i = 0; i < N - 1; i++) {
            int A = arr[i];
            int B = binarySearch(arr, i + 1, A);

            if (Math.abs(A + B) < temp) {
                temp = Math.abs(A + B);
                res[0] = A;
                res[1] = B;
            }
        }

        Arrays.sort(res);
        System.out.println(res[0] + " " + res[1]);
    }

    // 이분탐색 알고리즘 활용해서 용액쌍 검색
    public static int binarySearch(int[] arr, int startIndex, int value) {
        int l = startIndex;
        int r = arr.length - 1;
        int temp = Integer.MAX_VALUE;
        int res = 0;

        // value + arr[mid]가 음수이면 l = mid + 1
        // value + arr[mid]가 양수이면 r = mid - 1
        while (l <= r) {
            int mid = (l + r) / 2;
            if (Math.abs(arr[mid] + value) < temp) {
                temp = Math.abs(arr[mid] + value);
                res = arr[mid];
            }

            if (arr[mid] + value < 0) {
                l = mid + 1;
            }
            else if (arr[mid] + value > 0) {
                r = mid - 1;
            }
            else {
                return arr[mid];
            }
        }

        return res;
    }
}
