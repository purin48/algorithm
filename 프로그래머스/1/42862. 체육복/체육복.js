function solution(n, lost, reserve) {
    let answer = [];
    
    // 1. 전체 학생 배열 만들기
    for(let i=1; i<=n; i++) {
        answer.push(i);
    };
    
    // 2. 전체 학생 배열 - lost 학생
    // reserve 학생이 도난당했을 수 있음
    lost.forEach((item) => {
        answer = answer.filter((answerItem) => {
            if(!reserve.includes(item)) {
                return answerItem !== item;
            }
            if(reserve.includes(item)) {
                return answerItem;
            }
        })
        
        if(reserve.includes(item)) {
            lost = lost.filter((lostItem) => lostItem !== item)
            reserve = reserve.filter((reserveItem) => reserveItem !== item)
            answer.push(item);
        }
    });
    
    lost.sort((a,b) => a-b);
    reserve.sort((a,b) => a-b);
    
    // 3. reserve 학생이 lost학생에게 체육복을 빌려줄 수 있는 경우 배열에 추가
    reserve.forEach((resStu) => {
        let front = resStu-1;
        let back = resStu+1;
        let resStuCnt = 0;
        
        // lost 학생 중복처리
        lost.forEach((lostStu) => {
            if(resStuCnt === 0) {
                if(front === lostStu || back === lostStu) {
                    if(!answer.includes(lostStu)) {
                        answer.push(lostStu);
                        resStuCnt += 1;
                    }
                }
            }
        })
    })
    
    answer = [...new Set(answer)]; // 중복 제거
    return answer.length;
}