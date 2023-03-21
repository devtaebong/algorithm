
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int m = Integer.parseInt(br.readLine());
        int S = 0;

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String operator = st.nextToken();

            if (operator.equals("add")) {
                int a = Integer.parseInt(st.nextToken());
                S |= (1<<a);
            }

            if (operator.equals("check")) {
                int a = Integer.parseInt(st.nextToken());
                if ((S & (1<<a)) == 0) {
                    sb.append(0 + "\n");
                } else {
                    sb.append(1 + "\n");
                }
            }
            if (operator.equals("remove")) {
                int a = Integer.parseInt(st.nextToken());
                S &= ~(1<<a);
            }
            if (operator.equals("toggle")) {
                int a = Integer.parseInt(st.nextToken());
                S ^= (1<<a);
            }
            if (operator.equals("all")) {
                S = 2097150;
            }
            if (operator.equals("empty")) {
                S=0;
            }
        }
        System.out.println(sb);
    }
}
