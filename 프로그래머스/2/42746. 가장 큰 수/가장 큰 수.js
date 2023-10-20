function solution(numbers) {
    let arr = [];
    
    // 1. numbers 배열의 number -> String 으로 변환
    numbers.forEach((item) => {
        arr.push(item.toString());
    });
    
    // 2. 정렬 : (b+a) - (a+b)
    arr = arr.sort((a,b) => (b+a) - (a+b)).join('');
    
    return arr[0] === '0' ? '0' : arr;
}