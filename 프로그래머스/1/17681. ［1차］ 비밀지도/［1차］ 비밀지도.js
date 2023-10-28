function solution(n, arr1, arr2) {
    let answer = [];
    let binaryArr1 = [];
    let binaryArr2 = [];
    
    // arr1 ,arr2 의 각 배열의 이진수로 변경, n자리 수 빈자리 0으로 채우기
    const transNum = (arr, binaryArr) => {
        arr.forEach((item) => {
            binaryArr.push(item.toString(2).padStart(n, 0));
        });
    }
    
    transNum(arr1, binaryArr1);
    transNum(arr2, binaryArr2);
    
    // 1인 경우 "#"으로, 0인 경우 " "으로 변경
    for(let i=0; i<n; i++){
        let answerArr = [];
        for(let j=0; j<n; j++){
            if(binaryArr1[i][j] === "1" || binaryArr2[i][j] === "1") {
                answerArr.push("#");
            } else {
                answerArr.push(" ")
            }
        }
        answer.push(answerArr.join(''));
    }
    return answer;
}