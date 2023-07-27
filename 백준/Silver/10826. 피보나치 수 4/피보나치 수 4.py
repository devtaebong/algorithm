import sys
sys.setrecursionlimit(10**6)

N = int(input())

memo = [0] * (N+1)

def fibonacci(n):
    if memo[n] != 0:
        return memo[n]

    if n <= 1:
        memo[n] = n
        return n

    memo[n] = fibonacci(n-1) + fibonacci(n-2)
    return memo[n]

result = fibonacci(N)
print(result)