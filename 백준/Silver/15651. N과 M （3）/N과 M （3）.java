
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;
    static int[] a;
    static boolean[] ch;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        a = new int[m+1];
        ch = new boolean[n+1];

        BFS(0);
        System.out.println(sb);
    }

    private static void BFS(int idx) {
        if (idx == m) {
            // 출력
            for (int i = 0; i < m; i++) {
                sb.append(a[i]+" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = 1; i <= n; i++) {
            a[idx] = i;
            BFS(idx+1);
        }
    }
}
