const month = [31,29,31,30,31,30,31,31,30,31,30,31];
const dayName = ['FRI','SAT','SUN','MON','TUE','WED','THU'];

function solution(a, b) {
    let answer = '';
    let monthCnt = 0;
    
    // 해당하는 달에 맞게 날짜 누적
    for(let i=1; i < a; i++) {
        monthCnt += month[i - 1];
    }
    
    // 일수 b-1 , 7의 나머지 값을 day배열에 적용
    monthCnt += b - 1;
    answer = dayName[monthCnt % 7];
    
    return answer;
}