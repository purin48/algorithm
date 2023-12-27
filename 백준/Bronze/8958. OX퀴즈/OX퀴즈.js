const [n, ...input] = require("fs")
  .readFileSync("/dev/stdin")
  .toString()
  .trim()
  .split("\n");

input.forEach((line) => {
  const splitedLine = line.split("");
  const arr = [];
  let correctCnt = 1;
  for (let i = 0; i < splitedLine.length; i++) {
    if (splitedLine[i] === "O" && splitedLine[i] === splitedLine[i - 1]) {
      correctCnt += 1;
      arr.push(correctCnt);
    } else if (
      splitedLine[i] === "O" &&
      splitedLine[i] !== splitedLine[i - 1]
    ) {
      correctCnt = 1;
      arr.push(correctCnt);
    } else {
      arr.push(0);
    }
  }
  console.log(arr.reduce((prev, cur) => prev + cur));
});
