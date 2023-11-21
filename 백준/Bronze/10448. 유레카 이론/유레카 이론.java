import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    /*
    1. 아이디어
    - 자연수(N)가 주어졌을 때 그 자연수가 3개의 삼각수의 합으로 표현할 수 있는지?
    - 1 ~ N 까지의 합을 배열에 저장
    - 정확히 a[i] + a[j] + a[k] == N 이 되면 1리턴
        - i, j, k는 같은 수 일 수 있음
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            if (isEureka(n)) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }

    public static boolean isEureka(int n) {
        int[] a = new int[n+1];
        for (int i = 1; i <= n; i++) {
            a[i] = a[i-1] + i;
        }

        for (int i = 1; i <= n-2; i++) {
            for (int j = i; j <= n-1; j++) {
                for (int k = j; k <= n; k++) {
                    if (a[i] + a[j] + a[k] == n) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
