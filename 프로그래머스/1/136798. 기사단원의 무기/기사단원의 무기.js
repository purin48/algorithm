// 약수 개수 구하기
const isPrime = (num) => {
    let cnt = 0;
    for(let i=1; i<=Math.sqrt(num); i++) {
        if(num % i === 0) {
            if(num / i === i) {
                cnt++;
            }
            else {
                cnt = cnt + 2;
            }
        }
    }
    return cnt;
}

function solution(number, limit, power) {
    let answer = 0;
    let numberArr = [];
    let primeCntArr = [];
    
    // 1 ~ n 까지의 정수 담기
    for(let i=1; i<=number; i++) {
        numberArr.push(i);
    }
    
    // numberArr의 각 정수의 소수가 몇개인지 판별
    numberArr.forEach((item) => {
        let primeNumCnt = 0;
        primeCntArr.push(isPrime(item));
    })
    
    // primeCntArr 요소 중, limit 를 초과하는 값이 있는 경우, power 값으로 대체
    primeCntArr.filter((item, idx) => {
        if(item > limit) {
           primeCntArr.splice(idx,1,power);
        }
    })
    
    // primeCntArr 요소 누적해서 철 무게 구하기
    answer = primeCntArr.reduce((prev, curr) => prev + curr);
    
    return answer;
}