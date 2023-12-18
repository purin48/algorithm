function solution(A,B){
    let answer = 0;

    // 작은 값 * 큰 값의 합들이 결론적으로 작은값이 나온다는 점을 생각해야 함
    // A는 오름차순, B는 내림차순 정렬 후, 각각 곱하면 됨
    A.sort((a,b) => a-b);
    B.sort((a,b) => b-a);
    
    A.forEach((item,idx) => {
        answer += A[idx] * B[idx];
    })

    return answer;
}