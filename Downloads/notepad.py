import itertools

# 각 MBTI 유형의 조합에 대한 가중치를 부여한 딕셔너리
MBTI_TABLE = {
    "ISTJ": {
        "ISTJ": 5,
        "ISFJ": 5,
        "INFJ": 3,
        "INTJ": 3,
        "ISTP": 1,
        "ISFP": 1,
        "INFP": 1,
        "INTP": 1,
        "ESTP": 0,
        "ESFP": 0,
        "ENFP": 0,
        "ENTP": 0,
        "ESTJ": 1,
        "ESFJ": 1,
        "ENFJ": 0,
        "ENTJ": 0,
    },
    "ISFJ": {
        "ISTJ": 5,
        "ISFJ": 5,
        "INFJ": 3,
        "INTJ": 3,
        "ISTP": 1,
        "ISFP": 1,
        "INFP": 1,
        "INTP": 1,
        "ESTP": 0,
        "ESFP": 0,
        "ENFP": 0,
        "ENTP": 0,
        "ESTJ": 1,
        "ESFJ": 1,
        "ENFJ": 0,
        "ENTJ": 0,
    },
    "INFJ": {
        "ISTJ": 3,
        "ISFJ": 3,
        "INFJ": 5,
        "INTJ": 5,
        "ISTP": 3,
        "ISFP": 3,
        "INFP": 5,
        "INTP": 5,
        "ESTP": 1,
        "ESFP": 1,
        "ENFP": 5,
        "ENTP": 5,
        "ESTJ": 1,
        "ESFJ": 5,
        "ENFJ": 5,
        "ENTJ": 5,
    },
    "INTJ": {
        "ISTJ": 3,
        "ISFJ": 3,
        "INFJ": 5,
        "INTJ": 5,
        "ISTP": 3,
        "ISFP": 3,
        "INFP": 5,
        "INTP": 5,
        "ESTP": 1,
        "ESFP": 1,
        "ENFP": 5,
        "ENTP": 5,
        "ESTJ": 1,
        "ESFJ": 5,
        "ENFJ": 5,
        "ENTJ": 5,
    },
    "ISTP": {
        "ISTJ": 1,
        "ISFJ": 1,
        "INFJ": 3,
        "INTJ": 3,
        "ISTP": 5,
        "ISFP": 5,
        "INFP": 3,
        "INTP": 3,
        "ESTP": 5,
        "ESFP": 5,
        "ENFP": 1,
        "ENTP": 1,
        "ESTJ": 0,
        "ESFJ": 0,
        "ENFJ": 1,
        "ENTJ": 1,
        },
    "ENFJ": {
        "ISTJ": 0,
        "ISFJ": 0,
        "INFJ": 5,
        "INTJ": 5,
        "ISTP": 1,
        "ISFP": 1,
        "INFP": 5,
        "INTP": 5,
        "ESTP": 0,
        "ESFP": 0,
        "ENFP": 5,
        "ENTP": 5,
        "ESTJ": 0,
        "ESFJ": 5,
        "ENFJ": 5,
        "ENTJ": 5,
    },
    "ENTJ": {
        "ISTJ": 0,
        "ISFJ": 0,
        "INFJ": 5,
        "INTJ": 5,
        "ISTP": 1,
        "ISFP": 1,
        "INFP": 5,
        "INTP": 5,
        "ESTP": 0,
        "ESFP": 0,
        "ENFP": 5,
        "ENTP": 5,
        "ESTJ": 0,
        "ESFJ": 5,
        "ENFJ": 5,
        "ENTJ": 5,
    },
}
#모든 가능한 참가자 조합을 반환하는 함수
def get_combinations(participants):
    return list(itertools.combinations(participants, 4)) + list(itertools.combinations(participants, 6))

def get_combination_score(combination):
    score = 0
    for i in range(len(combination)):
        for j in range(i+1, len(combination)):
            score += MBTI_TABLE[combination[i]][combination[j]]
    return score


def get_best_combination(participants):
    mbti_combinations = list(itertools.combinations(participants, 2))
    combination_scores = [MBTI_COMBINATIONS[combo] for combo in mbti_combinations]
    best_combinations = []
    best_score = max(combination_scores)
    for i, score in enumerate(combination_scores):
        if score == best_score:
            best_combinations.append(mbti_combinations[i])
    selected_combination = random.choice(best_combinations)
    participants_left = [p for p in participants if p not in selected_combination]
    if len(participants_left) == 4:
        # 4인 자리 배치
        seats = ["A", "B", "C", "D"]
    else:
        # 6인 자리 배치
        seats = ["A", "B", "C", "D", "E", "F"]
    random.shuffle(seats)
    result = list(selected_combination)
    for i, participant in enumerate(participants_left):
        result.insert(i+2, participant)
    return result


def assign_seats(participants):
    if len(participants) == 4:
        # 4인 자리 배치
        seats = ["A", "B", "C", "D"]
        random.shuffle(seats)
        for i, participant in enumerate(participants):
            print(f"Seat {seats[i]}: {participant}")
        print()
    else:
        # 6인 자리 배치
        seats = ["A", "B", "C", "D", "E", "F"]
        random.shuffle(seats)
        for i, participant in enumerate(participants):
            print(f"Seat {seats[i]}: {participant}")
            if (i+1) % 3 == 0:
                print()  # 다음 줄로 넘어감

#참여자의 MBTI 유형을 입력받음
participants = input("참여자들의 MBTI 유형을 입력하세요 (각 유형은 띄어쓰기로 구분): ").split()

#참가자 수와 자리 크기에 따라 자리 배치
if len(participants) < 4:
    print("참가자 수가 너무 적습니다.")
elif len(participants) == 4 or len(participants) == 6:
    assign_seats(participants)
else:
    print("참가자 수가 너무 많습니다.")
    best_combination = get_best_combination(participants)
for i, participant in enumerate(best_combination):
    print(f"Seat {i+1}: {participant}")
    if (i+1) % 6 == 0:
        print() # 다음 줄로 넘어감
