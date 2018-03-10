from __future__ import print_function
if __name__ == '__main__':
    n = int(raw_input())

    m = 10
    t = 0

    for i in range(n):
        t *= m
        t += (i + 1)

    print(t)
