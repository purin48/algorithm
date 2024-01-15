const [...input] = require("fs")
  .readFileSync("/dev/stdin")
  .toString()
  .split("\n")
  .map((i) => +i);

for (let i = 0; i < input.length; i++) {
  if (input[i] === -1) {
    break;
  }
  const arr = [];
  for (let j = 1; j <= input[i]; j++) {
    if (input[i] % j === 0 && j !== input[i]) {
      arr.push(j);
    }
  }
  arr.sort((a, b) => a - b);
  const total = arr.reduce((prev, cur) => prev + cur);
  if (total === input[i]) {
    console.log(`${total} = ${arr.join(" + ")}`);
  } else {
    console.log(`${input[i]} is NOT perfect.`);
  }
}
