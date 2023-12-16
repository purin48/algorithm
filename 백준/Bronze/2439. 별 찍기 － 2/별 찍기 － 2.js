const input = require("fs").readFileSync("/dev/stdin").toString().trim();
const starArr = Array(+input).fill(" ", 0);

for (let j = input - 1; j >= 0; j--) {
  starArr.fill("*", j);
  console.log(starArr.join(""));
}
