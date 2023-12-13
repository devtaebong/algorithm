import java.io.*;
import java.util.*;

/*
N: 나무의 수
M: 필요한 나무의 길이 (1 ~ 20억)
H: 절단기 높이 -> 높이를 지정할 수 있음 (H >= 0)
한줄에 있는 나무를 모두 절단
- H보다 큰 나무는 H위의 부분이 잘림
- H보다 작은 나무는 잘리지 않음
- M미터의 나무를 집에 가져가기 위해 절단기 높이의 최댓값을 구해야함

1. 아이디어
- binary search => trees 정렬
- trees의 마지막 el를 H로 설정
    - 잘린 나무의 길이 계산 => cut: O(N)
    - cut이 M보다 작으면 H 길이를 줄임 => H/2 => 이분탐색: O(logM)

2. 시간복잡도
- O(NlogM)

3. 자료구조
- int[] => 나무 한 줄을 저장하는 배열
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int N = input[0]; // 나무의 수
        int M = input[1]; // 집으로 가져가려고 하는 나무의 길이

        // trees 입력 및 정렬
        int[] trees = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .sorted()
                .toArray();

        int res = 0;
        int l = 0;
        int r = trees[N - 1];
        while (l <= r) {
            int h = (l + r) / 2;
            // 자른 나무의 길이가 M보다 크면 h 높이기
            // 값 저장
            if (isPossible(trees, h, M)) {
                l = h + 1;
                res = h;
            }
            // 자른 나무의 길이가 M보다 작으면 h 줄이기
            else {
                r = h - 1;
            }
        }
        System.out.println(res);
    }

    // 판정함수
    public static boolean isPossible(int[] trees, int h, int M) {
        long res = 0;

        for (int i = 0; i < trees.length; i++) {
            int tree = trees[i];
            if (tree - h > 0) {
                res += tree - h;
            }
        }

        return res >= M;
    }
}
