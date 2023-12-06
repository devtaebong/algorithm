import java.io.*;
import java.util.*;

public class Main {

    /*
    0. 입력
    - N => 1000
    - 배열 U에서 x, y, z 번째 수를 선택
        - x, y, z는 같을 수 있음
    - 배열 U => 집합이기 때문에 중복 X
    - U[x] + U[y] + U[z] = d
    - d도 U안에 포함되어있을때 가장 큰 d를 찾기

    1. 아이디어
    - d 찾기 => 이분탐색
        - U => 정렬
    - 두 수의 합이 k - z와 일치하는지 => 시간 복잡도 줄이기
    - X + Y + Z = K
    - X + Y = K - Z

    2. 시간복잡도
    - O(N^2) => 두 수의 합
    - O(logN) => 이분탐색
    - O(N^2) => 정렬
    = O(N^2logN)

    3. 자료구조
    int[] => U
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] U = new int[N];
        for (int i = 0; i < N; i++) {
            U[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(U);

        // X + Y + Z = K
        // X + Y = K - Z
        // X + Y를 새로운 배열에 저장
        int[] sums = new int[N * (N + 1) / 2];
        int sumsIndex = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                sums[sumsIndex] = U[i] + U[j];
                sumsIndex++;
            }
        }
        
        Arrays.sort(sums);
        // K - Z가 sums 배열에 있는지 확인
        // 있다면 K의 max 값 확인
        int max = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int k = U[i];
                int z = U[j];
                int x = k - z;

                if (isExist(sums, x)) {
                    max = Math.max(max, k);
                }
            }
        }

        System.out.println(max);
    }

    // TODO: 이분탐색 => 3개 고른 수의 합이 U에 있는지?
    public static boolean isExist(int[] arr, int x) {
        int l = 0;
        int r = arr.length - 1;

        while(l <= r) {
            int mid = (l + r) / 2;
            if (x > arr[mid]) {
                l = mid + 1;
            }
            else if (x < arr[mid]) {
                r = mid - 1;
            }
            else return true;
        }

        return false;
    }
}
