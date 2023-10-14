function solution(d, budget) {
    let answer = 0;
    let check = d.sort((a,b) => a-b).reduce((acc, cur) => {
        if((acc + cur <= budget)) {
            console.log(acc);
            console.log(cur);
            answer += 1;
            return acc + cur;
        }
    }, 0);
    
    return answer;
}