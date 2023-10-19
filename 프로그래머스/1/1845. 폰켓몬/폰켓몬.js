function solution(nums) {
    let distinctArr = [];
    let pickNum = nums.length / 2;
    
    // 중복숫자 빼고 distinctArr 에 넣어주기
    nums.forEach((item) => {
        if(!distinctArr.includes(item)) {
            distinctArr.push(item);
        }
    })
    
    return pickNum < distinctArr.length ? pickNum : distinctArr.length;
}