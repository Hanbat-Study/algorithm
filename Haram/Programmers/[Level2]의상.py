def solution(clothes):
    answer = 1
    clothes_dict = {}
    
    for cloth in clothes:
        key = cloth[1]
        if key in clothes_dict:
            clothes_dict[key] += 1
        else:
            clothes_dict[key] = 1
    
    for key in clothes_dict:
        answer = answer * (clothes_dict[key] + 1)
        
    return answer - 1