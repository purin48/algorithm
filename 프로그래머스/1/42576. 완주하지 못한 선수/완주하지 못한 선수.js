function solution(participant, completion) {
    // 1. sort 로 배열 정렬
    participant.sort();
    completion.sort();
    
    for(let i=0; i<participant.length; i++) {
        // 2. 참가자 배열과 완주자 배열이 같지 않으면 바로 return
        if(participant[i] !== completion[i]) {
            return participant[i];
        }
    }
}