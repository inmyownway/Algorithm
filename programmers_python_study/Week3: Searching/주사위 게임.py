def solution(monster, S1, S2, S3):
    first_dice = [i for i in range(1, S1 + 1)]
    second_dice = [i for i in range(1, S2 + 1)]
    third_dice = [i for i in range(1, S3 + 1)]

    meet_monster = 0
    for i in first_dice:
        for j in second_dice:
            for w in third_dice:
                if 1 + i + j + w in monster:
                    meet_monster += 1

    all = len(first_dice) * len(second_dice) * len(third_dice)
    # 모든 주사위 횟수

    answer = int((1 - (meet_monster / all)) * 1000)
    # 몬스터를 만나지 않을 확률 =  1-(몬스터를 만날확률/모든주사위횟수)
    return answer