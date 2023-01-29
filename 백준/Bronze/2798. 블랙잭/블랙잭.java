import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    // 블랙잭
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // n 장의 카드가 주어진다.
        // n장의 카드 중에서 3장을 골라 m을 넘지 않는 최대수를 만들어야한다.
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // n장의 카드를 담는다.
        List<Integer> card = new ArrayList<>();
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            card.add(Integer.parseInt(st2.nextToken()));
        }

        // 카드를 담은 리스트를 순회하면서 3장의 수를 더한다.
        // m보다 작으면 result 에 대입
        // 다음 결과가 현재 result 보다 크면 result 에 대입
        // 현재 결과가 m보다 크면 pass
        int result = 0;
        for(int i = 0; i < card.size() - 2; i++) {
            for(int j = i+1; j < card.size() - 1; j++) {
                for(int k = j+1; k < card.size(); k++) {

                    if( (card.get(i) + card.get(j) + card.get(k) <= m) &&
                        (card.get(i) + card.get(j) + card.get(k) > result) ) {
                        result = card.get(i) + card.get(j) + card.get(k);
                    }

                }
            }
        }
        System.out.println(result);
    }
}
