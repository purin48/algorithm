function solution(a, b, n) {
    
    const getCoke = (bCnt,cCnt)=>{
       if((bCnt / a) < 1) {
           return cCnt
       } 

       const newBottleCnt = Math.floor(bCnt / a) * b
       const restBottleCnt = bCnt % a

       return getCoke(newBottleCnt+restBottleCnt , cCnt+newBottleCnt)
    }

    const answer = getCoke(n,0)
    return answer;
}