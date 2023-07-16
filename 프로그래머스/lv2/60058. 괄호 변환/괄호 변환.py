def solution(p):
    answer = ''
    
    # 입력이 빈 문자열인 경우, 빈 문자열을 반환
    if len(p) == 0:
        return ''
    
    if is_right_string(p):
        return p
    
    index = get_index(p)
    u = p[:index + 1]
    v = p[index + 1:]

    if is_right_string(u):
        answer = u + solution(v)
    else:
        answer = "("
        answer += solution(v)
        answer += ")"
        
        u = list(u[1:-1])
        for i in range(len(u)):
            if u[i] == "(":
                u[i] = ")"
            elif u[i] == ")":
                u[i] = "("
        answer += "".join(u)
    
    return answer

# "올바른 괄호 문자열"인지 확인
# (()())()
def is_right_string(p):
    count = 0
    for i in p:
        if i == "(":
            count += 1
        else:
            if count == 0:
                return False
            count -= 1
    return True


# "균현잡힌 괄호 문자열"의 인덱스를 구한다
def get_index(p):
    count = 0 # 왼쪽괄호
    for i in range(len(p)):
        if p[i] == "(":
            count += 1
        else:
            count -= 1
        if count == 0:
            return i






