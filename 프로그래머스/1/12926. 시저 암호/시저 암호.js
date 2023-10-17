function solution(s, n) {
    // 알파벳 문자열 -> 배열로 변경
    let numberArr = s.split('');
    
    // 문자열 -> utf-16 변환
    let codeArr = numberArr.map((item) => item.charCodeAt());
    
    // 변환된 값 +n (띄어쓰기, a-z, A-Z 범위 예외)
    codeArr = codeArr.map((item) => {
        if(item === 32) return item;
        else if(65 <= item && 90 >= item) {
            return item + n > 90? item + n -26 : item + n;
        }else if(97 <= item && 122 >= item) {
            return item + n > 122? item + n -26 : item + n;
        }
    });
    
    // 변환된 값 -> 문자열로 변경
    numberArr = codeArr.map((item) => String.fromCharCode(item));
    
    // 문자열 배열 -> join후, 문자열로 변경
    console.log(numberArr.join('').toString());
    return numberArr.join('').toString();
}