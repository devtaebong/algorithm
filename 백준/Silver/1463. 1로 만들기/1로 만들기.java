import java.io.*;

public class Main {
    static int[] memo;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());
        memo = new int[x+3];
        memo[1] = 0;
        memo[2] = 1;
        memo[3] = 1;

        for (int i = 4; i <= x; i++) {
            go(i, i);
        }

        System.out.println(memo[x]);
    }

    public static void go(int idx,  int x) {
        int a = Integer.MAX_VALUE;
        int b = Integer.MAX_VALUE;
        int c = Integer.MAX_VALUE;

        if (x % 3 == 0) {
            if (memo[x/3] != 0) {
                a = memo[x/3]+1;
            }
        }

        if (x % 2 == 0) {
            if (memo[x/2] != 0) {
                b = memo[x/2] + 1;
            }
        }

        if (memo[x-1] != 0) {
            c = memo[x-1] + 1;
        }

        int k = Math.min(a, b);
        int min = Math.min(k, c);
        memo[idx] = min;
    }
}
