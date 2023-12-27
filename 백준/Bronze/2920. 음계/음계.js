const [...input] = require("fs")
  .readFileSync("/dev/stdin")
  .toString()
  .trim()
  .split(" ")
  .map((item) => +item);

let asc = false;
let desc = false;

for (let i = 0; i < input.length - 1; i++) {
  if (input[i] === input[i + 1] - 1) {
    asc = true;
    desc = false;
  } else if (input[i] === input[i + 1] + 1) {
    asc = false;
    desc = true;
  } else if (input[i] !== input[i + 1] - 1 && input[i] !== input[i + 1] + 1) {
    asc = false;
    desc = false;
    break;
  }
}

asc
  ? console.log("ascending")
  : desc
  ? console.log("descending")
  : console.log("mixed");
