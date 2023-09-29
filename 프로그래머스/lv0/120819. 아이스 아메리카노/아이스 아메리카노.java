class Solution {
    public int[] solution(int money) {
        int coffee = 5500;
        
        int a = money / coffee;
        int b = money % coffee;
        
        int[] answer = new int[2];
        answer[0] = a;
        answer[1] = b;
        
        return answer;
    }
}