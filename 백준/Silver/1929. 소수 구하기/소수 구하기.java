import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        boolean[] check = new boolean[n+1];
        check[0] = check[1] = true;

        // false 이면 소수, true 이면 소수 아님
        for (int i = 2; i*i <= n; i++) {
            for(int j = 2; i*j <= n; j++) {
                check[i*j] = true;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = m; i < check.length; i++) {
            if (check[i] == false) {
                sb.append(i + "\n");
            }
        }
        System.out.println(sb);
    }
}