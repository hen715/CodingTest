n, m, k = map(int, input().split())
arr = list()
for _ in range(n):
    arr.append(list(map(int, input().split())))
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]
currentD = list(map(int, input().split()))

sharkD = list()    
for i in range(m):
    sharkD.append([])
    for j in range(4):
        sharkD[i].append(list(map(int, input().split())))
stink = [[[0, 0] for _ in range(n)] for _ in range(n)]

sharkArr = [[[] for _ in range(n)] for _ in range(n)]

live = m


def stinkDown():
    for i in range(n):
        for j in range(n):
            if stink[i][j][1] > 0:
                stink[i][j][1] -= 1
            if stink[i][j][1] == 0:
                stink[i][j][0] = 0

def getSharkPos(shark):
    for i in range(n):
        for j in range(n):
            if arr[i][j] == shark+1:
                return i, j
    return None

def mark():
    for i in range(m):
        if getSharkPos(i) == None:
            continue
        x, y = getSharkPos(i)
        stink[x][y] = [i, k]


def move():
    for i in range(m, -1, -1):
        if getSharkPos(i) == None:
            continue
        x, y = getSharkPos(i)            
        for d in sharkD[i][currentD[i]-1]:
            nx = x + dx[d - 1]
            ny = y + dy[d - 1]
            if nx in range(n) and ny in range(n) and stink[nx][ny] == [0, 0]:
                currentD[i] = d
                break
            else:
                nx, ny = -1, -1
        if nx == -1 and ny == -1:
            for d in sharkD[i][currentD[i]-1]:
                nx = x + dx[d - 1]
                ny = y + dy[d - 1]
                if nx in range(n) and ny in range(n) and stink[nx][ny][0] == i:
                    currentD[i] = d
                    break
        arr[x][y] = 0
        arr[nx][ny] = i + 1
        sharkArr[x][y] = []
        sharkArr[nx][ny].append(i)

def eliminate():
    global live
    for i in range(n):
        for j in range(n):
            sharkArr[i][j].sort()
            while len(sharkArr[i][j]) > 1:
                sharkArr[i][j].pop()
                live -= 1

time = 0
while time <= 1000:
    time += 1
    mark()
    move()
    stinkDown()
    eliminate()
    if live == 1:
        break
if time <= 1000:
    print(time)
else:
    print(-1)