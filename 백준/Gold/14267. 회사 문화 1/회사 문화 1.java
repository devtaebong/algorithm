import java.io.*;
import java.util.*;

/*
0. 입력
- n: 회사의 직원 수
    - 1 <= n <= 100_000

- m: 칭찬을 받을 횟수
    - 1 <= m <= 100_000

- i: 칭찬을 받을 직원 번호
    - 2 <= i <= n

- w: 칭찬의 수치
    - 1 <= w <= 1000


 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] input = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int n = input[0]; // 직원 수
        int m = input[1]; // 칭찬의 횟수

        // 상사의 직원 번호
        int[] temp = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] parent = new int[n + 1];

        // 부하의 노드 번호를 트리에 저장
        List<Integer>[] tree = new List[n + 1];
        for (int i = 1; i < n + 1; i++) {
            parent[i] = temp[i - 1];
            tree[i] = new ArrayList();

            if (parent[i] != -1) {
                tree[parent[i]].add(i);
            }
        }

        // 나에게 발생한 칭찬을 기록
        int[] memo = new int[n + 1];
        for (int i = 0; i < m; i++) {
            int[] x = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int employee = x[0];
            int point = x[1];

            memo[employee] += point;
        }

        next(1, tree, memo);
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < n + 1; i++) {
            sb.append(memo[i]).append(" ");
        }
        System.out.println(sb);
    }

    public static void next(int node, List<Integer>[] tree, int[] memo) {
        for (int i = 0; i < tree[node].size(); i++) {
            int child = tree[node].get(i);
            memo[child] += memo[node];
            next(child, tree, memo);
        }
    }
}

