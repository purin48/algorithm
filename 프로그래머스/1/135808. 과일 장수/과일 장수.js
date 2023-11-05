function solution(k, m, score) {
    let appleBox = [];
    let idx = 0;
    let appleBoxPrice = 0;
    
    // sort로 가장 큰 것부터 정렬
    score.sort((a,b) => b - a);
    
    // score의 길이만큼 반복
    for(let i=0; i < score.length; i++) {
        // appleBox 중 최저 사과 점수 고르기
        appleBox = score.slice(idx, idx + m);
        const min = Math.min(...appleBox);

        if(appleBox.length === m) {
            appleBoxPrice += min * m
        }

        idx += m;
    }
    
    return appleBoxPrice;
}