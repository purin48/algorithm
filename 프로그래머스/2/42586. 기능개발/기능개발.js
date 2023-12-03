function solution(progresses, speeds) {
    let deployArr = [0];
    const dayCntArr = [];
    let bigNum = 0;
    
    // 1. 작업 개수별 걸리는 시간 count
    progresses.forEach((item, idx) => {
        let dayCnt = 0;
        while(item<100) {
            dayCnt++;
            item += speeds[idx];
        }
        dayCntArr.push(dayCnt);
    })
    
    // 2. 걸리는 일수를 비교
    let wow = 0;
    for(let i=0; i<dayCntArr.length; i++){
        // 2-1. 배열의 첫번째 요소는 무조건 bigNum
        if(i === 0) bigNum = dayCntArr[i];
        
        // 2-2. bigNum보다 작거나 같다면,
        // 기존 deployArr 배열의 마지막 index 값에 +1
        if(bigNum > dayCntArr[i] || bigNum === dayCntArr[i]) {
            let deployCnt = deployArr.at(-1) + 1;
            deployArr[deployArr.length - 1] = deployCnt;
        }
        
        // 2-3. bigNum보다 크면, 
        // 기존 bigNum 값을 현재 값으로 대체 & deployArr에 추가로 1 삽입
        if(bigNum < dayCntArr[i]) {
            bigNum = dayCntArr[i];
            deployArr.push(1);
        }
    }
    
    return deployArr;
}