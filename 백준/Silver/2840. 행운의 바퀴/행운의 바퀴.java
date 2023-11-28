import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] a = (br.readLine().split(" "));
        int n = Integer.parseInt(a[0]);
        int k = Integer.parseInt(a[1]);

        // 입력
        int[] inputStep = new int[k];
        char[] inputAlphabet = new char[k];
        char[] wheel = new char[n];
        Arrays.fill(wheel, '?');

        for (int i = 0; i < k; i++) {
            String[] s = br.readLine().split(" ");
            int step = Integer.parseInt(s[0]);
            char beforeAlphabet = s[1].charAt(0);

            inputStep[i] = step;
            inputAlphabet[i] = beforeAlphabet;
        }

        wheel[0] = inputAlphabet[k - 1];
        int currentIndex = 0;
        for (int i = k - 1; i > 0; i--) {
            int step = inputStep[i];
            char beforeAlphabet = inputAlphabet[i - 1];
            currentIndex = (step + currentIndex) % n;

            if (wheel[currentIndex] == '?') {
                wheel[currentIndex] = beforeAlphabet;
            } else if (wheel[currentIndex] != beforeAlphabet) {
                System.out.println("!");
                return;
            }
        }

        boolean[] check = new boolean[26];
        for (int i = 0; i < n; i++) {
            if (wheel[i] == '?') continue;
            if (check[wheel[i] - 'A']) {
                System.out.println("!");
                return;
            }
            check[wheel[i] - 'A'] = true;
        }

        for (int i = 0; i < wheel.length; i++) {
            System.out.print(wheel[i]);
        }
    }
}
