function solution(answers) {
    let answer = [];
    
    const supoja = [[1,2,3,4,5], [2,1,2,3,2,4,2,5], [3,3,1,1,2,2,4,4,5,5]];
    const cnt = [0,0,0];
    
    // 수포자 수 만큼 반복
    supoja.forEach((item, itemIdx) => {
        // 정답이 맞는 지 여부 확인 반복
        answers.forEach((ans, ansIdx) => {
            // answers 배열과 수포자 정답 길이 맞추기
            if(ans === item[ansIdx % item.length]) {
                console.log(ans);
                cnt[itemIdx] += 1;
            }
        })
    })
    
    console.log("---")
    let max = Math.max(...cnt);
    console.log(cnt);
    console.log(max);
    
    if(cnt[0] === max) {
        answer.push(1);
    }
    if(cnt[1] === max) {
        answer.push(2);
    }
    if(cnt[2] === max) {
        answer.push(3);
    }
    
    console.log(answer);
    return answer;
}