import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] NM = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        String[] A = new String[NM[0]];
        String[] B = new String[NM[1]];

        for (int i = 0; i < NM[0]; i++) {
            A[i] = br.readLine();
        }

        for (int i = 0; i < NM[1]; i++) {
            B[i] = br.readLine();
        }

        solution(A, B);
    }

    public static void solution(String[] A, String[] B) {
        Arrays.sort(B);
        List<String> res = new ArrayList<>();
        for (String value : A) {
            String str = binarySearch(value, B);
            if (!str.equals("EMPTY")) {
                res.add(str);
            }
        }

        res.sort(String::compareTo);
        System.out.println(res.size());
        res.forEach(System.out::println);
    }

    // arr[] 배열에 value 존재하는지 확인
    public static String binarySearch(String value, String[] arr) {
        int l = 0;
        int r = arr.length - 1;

        while (l <= r) {
            int mid = (l + r) / 2;
            String now = arr[mid];

            if (now.compareTo(value) < 0) {
                l = mid + 1;
            } else if (now.compareTo(value) > 0) {
                r = mid - 1;
            } else {
                return arr[mid];
            }
        }

        return "EMPTY";
    }
}