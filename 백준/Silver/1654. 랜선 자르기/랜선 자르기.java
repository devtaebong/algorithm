import java.io.*;
import java.util.*;

/*
0. 입력
- K: 갖고 있는 랜선의 개수
- N: 필요한 랜선의 개수
- K개의 랜선으로 N개의 랜선을 못만드는 경우는 없음
- N개 보다 많이 만들어도 됨 => 많이 만들어서 랜선 길이가 더 큰 경우는 없음
- 항상 N은 K보다 같거나 큼

1. 아이디어
- 파라매트릭 서치
    - 주어진 랜선 정렬
    - l = 0, m = arr[n - 1]
    - 각 랜선을 잘라 만들수 있는 랜선 길이가 더 크면
        - 길이(m) 저장
        - m 크기 늘리기(더 큰 값 찾기)
    - 각 랜선을 잘라 만들 수 있는 길이가 작으면
        - m 크기 줄이기
- K <= N

2. 시간복잡도
- O(K) * O(L)
- L => 랜선의 길이 (2^31 - 1)

3. 자료구조
- int[] => 랜선 정렬
- int => 랜선 길이(2^31 - 1: int 범위)
- long => 자른 랜선 길이의 합
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int K = input[0]; // 갖고 있는 랜선 개수 (1 <= K <= 10_000)
        int N = input[1]; // 필요한 랜선 개수 (1 <= N <= 1_000_000)

        int[] arr = new int[K];
        for (int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        long res = 0;
        long l = 1, r = arr[K - 1];
        while (l <= r) {
            long mid = (l + r) / 2;
            // 판정 함수가 true이면 mid 값 증가
            // 값 저장
            if (isPossible(arr, mid, N)) {
                res = Math.max(res, mid);
                l = mid + 1;
            }

            // 판정 함수가 false이면 mid 값 감소
            else {
                r = mid - 1;
            }
        }
        System.out.println(res);
    }

    public static boolean isPossible(int[] arr, long cutLength, int n) {
        // 자른 랜선의 개수가 n 보다 갖거나 크면 ture 리턴
        int sum = 0;
        for (int x : arr) {
            sum += x / cutLength;
        }
        return sum >= n;
    }
}
