function solution(arr)
{
    const answer = [];

    arr.forEach((curNum, idx) => {
        if(arr[idx+1] !== curNum) {
            answer.push(curNum);
        }
    })
    
    return answer;
}