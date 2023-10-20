function solution(numbers, target) {
    let answer = 0;
    let escapeNum = numbers.length;
    
    const bfs = (idx, sum) => {
        // 1. 재귀함수 탈출조건
        // * 재귀함수의 idx 가 numbers의 길이만큼 반복호출 됐을 경우
        if(idx === escapeNum) {
            // 누적합이 target과 같다면 answer에 +1
            if(sum === target) {
                answer++;
            }
            return;
        }
        
        // 2. 누적합에 현재숫자 + call / - call 하는 함수 호출
        bfs(idx + 1, sum + numbers[idx]); // +
        bfs(idx + 1, sum - numbers[idx]); // -
    }
    
    bfs(0,0);
    
    return answer;
}