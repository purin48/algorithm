const [A, B, C] = require("fs")
  .readFileSync("/dev/stdin")
  .toString()
  .trim()
  .split("\n")
  .map((item) => +item);

// A*B*C 구하고 -> 값 split로 분리 -> Array(10) 생성 후, arr[item] 요소에 +1 카운트
let mutiVal = A * B * C;

const multiValArr = mutiVal.toString().split("");
const cntArr = Array(10).fill(0);

multiValArr.forEach((item) => {
  cntArr[item] += 1;
});

cntArr.forEach((item) => {
  console.log(item);
});