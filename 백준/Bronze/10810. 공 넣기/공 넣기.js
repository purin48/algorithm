const [n, m, ...input] = require("fs")
  .readFileSync("/dev/stdin")
  .toString()
  .trim()
  .split(/\s/)
  .map((item) => +item);

// 기본값 0으로 채워진 1 ~ n번까지의 바구니 배열 생성
const basketArr = Array(n).fill(0, 0);

// 3개 정수 넣을 배열 생성
const arr = [];
for (let i = 0; i < input.length; i += 3) {
  let arr2 = input.slice(i, i + 3);
  arr.push(arr2);
}

arr.forEach((item) => {
  // i,j,k가 오면, i~j까지 k값으로 채우기 : fill(k, i-1, j);
  basketArr.fill(item[2], item[0] - 1, item[1]);
});
console.log(basketArr.join(" "));
