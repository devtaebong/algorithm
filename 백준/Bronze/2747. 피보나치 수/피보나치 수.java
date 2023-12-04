import java.io.*;

public class Main {
    public static int[] cache = new int[50];

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        System.out.println(fibo(n));
    }

    public static int fibo(int n) {
        if (n < 2) {
            return n;
        }

        if (cache[n] != 0) {
            return cache[n];
        }
        
        cache[n] = fibo(n - 1) + fibo(n - 2);

        return cache[n];
    }
}
