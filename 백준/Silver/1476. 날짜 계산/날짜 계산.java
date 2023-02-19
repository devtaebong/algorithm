import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int E = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        System.out.println(solution(E, S, M));
    }

    public static int solution(int E, int S, int M) {
        int count = 0;
        int e = 0;
        int s = 0;
        int m = 0;

        while (true) {
            e++;
            s++;
            m++;
            count++;

            if (e == 16) {
                e = 1;
            }
            if (s == 29) {
                s = 1;
            }
            if (m == 20) {
                m = 1;
            }

            if (E == e && S == s && M == m) {
                break;
            }
        }
        return count;
    }
}