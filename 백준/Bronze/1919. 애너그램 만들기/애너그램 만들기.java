import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    /*
    1. 아이디어
    - str1과 str2를 비교하면서 서로 존재하지 않는 문자열 제거 및 카운트
    - dared, bread
        - dared: a: 1,       d: 2, e: 1, r: 1
        - bread: a: 1, b: 1, d: 1, e: 1, r: 1
            - dare
            -
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        String b = br.readLine();

        int[] countA = countString(a);
        int[] countB = countString(b);

        int result = 0;
        for (int i = 0; i < countA.length; i++) {
            result += Math.abs(countA[i] - countB[i]);
        }

        System.out.println(result);
    }

    // 문자열의 단어 개수가 몇개인지 계산
    public static int[] countString(String str) {
        int[] arr = new int[26];

        for (int i = 0; i < str.length(); i++) {
            arr[str.charAt(i) - 'a'] += 1;
        }

        return arr;
    }
}
