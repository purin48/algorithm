const input = require("fs").readFileSync("/dev/stdin").toString().trim();
const printCnt = input / 4;
const printStrArr = [];

for (let i = 0; i < printCnt; i++) {
  printStrArr.push("long");
}
printStrArr.push("int");

console.log(printStrArr.join(" "));
