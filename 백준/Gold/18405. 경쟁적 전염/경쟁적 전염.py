import sys
from collections import deque

n, k = map(int, input().split())

matrix = []
data = []

for i in range(n):
    matrix.append(list(map(int, input().split())))
    for j in range(n):
        if matrix[i][j] != 0:
            data.append((matrix[i][j], 0, i, j))

s, x, y = map(int, input().split())

# for i in range(n):
#     for j in range(n):
#         if matrix[i][j] != 0:
#             data.append((matrix[i][j], 0, i, j)) # 바이러스, 시간, x좌표, y좌표

data.sort()
q = deque(data)

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

while q:
    virus, now_sec, now_x, now_y = q.popleft()
    if now_sec == s:
        break

    for i in range(4):
        nx = now_x+dx[i]
        ny = now_y+dy[i]

        if (0 <= nx < n) and (0 <= ny < n):
            if matrix[nx][ny] == 0:
                matrix[nx][ny] = virus
                q.append((virus, now_sec+1, nx, ny))

print(matrix[x-1][y-1])
