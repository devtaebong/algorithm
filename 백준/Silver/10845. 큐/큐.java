import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        Queue<Integer> q = new LinkedList<>();
        Integer currentValue = 0;

        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            String[] cmd = br.readLine().split(" ");

            // 정수 X를 큐에 넣는다.
            if (cmd[0].equals("push")) {
                currentValue = Integer.parseInt(cmd[1]);
                q.add(currentValue);
            }

            // 큐의 가장 앞에 있는 정수를 출력한다.
            // 만약 큐가 비어있다면 -1을 출력한다.
            else if (cmd[0].equals("front")) {
                if (q.isEmpty()) {
                    sb.append("-1").append("\n");
                } else {
                    sb.append(q.peek()).append("\n");
                }
            }

            // 큐의 가장 뒤에 있는 정수를 출력
            // 만약 큐가 비어있다면 -1 출력
            else if (cmd[0].equals("back")) {
                if (q.isEmpty()) {
                    sb.append("-1").append("\n");
                } else {
                    sb.append(currentValue).append("\n");
                }
            }

            // 큐에 들어있는 정수의 개수를 출력한다.
            else if (cmd[0].equals("size")) {
                sb.append(q.size()).append("\n");
            }

            // 큐에서 가장 앞에 있는 정수를 빼고 출력한다.
            // 큐가 비어있다면 -1 출력
            else if (cmd[0].equals("pop")) {
                if (q.isEmpty()) {
                    sb.append("-1").append("\n");
                } else {
                    sb.append(q.poll()).append("\n");
                }
            }

            // 큐가 비어있으면 1 아니면 0
            else if (cmd[0].equals("empty")) {
                if (q.isEmpty()) {
                    sb.append("1").append("\n");
                } else {
                    sb.append("0").append("\n");
                }
            }
        }

        System.out.println(sb);
    }
}
