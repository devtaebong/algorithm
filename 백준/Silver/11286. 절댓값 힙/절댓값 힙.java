import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        /*
        compare
        return 음수: o1이 o2보다 먼저
        return 양수; o2가 o1보다 먼저
        return 0: 원본 순서 그대로
         */
        PriorityQueue<Integer> q = new PriorityQueue<>((o1, o2) -> {
            // 절댓값이 같으면 음수 출력
            if (Math.abs(o1) == Math.abs(o2)) {
                return Integer.compare(o1, o2);
            }
            // 절댓값이 작은 순서대로 출력
            return Integer.compare(Math.abs(o1), Math.abs(o2));
        });

        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            int x = Integer.parseInt(br.readLine());

            if (x == 0) {
                if (q.isEmpty()) {
                    sb.append(0).append('\n');
                }
                else {
                    sb.append(q.poll()).append('\n');
                }
            }
            else {
                q.offer(x);
            }
        }
        System.out.println(sb);
    }
}