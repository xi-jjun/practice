N = int(input())
data = list()
[ data.append(int(input())) for i in range(N) ]
data.sort()
[print(d) for d in data]
