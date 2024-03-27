import java.util.*;
/*
1 ~ N 개의 마을
양방향, 간선 가중치 
1번 마을에서 각 마을로 배달할 때, 배달을 받을 수 있는 마을의 정보
*/

class Solution {
    public int solution(int N, int[][] road, int K) {     
        final int INF = 2000 * 500000 + 1; // 1000000000 (10억)
            
        List<Edge>[] graph = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < road.length; i++) {
            int s = road[i][0];
            int d = road[i][1];
            int c = road[i][2];
            graph[s].add(new Edge(d, c));
            graph[d].add(new Edge(s, c));
        }
        
        int[] cost = new int[N + 1];
        Arrays.fill(cost, INF);
        cost[1] = 0;
        
        PriorityQueue<Edge> pq = new PriorityQueue<>(
            (o1, o2) -> Integer.compare(o1.cost, o2.cost)
        );
        pq.offer(new Edge(1, 0));
        
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
        
        int count = 0;
        for (int i = 0; i < cost.length; i++) {
            if (cost[i] <= K) {
                count++;
            }
        }
        
        return count;
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