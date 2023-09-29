def solution(money):
    answer = [0, 0]
    
    a = money // 5500
    b = money % 5500
    
    answer[0] = a
    answer[1] = b
    
    return answer