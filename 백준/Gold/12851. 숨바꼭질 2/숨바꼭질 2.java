import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*
1. 아이디어
위치가 x일때 1초 후에 갈 수 있는 좌표 -> x - 1, x + 1, x * 2
- visit[x] = 1 / visit[x - 1], visit[x + 1], visit[x * 2] = 2
    - 유효한 범위인지 확인 필요

// 첫 방문인 경우
- visit[next] == 0
    - count[next] = count[now]

// 최단시간이고 재방문인 경우
- visit[now] + 1 == visit[next] -> 최단시간안에 갈 수 있는 다른 방법
    - count[next] = count[now] + 1 // 현재 좌표까지 갈 수 있는 경우의 수를 누적합
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int n = input[0];
        int k = input[1];

        int[] visit = new int[100001];
        int[] count = new int[100001];

        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        visit[n] = 1;
        count[n] = 1;

        while (!q.isEmpty()) {
            int now = q.poll();
            if (now == k) break;

            // 1초 후에 갈 수 있는 좌표
            int[] arr = {now - 1, now + 1, now * 2};
            for (int i = 0; i < 3; i++) {
                int next = arr[i];
                if (!isRange(next)) continue;

                // 방문한 적이 없는 경우
                if (visit[next] == 0) {
                    visit[next] = visit[now] + 1; // 다음 좌표는 1초뒤 방문 가능
                    q.add(next);

                    // 다음좌표에 방문한 적이 없기 때문에 현재까지 방문한 경우의 수와 동일
                    count[next] = count[now];
                }

                // 재방문한 경우 && 최단시간과 같은 경우
                else if (visit[next] == visit[now] + 1) {
                    // 다음좌표의 방문 횟수는 현재 까지 방문한 횟수 누적합
                    count[next] += count[now];
                }
            }
        }

        // 정답 출력
        System.out.println(visit[k] - 1);
        System.out.println(count[k]);
    }

    // 범위 체크
    public static boolean isRange(int num) {
        return 0 <= num && num <= 100000;
    }
}