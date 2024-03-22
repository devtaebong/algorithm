import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        final int INF = 1000 * 100000 + 1;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[] cost = new int[n + 1];
        List<Edge>[] graph = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
            cost[i] = INF;
        }

        for (int i = 0; i < m; i++) {
            int[] x = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int a = x[0];
            int b = x[1];
            int c = x[2];
            graph[a].add(new Edge(b, c));
        }

        int[] x = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int start = x[0];
        int end = x[1];

        PriorityQueue<Edge> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        pq.offer(new Edge(start, 0));
        cost[start] = 0;

        int[] path = new int[n + 1];
        while (!pq.isEmpty()) {
            Edge now = pq.poll();
            if (cost[now.dist] < now.cost) {
                continue;
            }

            // 현재 정점과 이어진 정점 (현재 정점의 outdegree)
            for (Edge next : graph[now.dist]) {
                if (cost[next.dist] <= cost[now.dist] + next.cost) {
                    continue;
                }
                cost[next.dist] = cost[now.dist] + next.cost;
                pq.offer(new Edge(next.dist, cost[next.dist]));

                // 배열의 밸류로 이전의 정점 정보를 저장
                /*
                1  2  3  4  5
                0     1     3
                 */
                path[next.dist] = now.dist;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(cost[end]);
        
        Stack<Integer> stack = new Stack<>();
        int current = end;
        while (current != 0) {
            stack.push(current);
            current = path[current];
        }

        sb.append('\n').append(stack.size()).append('\n');

        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }

        System.out.println(sb);
    }
}

class Edge {
    int dist;
    int cost;

    public Edge(int dist, int cost) {
        this.dist = dist;
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "dist=" + dist +
                ", cost=" + cost +
                '}';
    }
}