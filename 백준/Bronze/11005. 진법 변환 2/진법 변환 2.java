import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        long n = Integer.parseInt(s[0]);
        int b = Integer.parseInt(s[1]);

        /*
        - n을 b로 나눈 나머지를 구한다.
        - n이 0이 될때까지 반복
        - 나눈 나머지를 역순으로 출력
         */

        String result = "";
        while (n != 0) {
            int mod = (int) n % b;
            if (mod < 10) {
                result += mod;
            } else {
                result += (char) (mod + 'A' - 10);
            }
            n = n / b;
        }

        for (int i = result.length() - 1; i >= 0 ; i--) {
            System.out.print(result.charAt(i));
        }
    }
}
