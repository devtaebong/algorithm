k, n = map(int, input().split())
arr = [int(input()) for _ in range(k)]

def solve():
    result = 0

    arr.sort()
    l = 1
    r = arr[k - 1]

    while l <= r:
        mid = (l + r) // 2
        cut_size = cut_len_size(arr, mid)

        if cut_size < n:
            r = mid - 1
        else:
            l = mid + 1
            result = max(result, mid)

    return result

def cut_len_size(lens, mid):
    sum_of_len = 0
    for x in lens:
        sum_of_len += (x // mid)
    return sum_of_len

if __name__ == "__main__":
    print(solve())