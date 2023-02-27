import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
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

        DFS(0, 0);
        System.out.println(sb);
    }

    private static void DFS(int idx, int k) {
        if (idx == m) {
            // 출력
            for (int i = 0; i < m; i++) {
                sb.append(a[i]+" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = k+1; i <= n; i++) {
            if (ch[i]) continue;

            a[idx] = i;
            ch[idx] = true;
            DFS(idx+1, i);
        }

        Arrays.fill(ch, false);
    }
}