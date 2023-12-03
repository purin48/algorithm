function solution(phone_book) {
    let answer = true;
    
    // * 하나라도 접두어인지 확인
    // 한 전화번호가 다른 번호의 접두어라면 F, 아니면 T 반환
    
    // 1. phone_book 정렬
    phone_book.sort();
    
    // 2. 1중 loop를 돌면서 앞번호가 뒷번호의 접두어인지 확인 함
    for(let i=0; i<phone_book.length - 1; i++){
        if(phone_book[i+1].startsWith(phone_book[i])) {
            answer = false;
        }
    }
    
    // 3. 여기까지 오지 못했다면 접두어가 없는 것
    return answer;
}