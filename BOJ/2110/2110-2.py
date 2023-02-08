from collections import deque
import sys

sys.setrecursionlimit(1000000)

N, C = map(int, sys.stdin.readline().split())  # N == 집의개수, C == 공유기개수
location_li = [int(sys.stdin.readline()) for _ in range(N)]
location_li.sort()


def is_available(mid):
    global C
    global location_li

    queue = deque(location_li)
    count = 1
    pre_location = queue.popleft()

    for next_location in location_li:
        if mid <= next_location - pre_location:
            count += 1
            pre_location = next_location

        if count >= C:
            return True

    return False


def bin_search(low, high, res=0):
    if low > high:
        print(res)
        return 1

    mid = (low + high) // 2

    if is_available(mid):
        bin_search(mid + 1, high, mid)
    else:
        bin_search(low, mid - 1, res)


bin_search(0, 10 ** 6)
