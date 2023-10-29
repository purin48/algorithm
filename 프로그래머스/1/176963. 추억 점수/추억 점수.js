function solution(name, yearning, photo) {
    let answer = [];
    const nameScore = [];
    
    // name과 yearning 매치
    for(let i=0; i<name.length; i++) {
        let obj = {
            name:name[i],
            score:yearning[i]
        };
        nameScore.push(obj);
    }
    
    // photo 배열 속 name에 해당하는 사람의 추억점수 더하기
    photo.forEach((item) => {
        let score = 0;
        nameScore.forEach((nameScoreItem) => {
            if(item.includes(nameScoreItem.name)) {
                score += nameScoreItem.score;
            }
        });
        answer.push(score);
    })
    
    return answer;
}