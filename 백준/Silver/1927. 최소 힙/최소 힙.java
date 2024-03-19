import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        MinPriorQueue q = new MinPriorQueue();
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

class MinPriorQueue {
    int[] heap;
    int size;

    public MinPriorQueue() {
        heap = new int[100001];
        size = 0;
    }

    // 배열에 자연수 x를 넣는다
    public void push(int x) {
        // 배열의 마지막 인덱스에 x 추가
        heap[++size] = x;

        int current = size;
        while (current > 1) {

            // 부모노드가 현재 값보다 작거나 같으면 break
            int parent = current / 2;
            if (heap[current] >= heap[parent]) {
                break;
            }

            // 부모 노드가 현재 값보다 크면 swap
            swap(parent, current);
            current = parent;
        }
    }

    // 배열에서 가장 작은 값을 출력하고 그 값을 배열에서 제거한다.
    public int pop() {
        if (size == 0) {
            return 0;
        }

        // 루트노드 출력 => 루트가 가장 작은 값이 되어야 함
        int res = heap[1];
        heap[1] = heap[size--];
        int current = 1;

        while (current * 2 <= size) {
            int left = current * 2;
            int right = left + 1;

            int child = left;
            if (right <= size && heap[left] > heap[right]) {
                child = right;
            }

            // 현재값이 자식 값 보다 작거나 같다면 break
            if (heap[current] <= heap[child]) {
                break;
            }

            swap(current, child);
            current = child;
        }

        return res;
    }

    // a위치와 b위치 swap
    private void swap (int a, int b) {
        int tmp = heap[a];
        heap[a] = heap[b];
        heap[b] = tmp;
    }
}
