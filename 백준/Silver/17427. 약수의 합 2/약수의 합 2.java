import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += (long) (n / i) * i;
        }
        System.out.println(sum);
    }
}