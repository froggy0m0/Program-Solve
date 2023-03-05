import sys

T = int(sys.stdin.readline())
testCaseList = [int(sys.stdin.readline()) for _ in range(T)]
maxTestCaseValue = max(testCaseList)
dp = [-1 for _ in range(maxTestCaseValue+1)]
dp[1] = 1
dp[2] = 2
dp[3] = 4

for i in range(4, maxTestCaseValue+1):
    dp[i] = dp[i-1] + dp[i-2] + dp[i-3]
for TestCaseValue in testCaseList:
    print(dp[TestCaseValue])