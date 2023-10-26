function solution(food) {
    let answer = [];
    let foodArr = [];
    
    // 1. food 배열은 칼로리 순서 배치 [물, 1번째, 2번째 , ... ]
    // 2. 각 배열의 item이 / 2 몫의 수만큼만 반복
    for(let i=1; i<food.length; i++){
        foodArr.push(Math.floor(food[i] / 2));
    }
    
    // 음식 순서 배열 생성
    foodArr.forEach((item, idx) => {
        for(let j=0; j<item; j++) {
            answer.push(idx + 1);
        }
    });
    
    // 원본 배열 뒤집기
    let reverseAnswer = [...answer].reverse();
    
    // 물 넣어주기
    answer.push(0);
    
    // 반대 배열 넣어주기
    answer.push(...reverseAnswer);
    
    return answer.join("").toString();
}