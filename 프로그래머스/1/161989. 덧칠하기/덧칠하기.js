function solution(n, m, section) {
    let answer = 0;
    let wall = [];
    
    // 1. 1 ~ n이 들어있는 배열 생성
    for(let i=1; i<=n; i++) {
        wall.push(i);
    }
    
    // 2. wall의 배열에 section의 요소가 있다면
    //    wall배열에서 (section + m) 범위를 제거, answer 카운트
    section.forEach((item) => {
        if(wall.includes(item)) {
            let idx = wall.indexOf(item);
            wall.splice(idx,m);
            answer += 1;
        }
    })
    return answer;
}