const [N, B] = require("fs")
  .readFileSync("/dev/stdin")
  .toString()
  .trim()
  .split(" ")
  .map((item) => +item);

const result = N.toString(B);
console.log(result.toLocaleUpperCase());
