import java.util.*;

/*
n: 당구대 세로 길이
m: 당구대 가로 길이
startX: 쳐야하는 공의 X 위치
startY: 쳐야하는 공의 Y 위치

*/

class Solution {
    final int INF = 2000000 + 1;
    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        int[] answer = new int[balls.length];
        
        for (int i = 0; i < balls.length; i++) {
            int[] ball = balls[i];
            int ballX = ball[0];
            int ballY = ball[1];
            
            int min = INF;
            // 좌
            if (!(startY == ballY && startX > ballX)) {
                min = Math.min(getDistance(startX, startY, -ballX, ballY), min);
            }
            
            // 우
            if (!(startY == ballY && ballX > startX)) {
                min = Math.min(getDistance(startX, startY, m + m - ballX, ballY), min);
            }
            
            // 상
            if (!(startX == ballX && ballY > startY)) {
                min = Math.min(getDistance(startX, startY, ballX, n + n - ballY), min);
            }
            
            // 하
            if (!(startX == ballX && startY > ballY)) {
                min = Math.min(getDistance(startX, startY, ballX, -ballY), min);
            }
            answer[i] = min;
        }
        
        return answer;
    }
    
    private int getDistance(int startX, int startY, int ballX, int ballY) {
        return (int) (Math.pow(startX - ballX , 2) + Math.pow(startY - ballY, 2));
    }
}