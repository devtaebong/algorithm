import java.io.*;

public class Main {
    static int T;
    static int cnt;
    static String s;

    public static void main(String[] args) throws IOException {
        input();

    }

    public static void input() throws IOException {
        // System.setIn(new FileInputStream("src/BOJ/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i<T; i++){
            s = br.readLine();
            System.out.println(isPalindrome(s) + " "+cnt);
        }
    }

    public static int recursion(String s, int l, int r){
        cnt++;
        if(l >= r) return 1;

        else if(s.charAt(l) != s.charAt(r)) return 0;
        else return recursion(s, l+1, r-1);
    }

    public static int isPalindrome(String s){
        cnt=0;
        return recursion(s, 0, s.length()-1);
    }
}
