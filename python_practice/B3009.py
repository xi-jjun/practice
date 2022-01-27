import sys

x = []
y = []

for i in range(3):
	tempX, tempY = map(int, sys.stdin.readline().split())
	x.append(tempX)
	y.append(tempY)
x.sort()
y.sort()
a = x[0] if x.count(x[0]) == 1 else x[2]
b = y[0] if y.count(y[0]) == 1 else y[2]

print(a, b)
