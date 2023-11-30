import java.io.*;
import java.util.*;

public class Main {

    /*
    0. 입력
    - 현재 회사에 있는 사람은?
    - 현재 회사에 있는 사람의 이름을 역순으로 -> o2 - o1
    - 동명이인 x, 대소문자가 다르면 다름사람

    1. 아이디어
    - 입력을 받는다
        - enter => 추가 O(1)
        - leave => 삭제 O(N)
    - 내림차순 정렬 -> O(NlogN)

    2. 시간복잡도


    3. 자료구조

     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 이름 순서에 따라 출입기록을 정렬한다.
        // 각 사원마다 마지막 기록이 enter 인지 확인한다.
            // 마지막 기록이 enter 라면 출력한다.
        int n = Integer.parseInt(br.readLine());
        Set<String> memberSet = new TreeSet();
        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            String memberName = s[0];
            String status = s[1];

            if (status.equals("enter")) {
                memberSet.add(memberName);
            }

            else if (status.equals("leave")) {
                memberSet.remove(memberName);
            }

        }

        List<String> ans = new ArrayList<>(memberSet);
        for(int i = ans.size() - 1; i >= 0; i--) {
            System.out.println(ans.get(i));
        }
    }
}
