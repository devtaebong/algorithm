import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static boolean res;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] NB = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int N = NB[0];
        int B = NB[1];

        char[] arr = new char[36];

        for (int i = 0; i < 26; i++) {
            arr[i + 10] = (char) (65 + i);
        }

        StringBuilder sb = new StringBuilder();
        while(N > 0) {
            int mod = N % B;
            if (mod < 10) {
                sb.append(mod);
            } else {
                sb.append(arr[mod]);
            }
            N /= B;
        }

        String str = sb.toString();
        StringBuilder res = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            res.append(str.charAt(i));
        }
        System.out.println(res);
    }
}