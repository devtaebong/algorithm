import java.io.*;
import java.util.*;

/*
0. 입력
- N: 상근이가 갖고 있는 카드 (50만)
- arr[N]: 숫자카드정보 (-10_000_000 ~ 10_000_000)
- M: 50만
- M으로 주어진 숫자가 arr[N]에 몇개 포함?

1. 아이디어
-
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        int N = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int M = Integer.parseInt(br.readLine());
        int[] card = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            int x = arr[i];
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int x = card[i];
            sb.append(map.getOrDefault(x, 0)).append(" ");
        }
        System.out.println(sb);
    }
}
