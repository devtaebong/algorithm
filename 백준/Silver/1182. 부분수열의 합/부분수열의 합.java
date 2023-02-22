
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    static int n;
    static int s;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        DFS(0, 0);
        if (s==0) {
            System.out.println(count-1);
        } else {
            System.out.println(count);
        }
    }

    private static void DFS(int L, int sum) {
        if (L == n) {
            if (sum==s) {
                count++;
            }
        } else {
            DFS(L+1, sum + arr[L]);
            DFS(L+1, sum);
        }
    }
}
