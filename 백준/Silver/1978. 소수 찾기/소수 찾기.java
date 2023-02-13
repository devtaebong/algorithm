import java.io.*;

import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
        }

        int cnt = 0;
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            if (num == 1) cnt++;
            
            for(int j = 2; j*j <= num; j++) {
                if (num % j == 0) {
                    cnt++;
                    break;
                }
            }
        }
        System.out.println(arr.length - cnt);
    }
}