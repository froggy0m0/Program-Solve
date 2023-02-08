import math, sys

M, N = map(int, sys.stdin.readline().split())

li = [i for i in range(M,N+1)]
li_idx = [-1 for i in range(int(math.sqrt(N))+1)]

def find_startingidx():
    """
    li에 'i'배수의 시작인덱스를 li_idx[i]에저장하는 함수
    idx = 0,1 에는 -1로 설정
    """
    for i in range(2, int(math.sqrt(N))+1):
        for j in range(len(li)):
            if li[j] % i == 0 and li[j] != i:
                li_idx[i] = j
                break


def is_prime():
    """
    [M, M+1, M+2 ...., N] 리스트에서
    소수를 제외한 수(복합수)를 -1로 설정하는 함수

    """
    li[0] = -1 if li[0] == 1 else li[0]

    for i in range(2,len(li_idx)):
        if li_idx[i] != -1:
            for j in range(li_idx[i], len(li), i):
                li[j] = -1


find_startingidx()
is_prime()
for i in li:
    if i != -1 : print(i)