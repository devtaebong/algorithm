import java.io.*;
import java.util.*;

/*
0. 입력
N: 정점의 수, R: 루트의 번호, Q: 쿼리의 수
정점 U를 루트로 하는 서브트리에 속한 정점의 수
N - 1 줄에 걸쳐 U V 가 주어짐
이후 Q줄에 걸쳐 쿼리가 주어짐
 */
public class Main {

    static List<Integer>[] tree;
    static int[] sum;
    static boolean[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] input = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int N = input[0];
        int R = input[1];
        int Q = input[2];

        // 트리 자료구조 리스트로 표현
        tree = new ArrayList[N + 1];
        for (int i = 1; i < N + 1; i++) {
            tree[i] = new ArrayList();
        }

        for (int i = 0; i < N -1; i++) {
            int[] info = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            int a = info[0];
            int b = info[1];
            tree[a].add(b);
            tree[b].add(a);
        }

        sum = new int[N + 1];
        check = new boolean[N + 1];

        sum[R] = getSubtreeCount(R);
        for (int i = 0; i < Q; i++) {
            int u = Integer.parseInt(br.readLine());
            System.out.println(sum[u]);
        }
    }

    public static int getSubtreeCount(int node) {
        if (sum[node] != 0) {
            return sum[node];
        }

        check[node] = true;
        int count = 1;

        for (int child : tree[node]) {
            if (!check[child]) {
                count += getSubtreeCount(child);
            }
        }

        sum[node] = count;
        return sum[node];
    }
}
