import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/*
N: 버퍼의 크기
양의 정수: 패킷이 들어옴
0: 라우터가 들어온 패킷을 처리
-1: 입력의 끝


라우터에 남아있는 패킷을 순서대로 출력
비어있을 경우 empty 출력

버퍼의 크기보다 들어온 패킷이 많은 경우 입력받은 패킷 모두 버린다
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 버퍼의 크기
        Queue<Integer> q = new LinkedList<>();

        int currentSize = 0;
        while (true) {
            int x = Integer.parseInt(br.readLine());

            if (x == -1) {
                break;
            }

            else if (x >= 1) {
                if (currentSize >= n) {
                    continue;
                }
                currentSize++;
                q.offer(x);
            } else if (x == 0) {
                q.poll();
            }
        }

        StringBuilder sb = new StringBuilder();
        if (q.size() == 0) {
            System.out.println("empty");
        } else {
            while (!q.isEmpty()) {
                sb.append(q.poll()).append(" ");
            }
        }
        System.out.println(sb);
    }
}
