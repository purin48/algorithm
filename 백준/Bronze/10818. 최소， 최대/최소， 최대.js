const [n, ...arr] = require("fs")
  .readFileSync("/dev/stdin")
  .toString()
  .trim()
  .split(/\s/)
  .map((item) => +item);

arr.sort((a, b) => a - b);
console.log(`${arr[0]} ${arr[arr.length - 1]}`);