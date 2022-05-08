# 프로그래머스 레벨1 - 소수 만들기
from itertools import combinations

def solution(nums):
    prime = list(combinations(nums, 3))
    notprime = 0

    for x in range(len(prime)):
        y = sum(prime[x])

        for z in range(2, y):
            if y % z == 0:
                notprime += 1
                break

    result = len(prime) - notprime
    return result

nums = [1,2,7,6,4]
print(solution(nums))
