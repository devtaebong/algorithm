import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int M;
    static int[] selected;
    static boolean[] check;

    public static void main(String[] args) throws IOException {
        input();

        // N까지 자연수 중 중복없이 M개의 수를 고른다.
        recursive(1, 1);

        System.out.println(sb);
    }

    // k는 현재 선택된 숫자의 위치, start는 후보 숫자의 시작점
    public static void recursive(int k, int start) {
        // base case: M개의 숫자를 모두 선택한 경우
        if (k == M + 1) {
            // 선택된 M개의 숫자를 StringBuilder에 추가
            for (int i = 1; i <= M; i++) {
                sb.append(selected[i]).append(' ');
            }
            sb.append("\n");
        } else {
            // start부터 N까지의 숫자 중에서 선택
            for (int candidate = start; candidate <= N; candidate++) {
                // 해당 숫자가 이미 선택된 경우 넘어감
                if (check[candidate]) continue;

                // 숫자 선택 표시 및 저장
                check[candidate] = true;
                selected[k] = candidate;

                // 재귀 호출: 다음 위치(k + 1)와 다음 시작점(candidate + 1)으로 진행
                recursive(k + 1, candidate + 1);

                // 백트래킹: 선택 해제 및 초기화
                check[candidate] = false;
                selected[k] = 0;
            }
        }
    }

    // 입력을 받아서 N과 M을 설정하고 배열 초기화
    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] nm = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        N = nm[0];
        M = nm[1];

        selected = new int[M + 1];
        check = new boolean[N + 1];
    }
}
