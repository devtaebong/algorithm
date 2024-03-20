import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
n = 32000 -> 인접리스트 사용 (인접행렬 사용 불가)
n: 학생 수(노드)
m: 키를 비교한 횟수 (간선)
1 2 -> 1번 학생보다 2번 학생의 키가 크다 -> 2 1은 존재할 수 없음 -> DAG 만족
위상정렬 알고리즘 사용 가능
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

        int[] indegree = new int[n + 1]; // 진입차수 관리

        // 인접리스트 초기화
        List<Integer>[] list = new List[n + 1];
        for (int i = 0; i < n + 1; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int[] student = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            int a = student[0];
            int b = student[1];

            list[a].add(b);
            indegree[b]++;
        }

        Queue<Integer> q = new LinkedList<>(); // 위상정렬 대상을 관리

        // 진입차수가 0인 정점을 찾아 위상정렬 대상으로 선택
        for (int i = 1; i < n + 1; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        boolean[] check = new boolean[n + 1];
        while (!q.isEmpty()) {
            int current = q.poll();
            check[current] = true;
            sb.append(current).append(" ");

            for (int next : list[current]) {
                if (check[next]) {
                    continue;
                }

                indegree[next]--;
                if (indegree[next] == 0) {
                    q.offer(next);
                }
            }
        }

        System.out.println(sb);
    }
}
