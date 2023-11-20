// 더한 값이 소수인지 확인하고, 소수가 아니라면 카운트 X / 소수라면 카운트 O 하는 함수
const isPrime = (plus) => {
    // 자연수가 아닌 경우 false
    if(plus < 2) return false;
    
    // 제곱근 범위 나누기법 활용
    // 제곱근 기준으로 제곱근 이하의 작은 값까지만 검사 | floor로 정수 자르기
    for(let i=2; i<=Math.floor(Math.sqrt(plus)); i++){
        if(plus % i === 0) return false;
    }
    return true;
}

function solution(nums) {
    let primeCnt = 0;
    
    // 3개의 합을 추출 후, 배열에 저장
    for(let i=0; i<nums.length; i++){
        for(let j=i+1; j<nums.length; j++){
            for(let k=j+1; k<nums.length; k++){
                let plus = nums[i] + nums[j] + nums[k];
                
                // 소수인 경우, 소수가 되는 경우의 수 +1
                if(isPrime(plus)) primeCnt++;
            }
        }
    }
    
    return primeCnt;
}