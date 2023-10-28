function solution(numbers) {
    let answer = [];
    
    // 서로 다른 index에 있는 두 수 더해서 배열 만들기
    // 오름차순 정렬
    for(let i=0; i<numbers.length; i++){
        for(let j=i+1; j<numbers.length; j++){
            answer.push(numbers[i] + numbers[j]);
        }
    }
    
    // 중복제거 : set => array | 이후 오름차순 정렬
    answer = [...new Set(answer)].sort((a,b) => a - b);
    
    return answer;
}