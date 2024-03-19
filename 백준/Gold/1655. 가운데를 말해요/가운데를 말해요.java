import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> big = new PriorityQueue<>((o1, o2) -> o2 - o1);
        PriorityQueue<Integer> small = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());

            // 최대힙과 최소힙에 데이터를 번갈아 가면서 넣는다.
            if (big.size() == small.size()) {
                big.offer(x);
            } else {
                small.offer(x);
            }

            // 최대힙과 최소힙의 루트를 비교 -> 최대힙 루트 > 최소힙 루트 -> swap
            if (!big.isEmpty() && !small.isEmpty()) {
                if (big.peek() > small.peek()) {
                    int a = big.poll();
                    int b = small.poll();
                    big.offer(b);
                    small.offer(a);
                }
            }

            sb.append(big.peek()).append('\n');
        }
        System.out.println(sb);
    }
}