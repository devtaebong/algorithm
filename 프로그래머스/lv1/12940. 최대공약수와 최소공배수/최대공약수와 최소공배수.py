def solution(n, m):
    answer = []
    x = gcd(n, m)
    y = lcm(n, m)
    
    answer.append(x)
    answer.append(y)
    return answer

def gcd(a, b):
    if b == 0:
        return a
    else:
        return gcd(b, a % b)
    
def lcm(a, b):
    n = gcd(a, b)
    return a*b // n