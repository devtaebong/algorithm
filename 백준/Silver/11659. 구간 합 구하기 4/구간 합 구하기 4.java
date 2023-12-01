import java.io.*;
import java.util.*;

public class Main {
    /*
    0. 입력
    - n: 수의 개수 (100_000)
    - m: 합을 구해야 하는 횟수 (100_000)
    - i부터 j까지 수의 합을 구하는 프로그램 (100_000)

    1. 아이디어
    - 구간 합 배열 구하기 -> acc
    - i부터 j까지 수의합 구하는 방법 => acc[j] - acc[i-1]
    - 4부터 10까지 => acc[10] - acc[3]

    2. 시간복잡도
    - 구간 합 배열 구하기: O(n)
    - 합 구하기: O(1)

    3. 자료구조
    int[] => 구간합 배열
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);

        String[] inputNum = br.readLine().split(" ");

        int[] arr = new int[n + 1];
        for (int i = 0; i < n; i++) {
            arr[i + 1] = Integer.parseInt(inputNum[i]);
        }

        int[] acc = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            acc[i] = acc[i-1] + arr[i];
        }

        for (int i = 0; i < m; i++) {
            String[] input = br.readLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            // x부터 y까지 구간합
            System.out.println(acc[y] - acc[x-1]);
        }
    }
}
