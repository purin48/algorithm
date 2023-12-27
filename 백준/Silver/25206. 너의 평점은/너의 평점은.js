let [...input] = require("fs")
  .readFileSync("/dev/stdin")
  .toString()
  .trim()
  .split("\n")
  .map((item) => {
    return item.split(" ");
  });

const scoreTable = {
  "A+": 4.5,
  "A0": 4.0,
  "B+": 3.5,
  "B0": 3.0,
  "C+": 2.5,
  "C0": 2.0,
  "D+": 1.5,
  "D0": 1.0,
  "F": 0.0,
};

input = input.filter((sub) => sub[2] !== "P");

const scoreArr = [];
const numArr = [];

input.forEach((sub) => {
  let subVal = sub[1] * scoreTable[sub[2]];
  scoreArr.push(subVal);
  numArr.push(sub[1]);
});

const totalSumVal = scoreArr.reduce((prev, cur) => prev + cur, 0);
const totalSubNum = numArr.reduce((prev, cur) => Number(prev) + Number(cur), 0);

if (totalSubNum > 0) {
  console.log(
    (Math.round((totalSumVal / totalSubNum) * 1000000) / 1000000).toFixed(6)
  );
} else {
  console.log(totalSubNum.toFixed(6));
}
