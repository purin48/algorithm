let num = require("fs").readFileSync("/dev/stdin").toString().trim();

let total = 0;

for (let i = 1; i <= num; i++) {
  total += i;
}

console.log(total);
