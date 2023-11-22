import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    /*
    1. 아이디어
    - 회문인 수 판별
        1110111, n = 7, n/2 = 3
        765567, n = 6, n/2 = 3
        - s[0] == s[(length-1) - 0]
        - s[1] == s[(length-1) - 1]
        - s[2] == s[(length-1) - 2]
        - ...
        - s[i] == s[(length-1) - i]
        i => n/2 까지 => i < n/2
    - num을 B진법으로 변환 후 브루트포스 대입

    2. 시간 복잡도
    - T * B
    - O(TB)
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            String input = br.readLine();
            System.out.println(getResult(input));
        }
    }
    
    public static int getResult(String input) {
        for (int i = 2; i <= 64; i++) {
            String result = translator(input, i);
            if (isCircular(result)) {
                return 1;
            }
        }
        return 0;
    }

    public static String translator(String s, int b) {
        if (b == 10) {
            return s;
        }

        int num = Integer.parseInt(s);

        String temp = "";
        while (num > 0) {
            int mod = num % b;
            if (mod < 10) {
                temp += mod;
            } else {
                temp += (char) (mod + 'A' - 10);
            }
            num /= b;
        }

        String ans = "";
        for (int i = temp.length() - 1; i >= 0; i--) {
            ans += temp.charAt(i);
        }
        return ans;
    }


    // 회문인 수 판별 -> 회문이면 true, 아니면 false
    public static boolean isCircular(String s) {
        int n = s.length();
        for (int i = 0; i < n / 2; i++) {
            char start = s.charAt(i);
            char end = s.charAt((n - 1) - i);

            if (start != end) return false;
        }
        return true;
    }
}
