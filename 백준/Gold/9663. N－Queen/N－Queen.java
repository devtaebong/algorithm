import java.util.Scanner;

// 백준 N-Queen
public class Main {
    static Scanner sc = new Scanner(System.in);
    static int N;
    static int res;
    static int[] col; // col[i] = i번 행의 퀸은 col[i] 열에 놓았다는 의미


    public static void main(String[] args) {
        input();

        solution(1);

        System.out.println(res);
    }

    public static void solution(int r) {
        if (r == N + 1) {
            res++;
        } else {
            for (int c = 1; c <= N; c++) {
                boolean flag = true;

                for (int i = 1; i < r; i++) {
                    if (isAttack(r, c, i, col[i])) {
                        flag = false;
                        break;
                    }
                }

                if (flag) {
                    col[r] = c;
                    solution(r + 1);
                    col[r] = 0;
                }
            }
        }
    }

    public static boolean isAttack(int r1, int c1, int r2, int c2) {
        if (c1 == c2) return true;
        if (r1 + c1 == r2 + c2) return true;
        if (c1 - r1 == c2 - r2) return true;
        return false;
    }

    public static void input() {
        N = sc.nextInt();
        col = new int[N + 1];
    }
}
