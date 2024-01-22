import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*
0. 입력
- A를 B로 만들기 위해 수행되는 명령어

1. 아이디어
d(): n x 2 % 10000
s():
l():
r():

A에 DSLR을 수행한 결과와 명령어를 Queue에 저장

2. 시간복잡도

 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int[] input = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int a = input[0];
            int b = input[1];
            char[] command = {'d', 's', 'l', 'r'};
            boolean[] visit = new boolean[10000];

            Queue<Point> q = new LinkedList<>();
            q.add(new Point(a, new StringBuilder()));
            while (!q.isEmpty()) {
                Point now = q.poll();
                if (visit[now.num]) {
                    continue;
                }

                visit[now.num] = true;

                if (now.num == b) {
                    System.out.println(now.cmd);
                    break;
                }

                for (int i = 0; i < 4; i++) {
                    if (command[i] == 'd') {
                        q.add(new Point(d(now.num), new StringBuilder().append(now.cmd).append("D")));
                    }
                    else if (command[i] == 's') {
                        q.add(new Point(s(now.num), new StringBuilder().append(now.cmd).append("S")));
                    }
                    else if (command[i] == 'l') {
                        q.add(new Point(l(now.num), new StringBuilder().append(now.cmd).append("L")));
                    }
                    else if (command[i] == 'r') {
                        q.add(new Point(r(now.num), new StringBuilder().append(now.cmd).append("R")));
                    }
                }
            }
        }
    }

    public static int d(int n) {
        return n * 2 % 10000;
    }

    public static int s(int n) {
        if (n == 0) return 9999;
        return n - 1;
    }

    public static int l(int n) {
        return n % 1000 * 10 + n / 1000;
    }

    public static int r(int n) {
        return (n / 10) + n % 10 * 1000;
    }
}

class Point {
    int num;
    StringBuilder cmd;

    public Point(int num, StringBuilder cmd) {
        this.num = num;
        this.cmd = cmd;
    }
}