function solution(s) {
    let answer = 0;
    const engTable = [
        {
            number : 0,
            word : "zero"
        },
        {
            number : 1,
            word : "one"
        },
        {
            number : 2,
            word : "two"
        },
        {
            number : 3,
            word : "three"
        },
        {
            number : 4,
            word : "four"
        },
        {
            number : 5,
            word : "five"
        },
        {
            number : 6,
            word : "six"
        },
        {
            number : 7,
            word : "seven"
        },
        {
            number : 8,
            word : "eight"
        },
        {
            number : 9,
            word : "nine"
        },
    ];
    
    // 영단어 table 요소만큼 반복 -> 해당되는 단어, 숫자로 변경
    engTable.forEach((item, idx) => {
        s = s.replaceAll(item.word, item.number);
    });
    
    answer = s;
    
    return +answer;
}