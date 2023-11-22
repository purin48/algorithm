function solution(n) {
    const numSet = new Set();
    
    // 효율성 테스트 오류 - 에라토스테네스의 체 활용
    // 2 ~ n까지의 수를 set에 add
    for(let i=2; i<=n; i++){
        numSet.add(i);
    }
    
    // n의 제곱근의 범위만큼 반복
    for(let j=2; j<=Math.floor(Math.sqrt(n)); j++) {
        // j를 가지고 있다면, 반복해서 j의 배수 삭제
        if(numSet.has(j)) {
            for(let k=j*2; k<=n; k += j) {
                numSet.delete(k);
            }
        }
    }
    
    return numSet.size;
}