import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
1 - N 번까지 문제집을 푼다
1번이 가장 쉬운 문제 N번이 가장 어려운 문제

문제 푸는 문제가 좋은경우 그 문제를 먼저 푼다
쉬운 문제부터 (번호가 낮은 문제부터 푼다) -> q에 낮은 번호를 우선으로 넣는다

4 - 2
3 - 1

tc1
4 2
4 2
3 1

3 1 4 2

tc2
4 2
4 3
3 1

2 4 3 1

tc3
5 2
4 2
3 1

3 1 4 2 5

5 2
5 2
3 2

1 3 4 5 2

1 1
0 1

1 | 3
2 | 1 4
3 |
4 | 3
5 |
6 | 1
7 | 6 2

5 7
 */

public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int n = input[0]; // 문제의 수 (노드)
        int m = input[1]; // 먼저 푸는 것이 좋은 문제 정보 개수 (간선)

        int[] indegree = new int[n + 1];
        boolean[] check = new boolean[n + 1];
        List<Integer>[] list = new List[n + 1];
        for (int i = 0; i < n + 1; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            int[] x = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int a = x[0];
            int b = x[1];
            list[a].add(b);
            indegree[b]++;
        }

        // 문제 순서가 낮은 순으로 정렬 -> 최소힙
        Queue<Integer> pq = new PriorityQueue<>();

        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0) {
                pq.offer(i);
            }
        }

        while (!pq.isEmpty()) {
            int now = pq.poll();
            check[now] = true;
            sb.append(now).append(" ");

            for (int next : list[now]) {
                if (check[next]) {
                    continue;
                }

                indegree[next]--;
                if (indegree[next] == 0) {
                    pq.offer(next);
                }
            }
        }

        System.out.println(sb);
    }
}
