const [n, ...input] = require("fs")
  .readFileSync("/dev/stdin")
  .toString()
  .trim()
  .split("\n");

let answer = input.length;
let temp = "";

input.forEach((item) => {
  temp = item[0];
  for (let i = 1; i < item.length; i++) {
    // temp에 포함된 문자이면서, 이전 문자와 다른 경우에는 그룹 단어가 아니게 되는 구분요소
    if (temp.includes(item[i]) && item[i - 1] !== item[i]) {
      answer--;
      break;
    }
    temp += item[i];
  }
});

console.log(answer);
