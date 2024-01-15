const [...input] = require("fs")
  .readFileSync("/dev/stdin")
  .toString()
  .split("\n")
  .map((i) => i.split(" ").map((str) => +str));

const N = input.length;

for (let i = 0; i < N; i++) {
  if (input[i][0] === 0 || input[i][1] === 0) {
    break;
  }
  if (input[i][1] % input[i][0] === 0) {
    console.log("factor");
  } else if (input[i][0] % input[i][1] === 0) {
    console.log("multiple");
  } else {
    console.log("neither");
  }
}
