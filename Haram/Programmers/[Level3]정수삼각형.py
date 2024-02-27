def solution(triangle):
    answer = 0
    n = len(triangle)
    dp = [[0 for _ in range(n)] for _ in range(n)]
    
    dp[0][0] = triangle[0][0]
    
    for i in range(n):
        for j in range(i+1):
            if i == 0 and j == 0:
                continue
            if j == 0:
                dp[i][j] = dp[i-1][j] + triangle[i][j]
            elif j == i:
                dp[i][j] = dp[i-1][j-1] + triangle[i][j]
            else:
                dp[i][j] = max(dp[i-1][j-1], dp[i-1][j]) + triangle[i][j]

    return max(dp[n-1])