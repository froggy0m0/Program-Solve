import sys

T = int(sys.stdin.readline())
testCaseList = [int(sys.stdin.readline()) for _ in range(T)]
dp = [0 for _ in range(max(testCaseList)+3)]
dp[1]=dp[2]=dp[3] = 1

for n in testCaseList:
    for i in range(3 ,max(testCaseList)+3):
        dp[i] = dp[i-2] + dp[i-3]
print("\n".join(str(dp[n]) for n in testCaseList))