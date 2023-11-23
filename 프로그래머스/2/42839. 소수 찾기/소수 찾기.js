const primeNumSet = new Set();

// 1. 숫자의 조합을 만들어내는 재귀함수
const recursive = (numStr, addNum) => {
    // 1-1. 재귀함수 호출이 처음인 경우 처리
    if(numStr !== "") {
        primeNumSet.add(numStr); // 추가된 str을 set에 추가
    }
    // 1-2. 반복문으로 재귀함수 호출
    // 기존 문자열 + String의 i에 해당하는 문자, 0~i까지의 문자열 이외의 것만 남겨두기
    for(let i=0; i<addNum.length; i++){
        recursive(numStr+addNum.charAt(i), addNum.substring(0,i) + addNum.substring(i+1));
    }
}

function solution(numbers) {
    const arr = [];
    
    // 재귀함수 호출
    recursive("", numbers);
    
    primeNumSet.forEach((item) => arr.push(Number(item)));
    const setNum = new Set(arr); // 중복제거
    
    // 소수 판별
    setNum.forEach((item) => {
        if(item < 2) {
            setNum.delete(item);
        };
        for(let j=2; j<=Math.floor(Math.sqrt(item)); j++){
            if(item % j === 0) {
                setNum.delete(item);
            }
        }
    })
    
    return setNum.size;
}