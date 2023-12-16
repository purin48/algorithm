const input = require("fs")
  .readFileSync("/dev/stdin")
  .toString()
  .trim()
  .split(/\s/);

const price = +input[0];
const product = input[1];
const recipeArr = input.slice(2, price);
let result = 0;

for (let i = 0; i < recipeArr.length; i += 2) {
  result += recipeArr[i] * recipeArr[i + 1];
}

result === price ? console.log("Yes") : console.log("No");
