# 파일 읽기
import sys
sys.stdin=open("input.txt", "rt")

# 입력받기
n, m = map(int, input().split())

# 2차원 배열 초기화 - 리스트 컴프리헨션
matrix2 = [list(map(int, input().split())) for _ in range(m)]
