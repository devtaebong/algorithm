import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    static int k;
    static boolean[] ch = new boolean[10];
    static List<String> answer = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());

        String str = br.readLine().replace(" ","");

        go(0, "", str);
        answer.sort(Comparator.reverseOrder());
        System.out.println(answer.get(0));
        System.out.println(answer.get(answer.size()-1));
    }

    private static void go(int idx, String num, String str) {
        if (idx == k+1) {
            // 출력
            if (isOk(num, str)) {
                answer.add(num);
            }
            return;
        }

        for (int i = 0; i <= 9; i++) {
            if (ch[i]) continue;

            ch[i] = true;
            go(idx+1, num + i, str);
            ch[i] = false;
        }

    }

    private static boolean isOk(String num, String str) {
        for (int i = 0; i < num.length()-1; i++) {
            // 1<2<3<4<5
            if (str.charAt(i) == '<') {
                if (num.charAt(i) > num.charAt(i+1)) return false;
            }

            if (str.charAt(i) == '>') {
                if (num.charAt(i) < num.charAt(i+1)) return false;
            }
        }

        return true;
    }
}
