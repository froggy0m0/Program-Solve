from collections import deque

for testCaseCount in range(1, 11):
    result = 1
    _ = input()
    inp = deque(map(str, input()))
    queue = deque()
    while(inp):
        tmp = inp.popleft()
        if tmp in ['(', '{', '[', '<']:
            queue.append(tmp)
        elif tmp in [')', '}', ']', '>']:
            popItem = queue.pop()
            if popItem == '(' and tmp == ')' or popItem == '{' and tmp == '}' or popItem == '[' and tmp == ']' or popItem == '<' and tmp == '>':
                continue
            else :
                result = 0
                break

    if (queue) :
        result = 0

    print(f"#{testCaseCount}", result)