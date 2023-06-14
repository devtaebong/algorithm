
# 입력
n, m = map(int, input().split(" "))
matrix = []
temp = [[0]*m for _ in range(n)]


for _ in range(n):
    matrix.append(list(map(int, input().split(" "))))

result = -1

def build_walls(count):
    global result

    if count == 3:
        copy_matrix()

        check_virus()
        result = max(result, get_safety_area())
        return

    for i in range(n):
        for j in range(m):
            if matrix[i][j] == 0:
                matrix[i][j] = 1
                build_walls(count + 1)
                matrix[i][j] = 0


def copy_matrix():
    for i in range(n):
        for j in range(m):
            temp[i][j] = matrix[i][j]


def check_virus():
    for i in range(n):
        for j in range(m):
            if temp[i][j] == 2:
                spread_virus(i, j)


def spread_virus(row, col):
    d_row = [-1, 1, 0, 0]
    d_col = [0, 0, -1, 1]

    for i in range(4):
        new_row = row + d_row[i]
        new_col = col + d_col[i]

        if 0 <= new_row < n and 0 <= new_col < m:
            if temp[new_row][new_col] == 0:
                temp[new_row][new_col] = 2
                spread_virus(new_row, new_col)

                
def get_safety_area():
    res = 0

    for i in range(n):
        for j in range(m):
            if temp[i][j] == 0:
                res += 1
    return res

# 실행
build_walls(0)
print(result)