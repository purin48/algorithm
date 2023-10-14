function solution(t, p) {
    let answer = 0;
    let tArr = t.split(''); // 배열로 변경
    
    // p의 길이만큼 t배열 부분문자열 자르고 비교
    for(let i=0; i < t.length; i++) {
        if(tArr[i+p.length -1] !== undefined){
            let sliceNum = tArr.slice(i,i+p.length).join('');
            sliceNum <= p ? answer += 1 : ''
        }
    }
    
    return answer;
}