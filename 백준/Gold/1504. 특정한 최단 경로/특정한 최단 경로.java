import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
1번에서 N번까지 최단 거리로 이동
임의로 주어진 두 정점은 반드시 통과해야함
양방향

 */

public class Main {
    final static int INF = 200000 * 1000 + 1;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] ne = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        n = ne[0];
        int e = ne[1];

        List<Edge>[] graph = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < e; i++) {
            int[] sdc = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            int s = sdc[0];
            int d = sdc[1];
            int c = sdc[2];

            graph[s].add(new Edge(d, c));
            graph[d].add(new Edge(s, c));
        }

        int[] xy = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int x = xy[0];
        int y = xy[1];

        // 1 -> x -> y -> n
        int res1 = dijkstra(1, x, graph) + dijkstra(x, y, graph) + dijkstra(y, n, graph);


        // 1 -> y -> x -> n
        int res2 = dijkstra(1, y, graph) + dijkstra(y, x, graph) + dijkstra(x, n, graph);

        int answer = Math.min(res1, res2);
        if (answer >= INF) {
            System.out.println(-1);
        } else {
            System.out.println(answer);
        }
    }

    private static int dijkstra(int s, int d, List<Edge>[] graph) {
        int[] cost = new int[n + 1];
        Arrays.fill(cost, INF);
        cost[s] = 0;

        PriorityQueue<Edge> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
        pq.offer(new Edge(s, 0));

        while (!pq.isEmpty()) {
            Edge now = pq.poll();
            if (now.dist == d) {
                return cost[now.dist];
            }

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

        return INF;
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