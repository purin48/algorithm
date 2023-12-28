const [N, B] = require("fs")
  .readFileSync("/dev/stdin")
  .toString()
  .trim()
  .split(" ");

const result = parseInt(N, +B);
console.log(result);