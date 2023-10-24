function solution(s) {
    let sArr = s.split("");
    let answer = [];
    let findStrArr = [];
    
    // 처음 나온 문자열 : -1 | 중복된 문자열 : index 찾기
    sArr.forEach((str, idx) => {
        if(!findStrArr.includes(str)) {
            findStrArr.push(str);
            answer.push(-1);
            return;
        }
        if(findStrArr.includes(str)) {
            answer.push(idx - findStrArr.lastIndexOf(str));
            findStrArr.push(str);
            return;
        }
    })
    
    console.log(answer);
    return answer;
}