const [...input] = require("fs")
  .readFileSync("/dev/stdin")
  .toString()
  .trim()
  .split("\n");

// 각 1줄의 최대 글자 수 세기
const lengthArr = [];
input.forEach((line) => {
  lengthArr.push(line.length);
});
const maxLength = Math.max(...lengthArr);

// 입력된 문자열 배열의 세로 순서대로 새로운 배열에 push & 출력
const arr = [];
for (let i = 0; i < maxLength; i++) {
  for (let j = 0; j < input.length; j++) {
    input[j][i] === undefined ? arr.push("") : arr.push(input[j][i]);
  }
}
console.log(arr.join(""));
