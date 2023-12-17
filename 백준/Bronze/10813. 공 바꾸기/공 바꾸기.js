const [n, m, ...input] = require("fs")
  .readFileSync("/dev/stdin")
  .toString()
  .trim()
  .split(/\s/)
  .map((item) => +item);

// 바구니와 일치하는 숫자로 채워진 1 ~ n번까지의 바구니 배열 생성
const basketArr = Array(n)
  .fill()
  .map((item, idx) => idx + 1);

// 2개 정수 넣을 배열 생성
const arr = [];
for (let i = 0; i < input.length; i += 2) {
  let arr2 = input.slice(i, i + 2);
  arr.push(arr2);
}

arr.forEach((item) => {
  // i,j가 오면, arr[i]와 arr[j]의 값을 서로 바꾸기
  let a = basketArr[item[0] - 1];
  let b = basketArr[item[1] - 1];
  basketArr[item[0] - 1] = b;
  basketArr[item[1] - 1] = a;
});
console.log(basketArr.join(" "));