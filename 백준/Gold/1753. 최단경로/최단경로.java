import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Main {
    private static final int INF = 300000 * 10 + 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] ve = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int v = ve[0];
        int e = ve[1];
        int start = Integer.parseInt(br.readLine());

        List<Node>[] graph = new List[v + 1];
        for (int i = 1; i <= v; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < e; i++) {
            int[] src = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            int s = src[0];
            int r = src[1];
            int c = src[2];
            graph[s].add(new Node(r, c));
        }

        int[] cost = new int[v + 1];
        Arrays.fill(cost, INF);
        cost[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>(
                (o1, o2) -> Integer.compare(o1.cost, o2.cost)
        );
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node now = pq.poll();
            if (now.cost > cost[now.dist]) {
                continue;
            }

            for (Node next : graph[now.dist]) {
                if (cost[next.dist] > cost[now.dist] + next.cost) {
                    cost[next.dist] = cost[now.dist] + next.cost;
                    pq.offer(new Node(next.dist, cost[next.dist]));
                }
            }
        }

        for (int i = 1; i <= v; i++) {
            if (cost[i] == INF) {
                System.out.println("INF");
            } else {
                System.out.println(cost[i]);
            }
        }
    }
}

class Node {
    int dist;
    int cost;

    public Node(int dist, int cost) {
        this.dist = dist;
        this.cost = cost;
    }
}