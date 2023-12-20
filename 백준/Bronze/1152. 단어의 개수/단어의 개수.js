const [...input] = require("fs")
  .readFileSync("/dev/stdin")
  .toString()
  .trim()
  .split(" ");

let cnt = input.length;
input.forEach((item) => {
  item === "" ? (cnt -= 1) : "";
});
console.log(cnt);
