for testCaseCount in range(1, 11):
    length, encryption = input().split()
    password = []

    for char in encryption:
        if password and char == password[-1]:
            password.pop()
        else:
            password.append(char)

    print(f"#{testCaseCount}", "".join(map(str, password)))