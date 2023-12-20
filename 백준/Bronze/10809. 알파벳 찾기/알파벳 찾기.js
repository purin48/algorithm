const [...str] = require("fs")
  .readFileSync("/dev/stdin")
  .toString()
  .trim()
  .split("");

const arr = [];
const answer = [];

for (let i = 97; i <= 122; i++) {
  arr.push(String.fromCharCode(i));
}

arr.forEach((alphabet) => {
  str.includes(alphabet) ? answer.push(str.indexOf(alphabet)) : answer.push(-1);
});

console.log(answer.join(" "));