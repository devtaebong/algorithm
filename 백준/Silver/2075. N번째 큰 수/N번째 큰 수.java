import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        /*
        n log n = 1500 x log 1500
        n^2 log n
        1500 x 1500 x 12
         */

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> q = new PriorityQueue<>(
                (o1, o2) -> Integer.compare(o2, o1) // 내림차순 정렬
        );

        for (int i = 0; i < n; i++) {
            int[] input = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            for (int j = 0; j < n; j++) {
                q.offer(input[j]);
            }
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            res = q.poll();
        }
        System.out.println(res);
    }
}
