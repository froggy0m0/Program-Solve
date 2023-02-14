import sys

n = int(sys.stdin.readline())
sequenceList = [int(i) for i in sys.stdin.readline().split()]
dp = [sequenceList[0]]

for i in range(1, len(sequenceList)):
    if sequenceList[i] < dp[i-1] + sequenceList[i]:
        dp.append(dp[i-1] + sequenceList[i])
    else :
        dp.append(sequenceList[i])

print(max(dp))