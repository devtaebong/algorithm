import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
수빈: n에 위치 (10만)
동생: k에 위치 (10만)
걷거나 순간이동
- 걷기: x-1 or x+1 로 이동
- 순간이동: 2 * X 로 이동

x = 5
0초: 5
1초: 4, 6, 10
2초: (3,5,8), (5,7,12), (9,11,20)
3초: (2,4,6 / 4,6,10 / 7,9,16), (4,6,10 / 6,8,14 / 11,13,24), (8,10,18 / 10,12,22 / 19,21,40)
4초: ... (17,19,36) ..

1. 아이디어
- x-1, x+1, x*2 => Queue에 add
- q.poll == k => break
- q.poll != k => 1초 증가후 다시 add => current - 1, current + 1, current * 2

2. 시간복잡도
- O(N)

3. 자료구조
- int[] =>
- boolean [] => 방문여부 체크
 */

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        System.out.println(bfs(n, k));
    }

    public static int bfs(int n, int k) {
        int time = 0;
        int[] visit = new int[100001];
        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        visit[n] = 1;
        while (!q.isEmpty()) {
            int now = q.poll();

            if (now == k) break;

            int back = now - 1;
            int front = now + 1;
            int tell = now * 2;

            if (back >= 0 && visit[back] == 0) {
                visit[back] = visit[now] + 1;
                q.add(back);
            }

            if (front <= 100000 && visit[front] == 0) {
                visit[front] = visit[now] + 1;
                q.add(front);
            }

            if (tell <= 100000 && visit[tell] == 0) {
                visit[tell] = visit[now] + 1;
                q.add(tell);
            }
        }

        return visit[k] - 1;
    }
}