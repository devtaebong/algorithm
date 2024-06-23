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
        solution(1);
        sb.append(max).append("\n").append(min);
        System.out.println(sb);
    }

    // k번째 순서의 연산자를 계산한다.
    public static void solution(int k) {
        if (k == N) {
            int res = calculator();
            max = Math.max(res, max);
            min = Math.min(res, min);
        }

        else {
            for (int i = 1; i <= 4; i++) {
                if (command[i] != 0) {
                    command[i]--;
                    orders[k] = i;
                    solution(k + 1);
                    command[i]++;
                    orders[k] = 0;
                }
            }
        }
    }

    private static int calculator() {
        int value = numbers[1];
        for (int i = 1; i < orders.length; i++) {
            if (orders[i] == 1) {
                value += numbers[i + 1];
            }
            if (orders[i] == 2) {
                value -= numbers[i + 1];
            }
            if (orders[i] == 3) {
                value *= numbers[i + 1];
            }
            if (orders[i] == 4) {
                value /= numbers[i + 1];
            }
        }
        return value;
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
