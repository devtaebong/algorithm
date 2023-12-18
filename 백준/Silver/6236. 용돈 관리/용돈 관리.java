import java.io.*;
import java.util.*;

/*
0. 입력
- N: 날짜 (1 <= N <= 100_000)
- M: 돈을 빼서 사용하는 횟수 (1 <= M <= N)
- i번째 날에 이용할 금액 (1 <= X <= 10_000)
- K => 인출하는 금액의 최소값을 구하는 프로그램 작성

1. 아이디어
- 인출할 금액은 인출하는 금액보다 항상 커야한다.
    - min(arr[i]) <= X <= 10000
- binary search
    - 가지고 있는 돈이 사용해야할 돈 보다 많으면 사용
    - 적으면 남은 금액을 통장에 집어넣고 다시 K원을 인출
    - count++
- 인출하는 횟수가 M보다 크면 안됨
- K의 최소값을 구하는 프로그램 작성

2. 시간복잡도
O(N) + O(logK)

3. 자료구조
int[] => 사용할 금액을 담을 배열
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] input = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int N = input[0];
        int M = input[1];

        int[] account = new int[N]; // N일 동안 이용할 금액
        for (int i = 0; i < N; i++) {
            account[i] = Integer.parseInt(br.readLine());
        }

        int res = 0;
        // K의 최소범위
        int l = Arrays.stream(account).max().orElse(-1);
        int r = 10000 * N;
        while (l <= r) {
            int mid = (l + r) / 2;

            // 작으면 K값 줄여보기 => r = mid - 1
            // K값 저장
            if (isPossible(account, mid, M)) {
                res = mid;
                r = mid - 1;
            }
            // 크면 K값 키우기 => l = mid + 1
            else {
                l = mid + 1;
            }
        }

        System.out.println(res);
    }

    public static boolean isPossible(int[] account, int drawPrice, int m) {
        int drawCount = 0;
        int currentAmount = 0;

        for (int price : account) {
            if (price > drawPrice) return false;
            if (currentAmount < price) {
                if (drawCount == m) return false;
                drawCount++;
                currentAmount = drawPrice;
            }
            currentAmount -= price;
        }
        return true;
    }
}