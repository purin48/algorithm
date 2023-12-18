function solution(s) {
    const [...input] = s.split(" ").map(item => item.split(""));
    let answer = [];
    
    // 고려사항 : 첫문자 대문자 / 첫문자 제외문자들은 소문자
    input.forEach((item) => {
        let arr = [];
        item.forEach((str, idx) => {
            idx === 0 ? arr.push(str.toUpperCase()) : arr.push(str.toLowerCase())
        })
        answer.push(arr);
    })
    
    // 2차 배열 join으로 붙여주기
    answer.forEach((item, idx) => {
        answer[idx] = item.join("");
    })
    
    return answer.join(" ");
}