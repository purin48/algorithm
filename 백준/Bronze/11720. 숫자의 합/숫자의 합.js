const [n, input] = require("fs")
  .readFileSync("/dev/stdin")
  .toString()
  .trim()
  .split("\n");

const numArr = [];
for (let i = 0; i < n; i++) {
  numArr.push(+input.substring(i, i + 1));
}
console.log(numArr.reduce((prev, cur) => prev + cur));
