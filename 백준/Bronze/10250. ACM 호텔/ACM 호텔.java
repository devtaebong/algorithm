import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    /*
    0. 입력
    - H층 건물
    - 한 층에 W개의 방이 있음
    - H = 6, W = 12 => H x W 호텔 => H: row, W: col
    - 방 번호는 HHWW로 효시
    - 걸어가는 거리가 짧은 방을 선호
    - 걸어가는 거리가 같다면 아래층을 선호
    - N번째로 도착한 손님에게 배정할 방 번호를 계산

    1. 아이디어
    - H: 6, W: 12 일때, 10번째 손님은 402호
    - N을 1씩 줄이면서
        - hCount 1씩 증가
        - hCount == H => wCount 1증가, hCount = 0

    2. 시간복잡도
    - O(TN)

    3. 자료구조
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            String[] input = br.readLine().split(" ");
            int H = Integer.parseInt(input[0]);
            int W = Integer.parseInt(input[1]);
            int N = Integer.parseInt(input[2]);

            int floor = (N - 1) % H + 1;
            int distance = (N - 1) / H + 1;
            String result = "";
            result += floor;
            if (distance < 10) {
                result += "0" + distance;
            } else {
                result += distance;
            }
            System.out.println(result);
        }
    }
}
