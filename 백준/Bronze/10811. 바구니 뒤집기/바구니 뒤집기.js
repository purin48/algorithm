const [n, m, ...input] = require("fs")
  .readFileSync("/dev/stdin")
  .toString()
  .trim()
  .split(/\s/)
  .map((item) => +item);

const basketArr = Array(n)
  .fill()
  .map((_, idx) => idx + 1);

const arr = [];
for (let i = 0; i < input.length; i += 2) {
  arr.push(input.slice(i, i + 2));
}

arr.forEach((item) => {
  // 원본 배열에서 i,j범위 만큼만 slice -> reverse
  // 원본 배열 i,j 범위 splice를 통해 역순배치 적용
  const reverseArr = basketArr.slice(item[0] - 1, item[1]).reverse();
  basketArr.splice(item[0] - 1, item[1] - item[0] + 1, ...reverseArr);
});
console.log(basketArr.join(" "));