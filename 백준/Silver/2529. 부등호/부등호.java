
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int k;
    static boolean[] ch = new boolean[10];
    static List<String> answer = new ArrayList<>();
    static char[] a;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());
        a = new char[k];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            char x = st.nextToken().toCharArray()[0];
            a[i] = x;
        }
        
        go(0, "");
        Collections.sort(answer);
        System.out.println(answer.get(answer.size()-1));
        System.out.println(answer.get(0));
    }

    private static void go(int idx, String num) {
        if (idx == k+1) {
            // 출력
            answer.add(num);
            return;
        }

        for (int i = 0; i <= 9; i++) {
            if (ch[i]) continue;
            if (idx == 0 || good(num.charAt(idx-1), (char)(i+'0'), a[idx-1])) {
                ch[i] = true;
                go(idx+1, num+i);
                ch[i] = false;
            }
        }
    }

    // 브루트포스
//    private static boolean isOk(String num) {
//        for (int i = 0; i < num.length()-1; i++) {
//            // 1<2<3<4<5
//            if (a[i] == '<') {
//                if (num.charAt(i) > num.charAt(i+1)) return false;
//            }
//
//            if (a[i] == '>') {
//                if (num.charAt(i) < num.charAt(i+1)) return false;
//            }
//        }
//        return true;
//    }


    // 백트래킹
    private static boolean good(char x, char y, char op) {
        if (op == '<') {
            if (x > y) return false;
        }

        if (op == '>') {
            if (x < y) return false;
        }

        return true;
    }
}
