function solution(babbling) {
    let answer = 0;
    const pronun = ["aya", "ye", "woo", "ma"];
    
    for (let i=0; i<babbling.length; i++) {
        let bab = babbling[i];
        
        for (let j=0; j<pronun.length; j++) {
            if(bab.includes(pronun[j].repeat(2))) {
                break;
            }
            bab = bab.split(pronun[j]).join(" ");
            }
        if(bab.split(" ").join("").length === 0){
            answer ++;
        }
    }
    return answer;
}