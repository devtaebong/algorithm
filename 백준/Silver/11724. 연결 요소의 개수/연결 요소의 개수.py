"""
0. 입력
- N: 정점, M, 간선

1. 아이디어
- 인접리스트 dfs
    - 방문 노드 check
- dfs가 끊기면 +1

2. 시간복잡도
인접리스트 dfs => O(V+E)

3. 자료구조
- int[][] => 인접리스트
"""

import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**6)
N, M = map(int, input().split(" "))

graph = [[] for _ in range(N+1)]
chk = [False] * (N+1)
for _ in range(M):
    a, b = map(int, input().split(" "))
    graph[a].append(b)
    graph[b].append(a)

def dfs(x):
    for v in graph[x]:
        if chk[v] == False:
            chk[v] = True
            dfs(v)

cnt = 0
for i in range(1, N+1):
    if chk[i] == False:
        chk[i] = True
        cnt += 1
        dfs(i)

print(cnt)