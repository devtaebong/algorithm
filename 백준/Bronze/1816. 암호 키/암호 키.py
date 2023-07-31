n = int(input())

for _ in range(n):
    number = int(input())

    for i in range(2, (10**6)+1):
        if number % i == 0:
            print("NO")
            break
        if i == 1000000:
            print("YES")
