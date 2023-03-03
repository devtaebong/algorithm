import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] t; // 날자
    static int[] p; // 돈
    static int answer = 0;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        t = new int[n+1];
        p = new int[n+1];


        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            t[i] = x;
            p[i] = y;
        }

        go(1, 0);
        System.out.println(answer);
    }

    private static void go(int day, int sum) {
        // 종료조건
        if (day == n+1) {
            if (answer < sum) {
                answer = sum;
            }
            return;
        }

        if (day > n+1) return;
        go(day+t[day], sum+p[day]);
        go(day+1, sum);
    }
}