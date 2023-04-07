import sys
from collections import deque

# 도시의 개수, 도로의 개수, 거리 정보, 출발 도시 번호
n, m, k, x = map(int, input().split())
graph = [[] for _ in range(n+1)]

# 도로 입력받기
for _ in range(m):
    a, b = map(int, sys.stdin.readline().split(" "))
    graph[a].append(b)

# 모든 도시의 최단거리 초기화
distance = [-1] * (n+1)
distance[x] = 0 # 출발도시는 0으로 설정

q = deque([x])
while q:
    now = q.popleft()
    # 현재 도시에서 이동할 수 있는 도시 확인
    for next_node in graph[now]:
        # 아직 방문하지 않은 도시일경우
        if distance[next_node] == -1:
            distance[next_node] = distance[now]+1
            q.append(next_node)

check = False
for i in range(1, n+1):
    if distance[i] == k:
        print(i)
        check = True

if not check:
    print(-1)