import java.util.concurrent.CompletableFuture;

class Solution {
    public int solution(int n) {
        int answer = 0;
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(
            () -> getEvenNumber(n)
        );
        
        try {
            return future.get();
        } catch (Exception e) {
            return - 1;
        }
    }
    
    private int getEvenNumber(int n) {
        return java.util.stream.IntStream.rangeClosed(1, n)
            .filter(num -> num % 2 == 0)
            .sum();
    }
}