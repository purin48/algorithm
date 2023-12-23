const input = require("fs")
  .readFileSync("/dev/stdin")
  .toString()
  .trim()
  .split("\n")
  .map((item) => item.split(" ").map((itemStr) => +itemStr));

const arr = []; // 최댓값 담는 배열

// 각 line의 최댓값 추출 후, arr에 담기
input.forEach((line) => {
  const lineMax = Math.max(...line);
  arr.push(lineMax);
});

// arr 내림차순 정렬
arr.sort((a, b) => b - a);

// 원본 배열에서, 최댓값 행번호, 열번호 출력
input.forEach((line, idx) => {
  line.forEach((lineItem, itemIdx) => {
    if (lineItem === arr[0]) {
      console.log(arr[0]);
      console.log(`${idx + 1} ${itemIdx + 1}`);
    }
  });
});
