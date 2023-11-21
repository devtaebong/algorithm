import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) throws IOException {
        solution();
    }

        public static void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        int[] list = new int[n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            list[i] = Integer.valueOf(br.readLine());

            if (list[i] > max) max = list[i];
        }

        int[] counting = new int[max+1];
        for (int i = 0; i < list.length; i++) {
            int num = list[i];
            counting[num]++;
        }
        for (int i = 1; i < counting.length; i++) {
            counting[i] += counting[i-1];
        }


        int[] answer = new int[list.length];
        for (int i = list.length - 1; i >= 0; i--) {
            int value = list[i];
            int index = counting[value]--;

            answer[index-1] = value;
        }

        for (int i : answer) {
            sb.append(i).append("\n");
        }

        System.out.println(sb);
    }
}