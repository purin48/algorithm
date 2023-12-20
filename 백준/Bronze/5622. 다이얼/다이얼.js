const [...dialNumArr] = require("fs")
  .readFileSync("/dev/stdin")
  .toString()
  .trim()
  .split("");

// indexArr 배열에 indexArr[유니코드 index]값으로 다이얼 걸리는 시간 넣어주기
// 다이얼숫자 7번 9번은 알파벳이 4개임을 주의..
const indexArr = [
  3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6, 7, 7, 7, 8, 8, 8, 8, 9, 9, 9, 10, 10, 10,
  10,
];

let result = 0;
// 현재 알파벳 유니코드 - A 유니코드로 index 파악
dialNumArr.forEach((item) => {
  result += indexArr[item.charCodeAt() - "A".charCodeAt()];
});
console.log(result);