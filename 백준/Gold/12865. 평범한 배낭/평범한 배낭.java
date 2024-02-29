import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] input = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int n = input[0]; // 주어지는 물품의 개수 (1 ~ 100)
        int k = input[1]; // 준서가 들고다닐 수 있는 최대 무개 (1 ~ 100,000)

        /*
        d[x] = x무게에서 최대 가치

        6 13
        4 8
        3 6
        5 12

        weight, value를 입력 받는다.

        ex. w=6, v=13
        d[1]에 (6,13) => d[7] = d[1] + 13 => max(d[7], d[1] + 13)
        d[2]에 (6,13) 추가 => d[8] = d[2] + 13 => max(d[8] + 13) 최댓값 갱신

         */

        // d[x] = 무게 x에서 최댓값
        int[] d = new int[k + 1];
        for (int i = 0; i < n; i++) {
            int[] product = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            // weight, value 입력 받기
            int w = product[0];
            int v = product[1];

            // d[7] = Math.max(d[7], d[7 - w] + v
            for (int x = k; x >= w; x--) {
                d[x] = Math.max(d[x], d[x - w] + v);
            }
        }
        
        System.out.println(d[k]);
    }
}