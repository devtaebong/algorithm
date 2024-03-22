import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
N: 도시의 수 (노드)
M: 도로의 수 (간선)
K: 포장할 도로

포장하게 되면 0시간이 걸림
1 -> N 도시로 가는 최소시간
K개 이하의 도로를 포장 -> K개 이하를 포장해도 되지만 K개를 모두 사용해야 최소시간이 구해짐

 */
public class Main {
    public static void main(String[] args) throws IOException {
        final long INF = (long) 1_000_000 * 10_000 * 10;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] nmk = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int n = nmk[0]; // 도시의 수
        int m = nmk[1]; // 간선의 수
        int k = nmk[2]; // 포장할 수 있는 도로 -> 가중치룰 0으로 만들 수 있는 횟수

        long[][] cost = new long[n + 1][k + 1];
        List<Edge>[] graph = new List[n + 1];
        for (int i = 1; i < n + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i < n + 1; i++) {
            Arrays.fill(cost[i], INF);
        }
        cost[1][0] = 0;

        for (int i = 0; i < m; i++) {
            int[] sdc = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int s = sdc[0];
            int d = sdc[1];
            int c = sdc[2];

            graph[s].add(new Edge(d, c, 0));
            graph[d].add(new Edge(s, c, 0));
        }

        PriorityQueue<Edge> pq =  new PriorityQueue<>((o1, o2) -> Long.compare(o1.cost, o2.cost));
        pq.offer(new Edge(1, 0, 0));

        // TODO: 알고리즘 구현
        // cost[i][j] = i번째 도시까지 가는데 도로를 j번 포장한 경우
        while (!pq.isEmpty()) {
            Edge now = pq.poll();
            if (now.cost > cost[now.dist][now.cnt]) {
                continue;
            }

            for (Edge next : graph[now.dist]) {
                if (cost[next.dist][now.cnt] > cost[now.dist][now.cnt] + next.cost) {
                    cost[next.dist][now.cnt] = cost[now.dist][now.cnt] + next.cost;
                    pq.offer(new Edge(next.dist, cost[next.dist][now.cnt], now.cnt));
                }

                if (now.cnt + 1 <= k && cost[next.dist][now.cnt + 1] > cost[now.dist][now.cnt]) {
                    cost[next.dist][now.cnt + 1] = cost[now.dist][now.cnt];
                    pq.offer(new Edge(next.dist, cost[next.dist][now.cnt + 1], now.cnt + 1));
                }
            }
        }

        long answer = Long.MAX_VALUE;
        for (int i = 0; i <= k; i++)  {
            answer = Math.min(cost[n][i], answer);
        }
        System.out.println(answer);
    }
}

class Edge {
    int dist;
    long cost;
    int cnt;

    public Edge(int dist, long cost, int cnt) {
        this.dist = dist;
        this.cost = cost;
        this.cnt = cnt;
    }
}