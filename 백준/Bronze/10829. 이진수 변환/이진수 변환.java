import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        recursive(n);
        System.out.println(sb);
    }

    public static void recursive(long x) {
        if (x == 0) return;

        else {
            recursive(x/2);
            sb.append(x%2);
        }
    }
}