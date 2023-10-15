function solution(number) {
    let answer = 0;
    
    // number 배열의 길이 만큼 순회해서 모든 조합 만들기(중복 없이)
    for(let i=0; i<number.length; i++) {
        for(let j=i+1; j<number.length; j++) {
            for(let k=j+1; k<number.length; k++) {
                if(number[i] + number[j] +number[k] === 0) {
                    answer += 1;
                }
            }
        }
    }
    
    return answer;
}