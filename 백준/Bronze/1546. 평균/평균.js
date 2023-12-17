const [n, ...input] = require("fs")
  .readFileSync("/dev/stdin")
  .toString()
  .trim()
  .split(/\s/)
  .map((item) => +item);

input.sort((a, b) => a - b);
const maxScore = input[input.length - 1];
const newScoreArr = [];

for (let i = 0; i < n; i++) {
  newScoreArr.push((input[i] / maxScore) * 100);
}

let average = newScoreArr.reduce((prev, cur) => prev + cur) / n;
console.log(average);