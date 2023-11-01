function solution(k, score) {
    let answer = [];
    let winnerArr = [];
    
    // score 배열만큼 반복 -> 명예의 전당 배열에 점수 push -> 명예의 전당 요소 정렬
    // 명예의 전당 k번째 이후 요소 삭제 -> 명예의 전당 최하위 점수 answer에 push
    for(let i=0; i<score.length; i++) {
        winnerArr.push(score[i]);
        winnerArr.sort((a,b) => b - a);
        if(winnerArr.length > k) {
            winnerArr.pop();
        }
        answer.push(winnerArr[winnerArr.length - 1]);
    }
    return answer;
}