const createObj = (num) => {
    const stageObj = {};
    
    for(let i=1; i<=num; i++){
        stageObj[i] = 0;
    }
    
    return stageObj;
}

function solution(N, stages) {
    // n번 스테이지 : n번 스테이지 잔류 인원 객체 만들기
    const stagesObj = createObj(N);
    const stageArr = Object.keys(stagesObj);
    
    // stages 배열 반복해서, 객체의 key값과 일치하는 부분에 +1
    stages.forEach((stageItem) => {
        stageArr.forEach((arrItem) => {
            if(arrItem == stageItem) {
                stagesObj[arrItem] += 1;
            }
        })
    })
    
    // 각 key값인 stage에 실패율 구해서, failRates 배열에 push
    let participant = stages.length;
    const failRates = [];
    
    for(const key in stagesObj) {
        failRates.push(stagesObj[key] / participant);
        participant -= stagesObj[key];
    }
    
    // 내림차순 정렬 후, 배열 리턴
    const answer = failRates.map((failRate,idx)=>({failRate,idx}))
                            .sort((a,b)=>b.failRate - a.failRate)
                            .map(({idx})=>idx+1)
    
    return answer;
}