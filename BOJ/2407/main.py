"""
내장 함수
import math
res2 = math.comb(n,m)
"""
import sys

n,m = map(int, sys.stdin.readline().split())
dp=[i for i in range(101)]

for i in range(2, n+1):
    dp[i] = dp[i] * dp[i-1]

res = dp[n] // (dp[n-m]  * dp[m])
print(res)