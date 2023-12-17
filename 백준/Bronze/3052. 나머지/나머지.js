const [...arr] = require("fs")
  .readFileSync("/dev/stdin")
  .toString()
  .trim()
  .split("\n")
  .map((item) => +item);

const restArr = new Set();

arr.forEach((num) => {
  restArr.add(num % 42);
});

console.log(restArr.size);
