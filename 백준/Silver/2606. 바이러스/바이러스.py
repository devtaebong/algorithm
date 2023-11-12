import sys

input = sys.stdin.readline

n = int(input())
m = int(input())

matrix = list([0] * (n+1) for _ in range(n+1))
check = [False] * (n+1)

result = 0

def dfs(x):
    global result

    check[x] = True
    for i in range(n+1):
        if matrix[x][i] == 1 and check[i] == False:
            matrix[x][i] = 0
            result += 1
            dfs(i)

for _ in range(m):
    a, b = map(int, input().split())
    matrix[a][b] = 1
    matrix[b][a] = 1

dfs(1)

print(result)
