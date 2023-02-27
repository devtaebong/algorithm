import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int n = 0;
    static int m = 0;
    static boolean[] ch;
    static int[] a;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        ch = new boolean[n+1];
        a = new int[n];
        DFS(0);
        System.out.println(sb);
    }

    private static void DFS(int idx) {
        if (m == idx) {
            // 출력
            for (int i = 0; i < m; i++) {
                sb.append(a[i] + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= n; i++) {
            if(ch[i]) continue;

            ch[i] = true;
            a[idx] = i;
            DFS(idx+1);
            ch[i] = false;
        }
    }
}