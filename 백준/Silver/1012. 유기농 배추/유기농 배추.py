import sys
sys.setrecursionlimit(10**6)

"""
0. 입력
- 가로길이: M, 세로길이: N, 위치개수: K
    - k => (x,y)
    
1. 아이디어
- 2중 for
    - matrix[i][j] == 1 and 방문 x => dfs

2. 시간복잡도
- 입력 => O(N * M)
- DFS => O(N^2)
- O(N^2 + N^2) => O(2N^2) == O(N^2)

3. 자료구조
int[][] -> 입력
bool[][] -> 체크
"""
input = sys.stdin.readline

def dfs(x, y):
    dx = [0, -1, 0, 1]
    dy = [-1, 0, 1, 0]
    for k in range(4):
        nx = x + dx[k]
        ny = y + dy[k]
        if 0 <= nx < N and 0 <= ny < M:
            if matrix[nx][ny] == 1 and chk[nx][ny] == False:
                chk[nx][ny] = True
                dfs(nx, ny)

t = int(input())
for _ in range(t):
    # 입력
    M, N, K = map(int, input().split())
    matrix = [[0] * M for _ in range(N)]
    for _ in range(K):
        a, b = map(int, input().split())
        matrix[b][a] = 1

    # 로직
    """
    M: 가로
    N: 세로
    """
    result = 0
    chk = [[False] * M for _ in range(N)]

    for i in range(N):
        for j in range(M):
            if matrix[i][j] == 1 and chk[i][j] == False:
                chk[i][j] = True
                result += 1
                dfs(i, j)
    print(result)