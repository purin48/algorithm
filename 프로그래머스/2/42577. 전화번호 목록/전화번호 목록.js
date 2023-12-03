function solution(phone_book) {
    let answer = true;
    
    // * 하나라도 접두어인지 확인
    // 한 전화번호가 다른 번호의 접두어라면 F, 아니면 T 반환
    
    // 1. HashMap 생성
    const table = {};
    for (const number of phone_book) {
        table[number] = true;
    };
    
    // 2. 모든 전화번호의 접두어가 Hash에 있는 지 확인
    for (const number of phone_book) {
        for (let i = 1; i < number.length; i++) {
          const prefix = number.slice(0, i);
          if (table[prefix]) return false;  
        };
    };
    
    // 3. 여기까지 오지 못했다면 접두어가 없는 것
    return answer;
}