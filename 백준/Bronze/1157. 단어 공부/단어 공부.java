import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int[] countStr = getAlphabetCount(str);

        int maxCount = 0;
        char maxAlphabet = '?';
        for (int i = 0; i < countStr.length; i++) {
            if (maxCount < countStr[i]) {
                maxCount = countStr[i];
                maxAlphabet = (char) (i + 'A');
            }

            else if (maxCount == countStr[i] && countStr[i] != 0) {
                maxAlphabet = '?';
            }
        }

        System.out.println(maxAlphabet);
    }

    // 대소문자를 구분하지 않는다.
    public static int[] getAlphabetCount(String str) {
        int[] arr = new int[26];
        str = str.toUpperCase();

        for (int i = 0; i < str.length(); i++) {
            char C = str.charAt(i);
            arr[C - 'A']++;
        }

        return arr;
    }
}
