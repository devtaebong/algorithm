import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static boolean arr[] = new boolean[10];
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        if (m != 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                int x = Integer.parseInt(st.nextToken());
                arr[x] = true;
            }
        }

        System.out.println(solution(n));
    }

    public static int solution(int n) {
        if (n == 100) {
            return 0;
        }

        int answer = Math.abs(n - 100);
        for (int i = 0; i < 1000000; i++) {
            int len = check(i);
            int cnt = Math.abs(n - i);

            int a = len + cnt;
            if (answer > a && len != 0) {
                answer = a;
            }
        }
        return answer;
    }

    public static int check(int num) {
        if (num == 0) {
            if (arr[0]) {
                return 0;
            } else {
                return 1;
            }
        }

        int count = 0;
        while (num > 0) {
            int x = num % 10;
            if (arr[x]) {
                return 0;
            }
            num /= 10;

            count++;
        }
        return count;
    }
}