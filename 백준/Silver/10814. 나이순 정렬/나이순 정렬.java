import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Member[] members = new Member[n];
        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            int age = Integer.parseInt(s[0]);
            String name = s[1];
            members[i] = new Member(age, name, i);
        }

        Arrays.sort(members, (o1, o2) -> {
            // 나이를 비교
            return o1.getAge() - o2.getAge();
        });

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb
                .append(members[i].getAge())
                .append(" ")
                .append(members[i].getName())
                .append("\n");
        }
        System.out.println(sb);
    }
}

class Member {
    private int age;
    private String name;
    private int index;

    public Member(int age, String name, int index) {
        this.age = age;
        this.name = name;
        this.index = index;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public int getIndex() {
        return index;
    }
}