function solution(n) {
    let answer = 0;
    
    // 10진법 -> 3진법 -> 뒤집고 -> 다시 10진법
    const triArr = n.toString(3).split('');
    answer = parseInt(triArr.reverse().join('').toString(), 3);
    
    return answer;
}