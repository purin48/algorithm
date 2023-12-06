function solution(cards1, cards2, goal) {

    // goal 배열 만큼 반복
    for(const word of goal) {

        // 만약 cards1, cards2 맨 앞 요소에 일치하는 단어가 있다면
        if(cards1[0] === word) {
            cards1.shift(); // 일치하는 요소 앞에서부터 제거
        } else if(cards2[0] === word) {
            cards2.shift(); // 일치하는 요소 앞에서부터 제거
        } else {
            return "No" // 일치하는 요소 없으면 "No" 리턴
        }
    }

    return "Yes";
}