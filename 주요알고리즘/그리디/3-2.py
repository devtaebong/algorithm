import sys
sys.stdin=open("input.txt", "rt")

n,m,k = map(int, input().split(" "))
data = list(map(int, input().split(" ")))

# 배열의 수를 M번 더하여 가장 큰 수를 만든다
# 특정 인덱스 번호가 K번을 초과해서 반복될 수 없다.
# 2 4 5 4 6 의 배열에 6+6+6+5+6+6+6+5
data.sort(reverse=True)

sum = 0
cnt = 0
for i in range(m):
    if cnt < 3:
        sum += data[0]
        cnt += 1
        continue
    if cnt == 3:
        sum += data[1]
        cnt = 0
        continue
print(sum)

# ==========================================
first = data[0] # 가장 큰 수
second = data[1] # 두 번째로 큰 수

# 가장 큰 수가 더해지는 횟수
count = m//(k+1) * k
count += m % (k+1)

# 결과
result = 0
result += count * first # 가장 큰 수 더하기
result += (m-count) * second # 두 번째로 큰 수 더하기
print(result)
