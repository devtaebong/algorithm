import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<Integer>[] tree = new ArrayList[n + 1];
        for (int i = 1; i < n + 1; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            int[] input = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int a = input[0];
            int b = input[1];
            tree[a].add(b);
            tree[b].add(a);
        }

        int[] parents = new int[n + 1];
        boolean[] check = new boolean[n + 1];

        find(1, tree, parents, check);
        for (int i = 2; i < parents.length; i++) {
            System.out.println(parents[i]);
        }
    }

    public static void find(int node, List<Integer>[] tree, int[] parents, boolean[] check) {
        check[node] = true;

        for (int i = 0; i < tree[node].size(); i++) {
            int child = tree[node].get(i);
            if (!check[child]) {
                parents[child] = node;
                find(child, tree, parents, check);
            }
        }
    }
}
