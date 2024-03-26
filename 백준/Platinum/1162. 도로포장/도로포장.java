import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
N: 도시의 수 (노드)
M: 도로의 수 (간선)
K: 포장할 수 있는 도로

포장하게 되면 0시간이 걸림
1 -> N 도시로 가는 최소 시간
K개 이하의 도로를 포장 -> K개 이하를 포장해도 되지만 K개를 모두 사용해야 최소시간이 구해짐

 */
public class Main {
    public static void main(String[] args) throws IOException {
        final long INF = 50_000L * 1_000_000 * 10;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] nmk = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int n = nmk[0];
        int m = nmk[1];
        int k = nmk[2];

        List<Edge>[] graph = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i <= m; i++) {
            int[] sdc = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            int s = sdc[0];
            int d = sdc[1];
            int c = sdc[2];

            graph[s].add(new Edge(d, c, 0));
            graph[d].add(new Edge(s, c, 0));
        }

        long[][] cost = new long[n + 1][k + 1];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(cost[i], INF);
        }
        cost[1][0] = 0;

        PriorityQueue<Edge> pq = new PriorityQueue<>((o1, o2) -> Long.compare(o1.cost, o2.cost));
        pq.offer(new Edge(1, 0, 0));

        while (!pq.isEmpty()) {
            Edge now = pq.poll();
            if (now.cost > cost[now.dist][now.count]) {
                continue;
            }

            for (Edge next : graph[now.dist]) {
                if (cost[next.dist][now.count] > cost[now.dist][now.count] + next.cost) {
                    cost[next.dist][now.count] = cost[now.dist][now.count] + next.cost;
                    pq.offer(new Edge(next.dist, cost[next.dist][now.count], now.count));
                }

                if (now.count + 1 <= k && cost[next.dist][now.count + 1] > cost[now.dist][now.count]) {
                    cost[next.dist][now.count + 1] = cost[now.dist][now.count];
                    pq.offer(new Edge(next.dist, cost[next.dist][now.count + 1], now.count + 1));
                }
            }
        }

        long answer = INF;
        for (int i = 0; i <= k; i++) {
            answer = Math.min(cost[n][i], answer);
        }

        System.out.println(answer);
    }
}

class Edge {
    int dist;
    long cost;
    int count;

    public Edge(int dist, long cost, int count) {
        this.dist = dist;
        this.cost = cost;
        this.count = count;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "dist=" + dist +
                ", cost=" + cost +
                ", count=" + count +
                '}';
    }
}