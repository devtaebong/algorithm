import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/*
N개의 마을에 한명씩 살고 있음
X번 마을에 모여서 파티
i번째 길을 지나는데 비용이 든다

n log n * x * 2
 */

public class Main {
    final static int INF = 100 * 10000 + 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] nmx = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int n = nmx[0]; // 정점
        int m = nmx[1]; // 간선
        int x = nmx[2]; // 종점

        List<Edge>[] graph = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int[] sdc = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int s = sdc[0];
            int d = sdc[1];
            int c = sdc[2];

            graph[s].add(new Edge(d, c));
        }

        int answer = -1;
        for (int i = 1; i <= n; i++) {
            if (answer < dijkstra(graph, i, x) + dijkstra(graph, x, i)) {
                answer = dijkstra(graph, i, x) + dijkstra(graph, x, i);
            }
        }

        System.out.println(answer);
    }

    private static int dijkstra(List<Edge>[] graph, int start, int end) {
        int[] cost = new int[graph.length];
        Arrays.fill(cost, INF);
        cost[start] = 0;

        PriorityQueue<Edge> pq = new PriorityQueue<>(
                (o1, o2) -> Integer.compare(o1.cost, o2.cost)
        );
        pq.offer(new Edge(start, 0));

        while (!pq.isEmpty()) {
            Edge now = pq.poll();
            if (cost[now.dist] < now.cost) {
                continue;
            }

            for (Edge next : graph[now.dist]) {
                if (cost[next.dist] > cost[now.dist] + next.cost) {
                    cost[next.dist] = cost[now.dist] + next.cost;
                    pq.offer(new Edge(next.dist, cost[next.dist]));
                }
            }
        }

        return cost[end];
    }
}

class Edge {
    int dist;
    int cost;

    public Edge(int dist, int cost) {
        this.dist = dist;
        this.cost = cost;
    }
}