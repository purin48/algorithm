const [n, ...input] = require("fs")
  .readFileSync("/dev/stdin")
  .toString()
  .trim()
  .split("\n")
  .map((item) => {
    return item.split(" ").map((num) => +num);
  });

// 100 * 100으로 채워진 2차원 배열 생성
const matrixArr = Array.from(Array(100), () => Array(100).fill(0));
// 중복요소 제외한 넓이를 카운트 할 변수 생성
let cnt = 0;

// 100 * 100 배열에, 중복되는 요소 제외하고 1 넣어서 넓이 구하기
for (let i = 0; i < n; i++) {
  const startX = input[i][0];
  const startY = input[i][1];
  for (let x = 0; x < 10; x++) {
    for (let y = 0; y < 10; y++) {
      if (matrixArr[startX + x][startY + y] !== 0) {
        continue;
      }
      if (matrixArr[startX + x][startY + y] === 0) {
        matrixArr[startX + x][startY + y] = 1;
        cnt += 1;
      }
    }
  }
}
console.log(cnt);
