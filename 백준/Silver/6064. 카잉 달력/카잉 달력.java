
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // M N x y
        /*
        x와 y를 가지고 해를 표현한다
        1번째 해: <1:1>
        2번째 해: <2:2>

        M = 10, N = 12
        <1:1> <2,2> <3,3> ... <10,10>, <1,11>, <2,12> <3,1>
         */
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int result = solution(M, N, x, y);
            sb.append(result + "\n");
        }
        System.out.println(sb);
    }

    public static int solution(int M, int N, int x, int y) {
        x -= 1;
        y -= 1;

        for (int k = x; k < M*N; k += M) {
            if (k%N == y) {
                return k+1;
            }
        }
        return -1;
    }
}
