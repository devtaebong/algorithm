
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());


        int answer = 0;
        int count = 0;
        int sum = 0;
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            count = getCount(sum, count, n);
            answer += count;
            System.out.println(answer);
            answer = 0;
        }
    }


    private static int getCount(int sum, int count, int n) {

        if (sum > n) return 0;
        if (sum == n) return 1;

        int num = 0;
        for (int i = 1; i <= 3; i++) {
            num += getCount(sum+i, count+1, n);
        }
        return num;
    }
}
