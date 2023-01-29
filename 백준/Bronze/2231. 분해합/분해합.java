import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //분해합
        // System.setIn(new FileInputStream("src/BOJ/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 자연수 n의 가장 작은 생성자를 구하는 프로그램
        int n = Integer.parseInt(br.readLine());
        System.out.println(solution(n));
    }

    public static int solution(int n) {
        for (int i = 0; i < n; i++) {
            if (sum(i) == n) {
                return i;
            }
        }
        return 0;
    }

    public static int sum(int n) {
        int result = n;

        while (n >= 1) {
            result += n % 10;
            n /= 10;
        }
        return result;
    }
}
