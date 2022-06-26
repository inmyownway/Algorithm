def solution(dirs):

    x,y = 0,0
    check = dict()

    for command in dirs:
        if command == 'U' and y < 5:
            check[(x,y,x,y+1)] = True
            y += 1
        elif command == 'D' and y > -5:
            check[(x, y-1, x, y)] = True
            y -= 1
        elif command == 'L' and x > -5:
            check[(x-1, y, x, y)] = True
            x -= 1
        elif command == 'R' and x < 5:
            check[(x, y, x+1, y)] = True
            x += 1
    print(check)
    return len(check)

s="UDU"
print(solution(s))