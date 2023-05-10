
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 특정 거리의 도시 찾기
public class Main {
    static int n;
    static int m;
    static int k;
    static int x;
    static int[][] matrix;
    static List<List<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n+1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
        }

        solution();
    }

    public static void solution() {
        boolean[] ch = new boolean[n+1];
        int[] distance = new int[n+1];
        Arrays.fill(distance, -1);
        distance[x] = 0;

        Deque<Integer> q = new LinkedList<>();
        q.add(x);
        while (!q.isEmpty()) {
            int now = q.poll();

            for (int i = 0; i < graph.get(now).size(); i++) {
                int nextNode = graph.get(now).get(i);
                if (distance[nextNode] == -1) {
                    distance[nextNode] = distance[now] + 1;
                    q.add(nextNode);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < distance.length; i++) {
            if (distance[i] == k) {
                sb.append(i).append("\n");
            }
        }

        if (sb.length() != 0) {
            System.out.println(sb);
        } else {
            System.out.println(-1);
        }
    }
}
