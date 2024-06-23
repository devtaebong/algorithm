import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int[] numbers;
    static int[] command; // [+, -, x, /] 개수
    static int[] orders; // 연산 순서를 저장한 배열
    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        input();
        solution(1, numbers[1]);
        sb.append(max).append("\n").append(min);
        System.out.println(sb);
    }

    // k번째 순서의 연산자를 계산한다.
    public static void solution(int k, int value) {
        if (k == N) {
            max = Math.max(max, value);
            min = Math.min(min, value);
        } else {
            for (int cand = 1; cand <= 4; cand++) {
                if (command[cand] > 0) {
                    command[cand]--;
                    int newValue = calculator(value, numbers[k + 1], cand);
                    solution(k + 1, newValue);
                    command[cand]++;
                }
            }
        }
    }

    private static int calculator(int operand1, int operand2, int operator) {
        int res = operand1;
        if (operator == 1) {
            res += operand2;
        }
        if (operator == 2) {
            res -= operand2;
        }
        if (operator == 3) {
            res *= operand2;
        }
        if (operator == 4) {
            res /= operand2;
        }
        return res;
    }

    private static void input() throws IOException {
        N = sc.nextInt();
        numbers = new int[N + 1];
        command = new int[5];
        orders = new int[N];

        for (int i = 1; i < N + 1; i++) {
            numbers[i] = sc.nextInt();
        }

        for (int i = 1; i <= 4; i++) {
            command[i] = sc.nextInt();
        }
    }
}
