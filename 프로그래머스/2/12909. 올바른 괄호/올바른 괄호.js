function solution(s){
    let answer = true;
    let sScore = 0;

    // 문자열 s를 배열로 바꾸기
    s = s.split("");
    
    // s 배열의 길이가 1 or 닫는괄호로 시작 시, false return
    if(s.length === 1 || s[0] === ")") return false;
    
    // s에서 '('인 경우 +1 , ')'인 경우 -1해서 합이 0이면 true, 아니면 false
    s.forEach((item, idx) => {
        if(item === "(") {
            sScore++;
        }
        else {
            // 여는 괄호가 없는 경우 false
            if(sScore < 1) {
                 answer = false;
                 return false;
            }
        sScore--;
        }
    });
    
    return sScore === 0 ? answer = true : answer = false;
}