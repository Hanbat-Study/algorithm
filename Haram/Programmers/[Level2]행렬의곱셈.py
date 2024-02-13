def solution(arr1, arr2):
    M = len(arr1)
    K = len(arr1[0])
    N = len(arr2[0])
    
    answer = [[0 for _ in range(N)] for _ in range(M)]
    
    for i in range(M):
        for j in range(N):
            for k in range(K):
                answer[i][j] = answer[i][j] + arr1[i][k] * arr2[k][j];
    
    return answer