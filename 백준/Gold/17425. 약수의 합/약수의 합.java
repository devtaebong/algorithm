import java.io.*;

public class Main {
    static final int MAX = 1000000;
    public static void main(String[] args) throws IOException {

        long[] d = new long[MAX + 1];
        for (int i = 1; i <= MAX; i++) {
            d[i] = 1;
        }

        for (int i = 2; i <= MAX; i++) {
            for(int j = 1; i*j <= MAX; j++) {
                d[i*j] += i;
            }
        }

        long[] s = new long[MAX + 1];
        for (int i = 1; i <= MAX; i++) {
            s[i] = s[i-1] + d[i];
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            sb.append(s[n] + "\n");
        }
        System.out.println(sb);
    }
}