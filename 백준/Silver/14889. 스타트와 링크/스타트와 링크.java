import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class Main {
    static int[][] matrix;
    static int n;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        matrix = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int x = Integer.parseInt(st.nextToken());
                matrix[i][j] = x;
            }
        }

        go(0, new ArrayList<>(), new ArrayList<>());
        System.out.println(answer);
    }

    public static void go(int idx, List<Integer> first, List<Integer> second) {
        // 종료조건 (정답을 찾은 경우)
        if (idx == n) {
            if (first.size() != n/2) return;
            if (second.size() != n/2) return;

            int tmp1 = 0;
            int tmp2 = 0;

            for (int i = 0; i < first.size()-1; i++) {
                for (int j = i+1; j < first.size(); j++) {
                    int A = first.get(i);
                    int B = first.get(j);
                    tmp1 += matrix[A][B];
                    tmp1 += matrix[B][A];

                    int C = second.get(i);
                    int D = second.get(j);
                    tmp2 += matrix[C][D];
                    tmp2 += matrix[D][C];
                }
            }

            int res = Math.abs(tmp1-tmp2);
            if (res < answer) {
                answer = res;
            }
            return;
        }

        // 백트래킹 -> 한 팀의 수가 절반을 넘으면 다른 팀을 구성할 수 없게된다 -> 조건에 맞지 않아 메서드 종료
        if (first.size() > n/2) return;
        if (second.size() > n/2) return;

        first.add(idx);
        go(idx+1, first, second);
        first.remove(first.size()-1);

        second.add(idx);
        go(idx+1, first, second);
        second.remove(second.size()-1);
    }
}
