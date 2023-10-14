const getGCM = (n, m) => {
    // 최대공약수 - 유클리드 호제법
    // n % m = r (r이 0이 될때까지 반복)
    return m > 0 ? getGCM(m, n % m) : n;
}

function solution(n, m) {
    const answer = [];
    
    // 최대공약수
    answer.push(getGCM(n,m));
    
    // 최대공배수 = (두 자연수의 곱 / 최대공약수)
    answer.push((n*m) / getGCM(n,m));
    
    return answer;
}