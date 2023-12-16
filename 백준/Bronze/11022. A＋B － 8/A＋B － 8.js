const input = require("fs")
  .readFileSync("/dev/stdin")
  .toString()
  .trim()
  .split(/\s/)
  .map((item) => +item);

const testcaseCnt = input[0];
const testcaseArr = input.splice(1);
let caseNum = 1;
const resultArr = [];

for (let i = 0; i < testcaseArr.length; i += 2) {
  resultArr.push(testcaseArr[i] + testcaseArr[i + 1]);
}

for (let i = 0; i < testcaseCnt; i++) {
  console.log(
    `Case #${caseNum}: ${testcaseArr[i * 2]} + ${testcaseArr[i * 2 + 1]} = ${
      resultArr[i]
    }`
  );
  caseNum += 1;
}
