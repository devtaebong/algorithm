import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int q = Integer.parseInt(str[1]);

        // 구간 합 배열 구하기
        String[] inputArr = br.readLine().split(" ");
        int[] arr = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            arr[i] = Integer.parseInt(inputArr[i - 1]);
        }

        int[] acc = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            acc[i] = acc[i - 1] ^ arr[i];
        }

        int ans = 0;
        for (int i = 0; i < q; i++) {
            String[] s = br.readLine().split(" ");
            int x = Integer.parseInt(s[0]);
            int y = Integer.parseInt(s[1]);
            ans ^= acc[y] ^ acc[x - 1];
        }
        System.out.println(ans);
    }

}
