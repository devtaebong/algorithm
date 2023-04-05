import sys
sys.stdin=open("../input.txt", "rt")

n, m = map(int, sys.stdin.readline().split())
matrix = [list(map(int, sys.stdin.readline().rstrip())) for _ in range(n)]

# n, m = map(int, input().split(" "))
# matrix = [list(map(int, input())) for _ in range(n)]

"""
graph = []
for i in range(n):
    graph.append(list(map(int, input()))
"""


def dfs(rows, cols):
    if rows <= -1 or rows >= n or cols <= 1 or cols >= m:
        return False

    if matrix[rows][cols] == 0:
        matrix[rows][cols] = 1
        dfs(rows - 1, cols)  # 상
        dfs(rows + 1, cols)  # 하
        dfs(rows, cols - 1)  # 좌
        dfs(rows, cols + 1)  # 우
        return True

    return False


answer = 0
for i in range(n):
    for j in range(m):
        if dfs(i, j) == True:
            answer += 1

print(answer)
