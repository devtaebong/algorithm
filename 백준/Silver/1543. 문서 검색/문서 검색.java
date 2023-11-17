import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String document = br.readLine();
        String keyword = br.readLine();
        
        /*
        1. document의 길이에서 replace 한 문자열의 길이를 뺀다.
        2. 위 결과값을 keyword의 길이로 나눈값이 정답
         */
        String replace = document.replace(keyword, "");
        int count = (document.length() - replace.length()) / keyword.length();
        System.out.println(count);
    }
}

