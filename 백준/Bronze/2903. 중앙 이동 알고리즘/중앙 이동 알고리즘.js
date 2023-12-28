const n = Number(require("fs").readFileSync("/dev/stdin").toString().trim());

// 규칙 : (이전 result 값 + (result ** i)) ** 2 만큼 증가
let result = 2;
for (let i = 0; i < n; i++) {
  result = result + 2 ** i;
}
console.log(result ** 2);