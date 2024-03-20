import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/*
시작시간을 기준으로 오름차순 -> 최소힙

i번째 종료시간 > i + 1번째 시작시간 == count + 1

4
1 2
1 4
2 6
4 5

4
0 40
15 30
5 10
5 11
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Meeting> meeting = new ArrayList<>();

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int[] input = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            meeting.add(new Meeting(input[0], input[1]));
        }

        meeting.sort((o1, o2) -> {
            if (o1.start == o2.start) {
                return o1.end - o2.end;
            }
            return o1.start - o2.start;
        });

        // q가 비어있다면 current 추가

        // current와 Queue의 el 비교 (while q.size())
            // el.end <= current.start -> el.poll()
        // q.offer(current)

        int answer = 0;
        PriorityQueue<Meeting> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1.end == o2.end) {
                return o1.start - o2.start;
            }
            return o1.end - o2.end;
        });

        for (Meeting m : meeting) {
            if (pq.isEmpty()) {
                pq.offer(m);
                continue;
            }

            while (!pq.isEmpty() && pq.peek().end <= m.start) {
                pq.poll();
            }
            pq.offer(m);
            answer = Math.max(answer, pq.size());
        }

        System.out.println(answer);
    }
}

class Meeting {
    int start;
    int end;

    public Meeting(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public String toString() {
        return "Meeting{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}
