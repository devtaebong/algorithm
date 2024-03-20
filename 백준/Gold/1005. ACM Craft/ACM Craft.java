import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
순서대로 건물을 지어야함
게임을 시작할 때마다 건물을 지어야하는 순서가 주어진다

n: 건물의 개수 (1 ~ n까지)
k: 건설 순서의 규칙
10 1 100 10 -> 걸리는 시간 (1번 건물 -> 10초, 2번건물 -> 2초, ..)
x y -> x를 지은 다음 y를 지을 수 있다.
w 건물을 지으면 승리
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        while (tc-- > 0) {
            int[] input = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int n = input[0]; // 건물의 개수
            int k = input[1]; // 건설 규칙 개수

            int[] indegree = new int[n + 1];
            boolean[] check = new boolean[n + 1];
            List<Integer>[] list = new List[n + 1];
            for (int i = 0; i < n + 1; i++) {
                list[i] = new ArrayList<>();
            }

            int[] t = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            int[] time = new int[n + 1];
            for (int i = 0; i < n; i++) {
                time[i + 1] = t[i];
            }

            for (int i = 0; i < k; i++) {
                int[] x = Arrays.stream(br.readLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();
                int a = x[0];
                int b = x[1];

                list[a].add(b);
                indegree[b]++;
            }

            int w = Integer.parseInt(br.readLine());

            int[] dp = new int[n + 1]; // k번 건물을 짓는데 걸리는 시간

            Queue<Integer> q = new LinkedList<>();
            for (int i = 1; i < n + 1; i++) {
                if (indegree[i] == 0) {
                    q.offer(i);
                    dp[i] = time[i];
                }
            }

            while (!q.isEmpty()) {
                int now = q.poll();
                check[now] = true;

                for (int next : list[now]) {
                    if (check[next]) {
                        continue;
                    }

                    indegree[next]--;
                    if (indegree[next] == 0) {
                        q.offer(next);
                    }

                    dp[next] = Math.max(dp[now] + time[next], dp[next]);

                }
            }

            System.out.println(dp[w]);
        }
    }
}
