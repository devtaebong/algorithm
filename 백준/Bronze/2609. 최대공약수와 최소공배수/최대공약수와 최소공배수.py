import sys

n, m = map(int, sys.stdin.readline().split())

def gcd_mod(a, b):
    while a != 0 and b != 0:
        if a > b:
            a = a % b
        else:
            b = b % a
    return a + b

gcd = gcd_mod(n, m)
lcm = n * m // gcd

print(gcd)
print(lcm)