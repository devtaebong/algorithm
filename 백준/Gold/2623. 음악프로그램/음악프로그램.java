import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
보조 PD들이 만든 순서를 만족하는 전체 가수의 순서를 정하기
n: 가수의 수
m: 보조피디의 수

6 3
3 1 4 3
4 6 2 5 4
2 3 2
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[] input = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int n = input[0];
        int m = input[1];

        List<Integer>[] list = new List[n + 1];
        for (int i = 0; i < n + 1; i++) {
            list[i] = new ArrayList<>();
        }

        int[] indegree = new int[n + 1];
        boolean[] check = new boolean[n + 1];
        for (int i = 0; i < m; i++) {
            int[] x = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int count = x[0];
            for (int j = 1; j < count; j++) {
                int a = x[j];
                int b = x[j + 1];
                list[a].add(b);
                indegree[b]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();

        // 진입차수가 0이라면 위상정렬 조건 만족
        for (int i = 1; i < n + 1; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int now = q.poll();
            check[now] = true;
            sb.append(now).append('\n');

            for (int next : list[now]) {
                if (check[next]) {
                    continue;
                }

                indegree[next]--;

                if (indegree[next] == 0) {
                    q.add(next);
                }
            }
        }

        int tmp = 0;
        for (int i = 1; i < n + 1; i++) {
            if (!check[i]) {
                tmp++;
            }
        }

        if (tmp > 0) {
            System.out.println(0);
        } else {
            System.out.println(sb);
        }
    }
}
