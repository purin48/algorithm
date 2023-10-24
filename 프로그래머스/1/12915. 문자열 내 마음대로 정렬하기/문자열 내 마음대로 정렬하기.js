function solution(strings, n) {
    
    // sort 정렬
    // * 반환값 < 0 : a가 b보다 앞에
    // * 반환값 > 0 : b가 a보다 앞에
    
    strings.sort((a,b)=>{
        // 1. 문자열 리스트 중 n번째 기준으로 정렬
        if(a[n] !== b[n]){
            return a[n] > b[n] ? 1 : -1
        }
        // string 기준 정렬
        return a > b ? 1 : -1
    })
    return strings
}