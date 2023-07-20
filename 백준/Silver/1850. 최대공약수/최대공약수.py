import sys

n, m = map(int, sys.stdin.readline().split())

def gcd(a, b):
    if b == 0:
        return a
    else:
        return gcd(b, a % b)
print("1" * gcd(n, m))