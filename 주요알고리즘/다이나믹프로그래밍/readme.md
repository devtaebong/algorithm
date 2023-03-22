# 다이나믹 프로그래밍(Dynamic Programming)
다이나믹 프로그래밍은 주어진 문제를 작은 문제로 쪼개어 각 문제의 답을 계산하고,
이를 이용하여 큰 문제의 답을 구하는 알고리즘 설계 기법이다.

DP는 일반적으로 최적화 문제를 해결하는데 사용한다. 예를 들어 특정 값이나 조건에 따라
최소 또는 최대 값을 찾는 것과 같은 문제를 해결할 때 사용한다.
<br>
DP는 이러한 문제를 해결하는 데 효율적이며 중복되는 계산을 피할 수 # 다이나믹 프로그래밍(Dynamic Programming)
다이나믹 프로그래밍은 주어진 문제를 작은 문제로 쪼개어 각 문제의 답을 계산하고,
이를 이용하여 큰 문제의 답을 구하는 알고리즘 설계 기법이다.

DP는 일반적으로 최적화 문제를 해결하는데 사용한다. 예를 들어 특정 값이나 조건에 따라
최소 또는 최대 값을 찾는 것과 같은 문제를 해결할 때 사용한다.
<br>
DP는 이러한 문제를 해결하는 데 효율적이며 중복되는 계산을 피할 수 있도록 결과를 저장하여 계산속도를 높일 수 있다.

DP는 일반적으로 재귀적인 방식으로 문제를 해결하며, 메모이제이션(Memoization)이라는 기법을 사용하여 중복계산을 피한다.
이러한 방식으로 문제를 푸는것은 재귀적인 방식으로 푸는것 보다 메모리와 실행 시간을 크게 절약할 수 있다.
<br><br>


## 다이나믹 프로그래밍 문제를 풀기위해 만족해야 하는 두가지 조건
### 1. Overlapping Subproblem
#### 반복되는 부분이용하여 문제를 해결할 수 있다.
DP에서 Overlapping Subproblem이란 큰 문제를 해결할 때 작은 문제들이 중복되어 반복적으로 해결되는 현상을 의미한다.
이러한 중복 문제는 DP에서 계산 속도를 늦추는 주요 원인 중 하나이다.

예를들어, 피보나치 수열을 구하는 문제를 생각해보면 피보나치 수열의 n번째 항을 구하는 문제는
n-1번째 항과 n-2번째 항을 구하는 문제를 포함한다. 
이러한 소문제 계산 과정에서 반복적으로 사용되며 DP를 이용하여 효율적으로 문제를 해결할 수 있다.

DP에서 Overlapping Subproblem이 발생하는 경우, 이전에 해결한 작은 문제의 결과를 저장하고 재활용함으로써 계산 속도를 높일 수 있다.
이러한 결과를 저장하기 위해 메모이제이션(Memoization)이라는 기법을 사용한다.


### 2. Optimal Substructure
#### 문제의 정답을 작은 문제의 정답을 구할수 있다.
DP에서 Optimal Substructure는 큰 문제의 최적해(optimal solution)가 작은 문제의 최적해로부터 구해질 수 있는 성질을 의미한다.
즉, 큰 문제를 이용하여 작은 문제의 최적해를 구할 수 있다는 것을 의미한다.

예를들어 최단경로 문제에서 시작점에서 도착점으로 가는 최단 경로를 구하는 문제를 생각해보면,
도착점에서부터 역으로 시작점까지 거꾸로 작은 문제들을 풀어나가면서,
최종적으로 시작점에서 도착점까지 최단 경로를 구할 수 있게된다.
이때, 각각의 작은 문제에서 구한 최단 경로들을 결합하여 큰 문제인 전체 최단 경로를 구할수 있다.
이러한 성질이 바로 Optimal Substructure이다.

DP에서 Optimal Substructure가 성립한다면 큰 문제를 작은 문제로 쪼개어 해결하는 Bottom-Up 방식의 DP가 가능하다.
Bottom-Up 방식의 DP는 작은 문제에서 시작하여 계속해서 큰 문제를 해결해나가는 방식으로 최종적으로 전체 문제를 해결한다.
이러한 Bottom-Up 방식은 Top-Down 방식의 메모이제이션 방식보다 효율적이며 Optimal Substructure가 성립할 때만 사용 가능하다.
<br><br>

## Memoization
1. Optimal Substructure을 만족할때, 같은 문제는 구할 때마다 정답이 같다.
   - 피보나지수에서 F₉를 구할때 찾는 F₃과 F₇을 구할때 찾는 F₃의 값은 항상 같다.
2. 따라서 정답을 한 번 구했으면 정답을 어딘가에 메모해놓는다.
   - 보통 배열에 저장한다.
3. 메모를 한다고 해서 영어로 Memoization이라고 한다.

### Memoization을 사용하지 않은 피보나치 구현 메서드
```java
public static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        } else {
            return fibonacci(n-1) + fibonacci(n-2);
        }
    }
```
위의 코드의 시간복잡도는 O(2ⁿ)이다.

이유는 fibonacci(n)을 계산하기 위해 fibonacci(n-1)과 fibonacci(n-2)를 호출하며,
이 두 메서드는 또다시 각각 fibonacci(n-2) / fibonacci(n-3), fibonacci(n-3) / fibonacci(n-4)를 호출한다.
이렇게 호출되는 메서드의 수는 피보나치 수열의 형태를 따른다. 따라서 호출되는 메서드는 2의 n제곱과 비례하며,
각 함수 호출 시간은 상수이므로 전체 실행 시간은 O(2ⁿ)이다.

이와같이 재귀 함수를 사용하는 경우 동일한 입력 값으로 함수가 반복호출 되는 경우가 많아서 계산이 매우 느려진다.
이러한 경우 다이나믹 프로그래밍 기법을 이용하여 중복 계산을 피하고 실행 속도를 향상시킬 수 있다.

### Memoization을 사용한 피보나치 구현 메서드
위의 코드를 다이나믹 프로그래밍 기법을 이용하여 최적화하면 중복되는 계산을 피할수 있다.
이를 위해 Memoization 기법을 사용한다.
```java
public static int fibonacci(int n) {
    int[] memo = new int[n + 1];
    return fibonacciMemo(n, memo);
}

public static int fibonacciMemo(int n, int[] memo) {
    if (n <= 1) {
        return n;
    } else if (memo[n] != 0) {
        return memo[n];
    } else {
        memo[n] = fibonacciMemo(n-1, memo) + fibonacciMemo(n-2, memo);
        return memo[n];
    }
}
```
위 코드에서 fibonacciMemo() 메서드를 이용하여 이미 계산된 값이 있는 경우 그 값을 반환하고,
그렇지 않은 경우 계산 후 결과를 메모이제이션(저장)한다. 이렇게 하면 중복 계산을 피할 수 있기 때문에 실행시간을 크게 줄일 수 있다.

위 코드의 시간복잡도는 O(n)으로 훨씬 효율적이다. 이유는 fibonacciMemo() 메서드는 한 번 호출 되면
memo 배열에 결과를 저장하기 때문에 같은 입력값으로 또 다시 호출되지 않는다. <br>
따라서 각 입력값에 대해 한 번만 계산하게 되는 것이다. 결과를 저장하여 계산속도를 높일 수 있다.

DP는 일반적으로 재귀적인 방식으로 문제를 해결하며, 메모이제이션(Memoization)이라는 기법을 사용하여 중복계산을 피한다.
이러한 방식으로 문제를 푸는것은 재귀적인 방식으로 푸는것 보다 메모리와 실행 시간을 크게 절약할 수 있다.
<br><br>


## 다이나믹 프로그래밍 문제를 풀기위해 만족해야 하는 두가지 조건
### 1. Overlapping Subproblem
#### 반복되는 부분이용하여 문제를 해결할 수 있다.
DP에서 Overlapping Subproblem이란 큰 문제를 해결할 때 작은 문제들이 중복되어 반복적으로 해결되는 현상을 의미한다.
이러한 중복 문제는 DP에서 계산 속도를 늦추는 주요 원인 중 하나이다.

예를들어, 피보나치 수열을 구하는 문제를 생각해보면 피보나치 수열의 n번째 항을 구하는 문제는
n-1번째 항과 n-2번째 항을 구하는 문제를 포함한다. 
이러한 소문제 계산 과정에서 반복적으로 사용되며 DP를 이용하여 효율적으로 문제를 해결할 수 있다.

DP에서 Overlapping Subproblem이 발생하는 경우, 이전에 해결한 작은 문제의 결과를 저장하고 재활용함으로써 계산 속도를 높일 수 있다.
이러한 결과를 저장하기 위해 메모이제이션(Memoization)이라는 기법을 사용한다.


### 2. Optimal Substructure
#### 문제의 정답을 작은 문제의 정답을 구할수 있다.
DP에서 Optimal Substructure는 큰 문제의 최적해(optimal solution)가 작은 문제의 최적해로부터 구해질 수 있는 성질을 의미한다.
즉, 큰 문제를 이용하여 작은 문제의 최적해를 구할 수 있다는 것을 의미한다.

예를들어 최단경로 문제에서 시작점에서 도착점으로 가는 최단 경로를 구하는 문제를 생각해보면,
도착점에서부터 역으로 시작점까지 거꾸로 작은 문제들을 풀어나가면서,
최종적으로 시작점에서 도착점까지 최단 경로를 구할 수 있게된다.
이때, 각각의 작은 문제에서 구한 최단 경로들을 결합하여 큰 문제인 전체 최단 경로를 구할수 있다.
이러한 성질이 바로 Optimal Substructure이다.

DP에서 Optimal Substructure가 성립한다면 큰 문제를 작은 문제로 쪼개어 해결하는 Bottom-Up 방식의 DP가 가능하다.
Bottom-Up 방식의 DP는 작은 문제에서 시작하여 계속해서 큰 문제를 해결해나가는 방식으로 최종적으로 전체 문제를 해결한다.
이러한 Bottom-Up 방식은 Top-Down 방식의 메모이제이션 방식보다 효율적이며 Optimal Substructure가 성립할 때만 사용 가능하다.
<br><br>

## Memoization
1. Optimal Substructure을 만족할때, 같은 문제는 구할 때마다 정답이 같다.
   - 피보나지수에서 F₉를 구할때 찾는 F₃과 F₇을 구할때 찾는 F₃의 값은 항상 같다.
2. 따라서 정답을 한 번 구했으면 정답을 어딘가에 메모해놓는다.
   - 보통 배열에 저장한다.
3. 메모를 한다고 해서 영어로 Memoization이라고 한다.

### Memoization을 사용하지 않은 피보나치 구현 메서드
```java
public static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        } else {
            return fibonacci(n-1) + fibonacci(n-2);
        }
    }
```
위의 코드의 시간복잡도는 O(2ⁿ)이다.

이유는 fibonacci(n)을 계산하기 위해 fibonacci(n-1)과 fibonacci(n-2)를 호출하며,
이 두 메서드는 또다시 각각 fibonacci(n-2) / fibonacci(n-3), fibonacci(n-3) / fibonacci(n-4)를 호출한다.
이렇게 호출되는 메서드의 수는 피보나치 수열의 형태를 따른다. 따라서 호출되는 메서드는 2의 n제곱과 비례하며,
각 함수 호출 시간은 상수이므로 전체 실행 시간은 O(2ⁿ)이다.

이와같이 재귀 함수를 사용하는 경우 동일한 입력 값으로 함수가 반복호출 되는 경우가 많아서 계산이 매우 느려진다.
이러한 경우 다이나믹 프로그래밍 기법을 이용하여 중복 계산을 피하고 실행 속도를 향상시킬 수 있다.
<br>

### Memoization을 사용하지 않은 피보나치 구현 메서드
위의 코드를 다이나믹 프로그래밍 기법을 이용하여 최적화하면 중복되는 계산을 피할수 있다.
이를 위해 Memoization 기법을 사용한다.
```java
public static int fibonacci(int n) {
    int[] memo = new int[n + 1];
    return fibonacciMemo(n, memo);
}

public static int fibonacciMemo(int n, int[] memo) {
    if (n <= 1) {
        return n;
    } else if (memo[n] != 0) {
        return memo[n];
    } else {
        memo[n] = fibonacciMemo(n-1, memo) + fibonacciMemo(n-2, memo);
        return memo[n];
    }
}
```
위 코드에서 fibonacciMemo() 메서드를 이용하여 이미 계산된 값이 있는 경우 그 값을 반환하고,
그렇지 않은 경우 계산 후 결과를 메모이제이션(저장)한다. 이렇게 하면 중복 계산을 피할 수 있기 때문에 실행시간을 크게 줄일 수 있다.

위 코드의 시간복잡도는 O(n)으로 훨씬 효율적이다. 이유는 fibonacciMemo() 메서드는 한 번 호출 되면
memo 배열에 결과를 저장하기 때문에 같은 입력값으로 또 다시 호출되지 않는다. <br>
따라서 각 입력값에 대해 한 번만 계산하게 되는 것이다.
<br>
