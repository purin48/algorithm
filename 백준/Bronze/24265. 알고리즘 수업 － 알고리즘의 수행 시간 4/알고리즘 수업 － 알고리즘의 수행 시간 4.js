const N = Number(require("fs").readFileSync("/dev/stdin").toString());

console.log((N * (N - 1)) / 2);
console.log(2);