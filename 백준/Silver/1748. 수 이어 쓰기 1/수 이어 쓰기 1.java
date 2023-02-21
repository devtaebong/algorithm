import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long answer = 0;
        for (int i = 1, j = 1; i <= n; i *= 10, j++) {
            int lastNum = i * 10 - 1;
            if (n < lastNum) {
                lastNum = n;
            }

            answer += (long) (lastNum - i + 1) * j;
        }

        System.out.println(answer);
    }
}