import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
7명의 학생으로 구성
- 7개의 연결된 칸을 선택했을 때 S가 4개 이상 포함되는 조합의 개수
    - 가로5 + 세로2 에 S가 4이상
    - 가로2 + 세로5 에 S가 4이상

1. 아이디어
- 브루트포스 (5 x 5 => 입력이 크지 않음)
    - 임위의 7개 칸을 선택
    - 연결되어 있는지 확인 (상하좌우)
    - S를 4개 이상 포함하는지 확인

- 7명을 뽑는 방법?

- 연결되어 있는지 확인?
    - dfs => count == 7 (연결요소)

- S가 4개 이상인지 확인?
    - 조합으로 뽑은 칸을 직접 확인
 */

public class Main {
    static int ans = 0;
    static char[][] matrix;
    static boolean[] check;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        matrix = new char[5][5];
        for (int i = 0; i < 5; i++) {
            String input = br.readLine();
            for (int j = 0; j < 5; j++) {
                char c = input.charAt(j);
                matrix[i][j] = c;
            }
        }

        // 25명의 학생 중 뽑은 학생을 체크
        check = new boolean[25];
        combination(0, 0);
        System.out.println(ans);
    }

    // 7개의 칸을 선택한다 -> 브루트포스
    public static void combination(int start, int depth) {
        // base case
        if (depth == 7) {
            List<Integer> res = new ArrayList<>();
            for (int i = 0; i < check.length; i++) {
                if (check[i]) {
                    res.add(i);
                }
            }

            visit = new boolean[25];
            int count = 0;
            for (int i = 0; i < res.size(); i++) {
                int current = res.get(i);
                int row = current / 5;
                int col = current % 5;
                if (matrix[row][col] == 'S') {
                    count++;
                }
            }

            // 7개의 요소가 인접했다면
            if (dfs(res.get(0), res) == 7 && count >= 4) {
                ans++;
            }
        }

        // recursive case
        for (int i = start; i < 25; i++) {
            if (!check[i]) {
                check[i] = true;
                combination(i + 1, depth + 1);
                check[i] = false;
            }
        }
    }

    public static int dfs(int current, List<Integer> res) {
        visit[current] = true;

        int count = 1;
        for (int i = 1; i < res.size(); i++) {
            int next = res.get(i);
            if (!visit[res.get(i)] && isFriend(current, next)) {
                count += dfs(res.get(i), res);
            }
        }
        return count;
    }

    // 두수가 인접해있는지?
    public static boolean isFriend(int a, int b) {
        int abs = Math.abs(a - b);
        int max = Math.max(a, b);

        // abs는 1 또는 5이어야함
        if (abs == 1 && max % 5 != 0) {
            return true;
        }

        if (abs == 5) {
            return true;
        }

        return false;
    }
}
