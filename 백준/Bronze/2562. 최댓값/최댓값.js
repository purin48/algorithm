const [...arr] = require("fs")
  .readFileSync("/dev/stdin")
  .toString()
  .trim()
  .split("\n")
  .map((item) => +item);

const sortArr = [...arr];
sortArr.sort((a, b) => a - b);

console.log(sortArr[sortArr.length - 1]);
console.log(arr.indexOf(sortArr[sortArr.length - 1]) + 1);