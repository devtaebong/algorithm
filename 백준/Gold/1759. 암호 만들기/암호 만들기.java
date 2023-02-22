
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int L;
    static int C;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 암호는 서로다른 L개의 소문자로 구성됨 -> 암호의 길이 (입력으로 주어진다)
        // 최소 한개 이상의 모음과 두개 이상의 자음
        // 문자의 종류 C가지 (입력으로 주어진다)
        // 가능성 있는 암호를 모두 구하는 문제
        // 암호는 오름차순으로 정렬
        // 오름차순정렬로 출력

        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken()); // 3 ~ 15
        C = Integer.parseInt(st.nextToken()); // 3 ~ 15

        st = new StringTokenizer(br.readLine());
        String[] alpha = new String[C];
        for (int i = 0; i < C; i++) {
            String x = st.nextToken();
            alpha[i] = x;
        }
        Arrays.sort(alpha);

        BFS(alpha, 0, "");
    }

    public static void BFS(String[] alpha, int i, String password) {
        if (password.length() == L) {
            if(check(password)) {
                System.out.println(password);
            }
            return;
        }

        if (i >= alpha.length) return;
        else {
            BFS(alpha, i+1, password + alpha[i]);
            BFS(alpha, i+1, password);
        }
    }

    private static boolean check(String password) {
        int mo = 0;
        int ja = 0;

        for (int i = 0; i < password.length(); i++) {
            if (password.charAt(i) == 'a' || password.charAt(i) == 'e' || password.charAt(i) == 'i' || password.charAt(i) == 'o' || password.charAt(i) == 'u') {
                mo++;
            } else {
                ja++;
            }

            if (mo >= 1 && ja >= 2) {
                return true;
            }
        }
        return false;
    }
}
