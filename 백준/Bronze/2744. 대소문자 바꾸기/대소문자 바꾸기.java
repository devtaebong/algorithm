import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        /*
        90보다 크면 소문자
        90보다 작으면 대문자
        소문자 대문자 차이 -> 32
         */

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (judge(ch)) {
                sb.append((char) (ch + 32));
            } else {
                sb.append((char) (ch - 32));
            }
        }
        System.out.println(sb);
    }
    
    // 대문자 -> true, 소문자 -> false
    public static boolean judge(char ch) {
        return ch < 90;
    }
}
