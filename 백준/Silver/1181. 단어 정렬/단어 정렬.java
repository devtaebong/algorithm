import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String[] str = new String[n];
        for (int i = 0; i < n; i++) {
            str[i] = br.readLine();
        }

        String[] distinctArr = Arrays.stream(str).distinct().toArray(String[]::new);

        Arrays.sort(distinctArr, (o1, o2) -> {
            // 길이가 같다면 사전순
            if (o1.length() == o2.length()) {
                return o1.compareTo(o2);
            }
            // 길이가 짧은것 리턴
            return o1.length() - o2.length();
        });

        for (int i = 0; i < distinctArr.length; i++) {
            System.out.println(distinctArr[i]);
        }
    }
}
