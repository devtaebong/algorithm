import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        MaxPriorQueue q = new MaxPriorQueue();

        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            int x = Integer.parseInt(br.readLine());

            if (x == 0) {
                System.out.println(q.pop());
            } else {
                q.push(x);
            }
        }
    }
}

class MaxPriorQueue {
    private int[] heap;
    private int size;

    public MaxPriorQueue() {
        heap = new int[100001];
        size = 0;
    }

    // x값 넣기
    public void push(int x) {
        /*
        왼쪽 자식: idx * 2
        오른쪽 자식: idx * 2 + 1

        완전 이진트리 마지막 자리에 값을 넣고
        x가 부모노드의 값 보다 크다면 위치를 변경한다.
         */
        heap[++size] = x;
        int currentIdx = size;
        while (currentIdx > 1) {
            // 부모노드 인덱스
            int parentIdx = currentIdx / 2;
            if (heap[parentIdx] >= heap[currentIdx]) {
                break;
            }
            swap(currentIdx, parentIdx);
            currentIdx = parentIdx;
        }
    }

    // 가장 큰 값 출력후 배열에서 제거
    public int pop() {
        /*
        루트노드를 제거하고 가장 마지막 노드를 루트로 올림
        루트가 자식보다 작으면 위치를 변경
        자식 중 더 작은 값이랑 교환
         */
        if (size == 0) {
            return 0;
        }

        int ret = heap[1];
        heap[1] = heap[size--];

        int current = 1;

        while (current * 2 <= size) {
            int left = current * 2;
            int right = left + 1;
            int child = left;
            if (right <= size && heap[left] < heap[right]) {
                child = right;
            }

            if (heap[current] >= heap[child]) {
                break;
            }

            swap(current, child);
            current = child;
        }
        return ret;
    }

    private void swap(int a, int b) {
        int temp = heap[a];
        heap[a] = heap[b];
        heap[b] = temp;
    }
}
