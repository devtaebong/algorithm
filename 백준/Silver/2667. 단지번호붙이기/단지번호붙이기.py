"""
1. 아이디어
- 2중 for -> 1 and 방문 X, DFS
- DFS 결과로 단지 내 집 수를 구하고 리스트에 넣는다.
- 리스트 len 출력, 리스트 오름차순 후 출력

2. 시간복잡도
- O(N^2)

3. 자료구조
- int[][] -> map
- bool[][] -> 방문여부
- int[] -> 결과값 저장

"""

import sys
input = sys.stdin.readline

N = int(input())
map = [list(map(int, input().strip())) for _ in range(N)]
chk = [[False] * N for _ in range(N)]

dx = [0, -1, 0, 1]
dy = [1, 0, -1, 0]
result = []

def dfs(x, y):
    global house
    house += 1
    for k in range(4):
        nx = x + dx[k]
        ny = y + dy[k]
        if 0<=nx<N and 0<=ny<N:
            if map[nx][ny] == 1 and chk[nx][ny] == False:
                chk[nx][ny] = True
                dfs(nx, ny)

for i in range(N):
    for j in range(N):
        if map[i][j] == 1 and chk[i][j] == False:
            # 방문 체크
            # DFS
            house = 0
            chk[i][j] = True
            dfs(i, j)
            result.append(house)

print(len(result))
result.sort()
for x in result:
    print(x)