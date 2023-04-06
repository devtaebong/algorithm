import sys
from collections import deque

n,m = map(int, input().split(" "))
matrix = [list(map(int, sys.stdin.readline().rstrip())) for i in range(n)]
visited = [[False] * m for _ in range(n)]

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def BFS(x, y):
    queue = deque()
    queue.append((x, y))

    # 큐가 빌 때까지 반복한다.
    while queue:
        x, y = queue.popleft()

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            # 범위 밖일 경우 종료
            if nx < 0 or nx >= n or ny < 0 or ny >= m:
                continue

            # 0일 경우 종료
            if matrix[nx][ny] == 0:
                continue

            # 방문하지 않은 노드만 탐색
            if not visited[nx][ny]:
                visited[nx][ny] = True
                matrix[nx][ny] += matrix[x][y]
                queue.append((nx, ny))

        if x == n-1 and y == m-1:
            return matrix[x][y]

answer = BFS(0,0)
print(answer)