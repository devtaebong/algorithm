/*
n: 노드의 개수
edge: 간선 정보
*/
import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        final int INF = 50000 + 1;
        
        int answer = 0;
        List<Edge>[] graph = new List[n + 1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < edge.length; i++) {
            int[] sd = edge[i];
            int s = sd[0];
            int d = sd[1];
            
            graph[s].add(new Edge(d, 1));
            graph[d].add(new Edge(s, 1));
        }
        
        int[] cost = new int[n + 1];
        Arrays.fill(cost, INF);
        cost[1] = 0;
        
        PriorityQueue<Edge> pq = new PriorityQueue<>(
            (o1, o2) -> Integer.compare(o1.cost, o2.cost)
        );
        
        pq.offer(new Edge(1, 0));
        
        int maxCost = -1;
        while (!pq.isEmpty()) {
            Edge now = pq.poll();
            if (cost[now.dist] < now.cost) {
                continue;
            }
            
            for (Edge next : graph[now.dist]) {
                if (cost[next.dist] > cost[now.dist] + next.cost) {
                    cost[next.dist] = cost[now.dist] + next.cost;
                    maxCost = Math.max(maxCost, cost[next.dist]);
                    pq.offer(new Edge(next.dist, cost[next.dist]));
                }
            }
        }
        
        int count = 0;
        for (int x : cost) {
            if (x == maxCost) {
                count++;
            }
        }
        
        return count;
    }
}

class Edge {
    int dist;
    int cost;
    
    public Edge (int dist, int cost) {
        this.dist = dist;
        this.cost = cost;
    }
}