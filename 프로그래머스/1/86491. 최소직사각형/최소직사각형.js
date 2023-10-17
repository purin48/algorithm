function solution(sizes) {
    let longerArr = [];
    let shorterArr = [];
    let longest;
    let shortest;
    
    // sizes 의 배열 item을 [작,큰]으로 정렬
    for(let i=0; i<sizes.length; i++) {
        sizes[i].sort((a,b) => b - a);
    }
    
    // item 중에 더 큰 요소 bigger 배열 / 작은 요소 shorter 배열에 넣어주기
    sizes.forEach((item) => {
        if(item[0] > item[1]) {
            longerArr.push(item[0]);
            shorterArr.push(item[1]);
        } else {
            longerArr.push(item[1]);
            shorterArr.push(item[0]);
        }
    });
    
    // 긴 배열, 작은 배열 중 제일 큰 수 추출
    longest = Math.max(...longerArr);
    shortest = Math.max(...shorterArr);
    
    return longest * shortest;
}