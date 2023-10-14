function solution(s) {
    let answer = [];
    
    // 배열로 변경
    let stringArr = s.split(" ");
    
    // 각 1개 단어의 index 짝수마다 대문자 | 홀수마다 소문자
    stringArr.forEach((stringItem, idx) => {
        let itemArr = stringItem.split('');
        itemArr.forEach((item, idx) => {
            idx % 2 === 0 ? itemArr[idx] = item.toUpperCase() : itemArr[idx] = item.toLowerCase()
        })
        answer.push(itemArr.join('').toString());
    })
    
    answer = answer.join(' ').toString();
    
    return answer;
}