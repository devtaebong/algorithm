
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static boolean[] ch;
    static int[] arr;
    static int[] res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String testCase = br.readLine();
            if (testCase.equals("0")) break;

            String[] input = testCase.split(" ");
            int n = Integer.parseInt(input[0]);
            ch = new boolean[n];
            arr = new int[n];
            res = new int[6];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(input[i+1]);
            }

            Arrays.sort(arr);
            go(0, 0);
            System.out.println();
        }
    }

    private static void go(int idx, int k) {
        if (idx == 6) {
            // 수열을 출력
            for (int i = 0; i < res.length; i++) {
                System.out.print(res[i] +" ");
            }
            System.out.println();
            return;
        }

        for (int i = k; i < arr.length; i++) {
            if (!ch[i]) {
                ch[i] = true;
                res[idx] = arr[i];
                go(idx+1, i+1);
                ch[i] = false;
            }
        }
    }
}
