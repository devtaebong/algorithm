import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String current = br.readLine(); // 현재시간
        String drop = br.readLine(); // 목표시간
        int currentSec = parseMilSec(current);
        int dropSec = parseMilSec(drop);

        int gapTime = dropSec - currentSec;
        if (gapTime <= 0) {
            gapTime += 24 * 3600;
        }

        int hour = gapTime / 3600;
        int min = (gapTime - (hour * 3600)) / 60;
        int sec = gapTime % 60;

        System.out.printf("%02d:%02d:%02d", hour, min, sec);
    }

    public static int parseMilSec(String time) {
        String[] arr = time.split(":");
        int h = Integer.parseInt(arr[0]) * 3600;
        int m = Integer.parseInt(arr[1]) * 60;
        int s = Integer.parseInt(arr[2]);

        return h + m + s;
    }
}
