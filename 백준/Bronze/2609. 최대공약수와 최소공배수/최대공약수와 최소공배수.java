import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int gcb = GCB(a, b);
        int lcm = LCM(a, b, gcb);

        StringBuilder sb = new StringBuilder();
        sb.append(gcb+"\n");
        sb.append(lcm+"\n");
        System.out.println(sb);
    }

    // 최대공약수
    public static int GCB(int a, int b) {
        return b == 0 ? a : GCB(b,a%b);
    }

    // 최소공배수
    public static int LCM(int a, int b, int gcb) {
        return gcb * (a/gcb) * (b/gcb);
    }
}