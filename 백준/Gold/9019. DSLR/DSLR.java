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
            char[] command = {'D', 'S', 'L', 'R'};
            boolean[] visit = new boolean[10000];
            visit[a] = true;

            Queue<Point> q = new LinkedList<>();
            q.add(new Point(a, new StringBuilder()));
            while (!q.isEmpty()) {
                Point now = q.poll();
                if (now.num == b) {
                    System.out.println(now.cmd);
                    break;
                }

                visit[now.num] = true;
                int[] next = {now.calD(), now.calS(), now.calL(), now.calR()};
                for (int i = 0; i < 4; i++) {
                    if (!visit[next[i]]) {
                        visit[next[i]] = true;
                        q.add(new Point(next[i], new StringBuilder().append(now.cmd).append(command[i])));
                    }
                }
            }
        }
    }
}

class Point {
    int num;
    StringBuilder cmd;

    public Point(int num, StringBuilder cmd) {
        this.num = num;
        this.cmd = cmd;
    }

    public int calD() {
        return (num * 2) % 10000;
    }

    public int calS() {
        if (num == 0) return 9999;
        return num - 1;
    }

    public int calL() {
        return (num % 1000) * 10 + num / 1000;
    }

    public int calR() {
        return (num % 10) * 1000 + num / 10;
    }
}