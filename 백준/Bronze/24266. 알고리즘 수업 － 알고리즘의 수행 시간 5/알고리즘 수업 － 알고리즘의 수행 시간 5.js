// 문제 입력의 최대 범위가 Number를 초과하기 때문에, BigInt로 변경
const N = BigInt(require("fs").readFileSync("/dev/stdin").toString());

console.log(`${N * N * N}`);
console.log(3);