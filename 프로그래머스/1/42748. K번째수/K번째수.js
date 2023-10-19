function solution(array, commands) {
    let answer = [];
    
    commands.forEach((item) => {
        let i = item[0]-1;
        let j = item[1];
        let k = item[2]-1;
        answer.push(array.slice(i, j).sort((a,b) => a-b)[k]);
    })
    
    return answer;
}