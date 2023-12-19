import java.io.*;
import java.util.*;

/*
0. 입력
- N: 집의 개수 (2 ~ 20만)
- C: 공유기의 개수 (2 ~ N)
- X: 집의 좌표 (0 ~ 10억) => 중복이 없고 N개의 줄로 주어진다.
- 집에 공유기를 설치 => 한집에는 하나의 공유기만 설치 가능
    - 공유기로 와이파이 사용할수 있다.

1, 2, 4, 8, 9 / 3
- d: 4
    - 1, 8 => 2개 d거리 줄이기
- d: 2
    - 1, 4, 8 => 3개, d거리 늘리기
- d: 3

A. 아이디어
- 설치거리 d를 parametric search로 구하기 => O(logX)
    - 설치 개수가 c보다 많거나 같으면 d거리를 늘리기
    - 설치 개수가 c보다 적으면 d거리를 줄이기

- 정해진 d거리에 따라 공유기를 설치한다. => bool[] 사용
    -   bool[] 에서 가장 인접한 두 공유기 사이의 최대 거리를 구한다.


B. 시간복잡도
- logN * N
- O(NlogN)

C. 자료구조
int[] => 집의 좌표를 저장
bool[] => 공유기 설치여부
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] input = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int N = input[0];
        int C = input[1];

        int[] arr = new int[N]; // 입력으로 주어진 집의 좌표
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        int l = 0;
        int r = arr[N - 1];
        int distance = 0;
        while (l <= r) {
            int mid = (l + r) / 2;
            int count = getCount(arr, mid);
            // {설치한 공유기} >= C -> 설치 가능
            if (count >= C) {
                l = mid + 1;
                distance = mid;
            }

            else {
                r = mid - 1;
            }
        }

        // 1, 2, 4, 8, 9
        int res = Integer.MAX_VALUE;
        int target = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - target >= distance) {
                res = Math.min(res, arr[i] - target);
                target = arr[i];
            }
        }
        System.out.println(res);
    }

    public static int getCount(int[] arr, int d) {
        int target = arr[0];
        int count = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - target >= d) {
                count++;
                target = arr[i];
            }
        }
        return count;
    }
}
